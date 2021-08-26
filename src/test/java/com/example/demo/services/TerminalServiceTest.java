package com.example.demo.services;

import com.example.demo.domain.Terminal;
import com.example.demo.repository.TerminalRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import com.example.demo.services.interfaces.TerminalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
public class TerminalServiceTest {

    @InjectMocks
    private TerminalService terminalService = new TerminalServiceImpl();

    @Mock
    private TerminalRepository terminalRepository;

    @Test
    public void shouldGetTerminalList(){
        //ARRANGE
        List<Terminal> terminalList = createListTerminal();
        when(terminalRepository.findAll()).thenReturn(terminalList);

        //ACT
        terminalService.findAll();

        //ASSERT
        verify(terminalRepository, times(1)).findAll();
    }

    @Test
    public void mustGetTerminalByLogic(){
        //ARRANGE
        Optional<Terminal> terminal = createTerminalOptional();
        when(terminalRepository.findByLogic(terminal.get().getLogic())).thenReturn(terminal);

        //ACT
        terminalService.findByLogic(terminal.get().getLogic());

        //ASSERT
        verify(terminalRepository, times(1)).findByLogic(terminal.get().getLogic());
    }

    @Test
    public void mustInsertTerminal(){
        //ARRANGE
        Terminal terminal = createTerminal();
        when(terminalRepository.save(terminal)).thenReturn(terminal);
        //ACT
        terminalService.insert(terminal);

        //ASSERT
        verify(terminalRepository, times(1)).save(terminal);
    }


    @Test
    public void mustUpdateTerminal(){
        //ARRANGE
        Terminal terminal = createTerminal();
        when(terminalRepository.save(terminal)).thenReturn(terminal);
        when(terminalRepository.findByLogic(terminal.getLogic())).thenReturn(Optional.of(terminal));

        //ACT
        terminalService.update(terminal);

        //ASSERT
        verify(terminalRepository, times(1)).save(terminal);
    }

    @Test
    public void shouldGetObjectNotFoundException(){
        //ARRANGE
        Optional<Terminal> terminal = createTerminalOptional();

        //ASSERT
        assertThrows(ObjectNotFoundException.class,
                () -> {
                    terminalService.findByLogic(terminal.get().getLogic());
                }
        );
    }

    private Optional<Terminal> createTerminalOptional() {
        return Optional.ofNullable(Terminal.builder()
                .logic(44332211)
                .model("12212")
                .serial("123")
                .version("1").build());
    }

    private Terminal createTerminal() {
        return Terminal.builder()
                .logic(44332211)
                .model("12212")
                .serial("123")
                .version("1").build();
    }

    private List<Terminal> createListTerminal() {
        return Collections.singletonList(Terminal.builder()
                .logic(44332211)
                .model("12212")
                .serial("123")
                .version("1").build());
    }


}
