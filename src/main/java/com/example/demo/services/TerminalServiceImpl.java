package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.services.interfaces.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Terminal;
import com.example.demo.repository.TerminalRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;

@Service
public class TerminalServiceImpl implements TerminalService {

	@Autowired
	private TerminalRepository repo;
	
	public List<Terminal> findAll() {
		return repo.findAll();
	}

	public Terminal findByLogic(Integer logic) {
		Optional<Terminal> terminal =  repo.findByLogic(logic);
		return terminal.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! logic: " + logic + ", Tipo: " + Terminal.class.getName()));
	}

	public Terminal insert(Terminal terminal) {
		return repo.save(terminal);
	}

	public Terminal update(Terminal terminal) {
		Terminal newTerminal = findByLogic(terminal.getLogic());
		updateData(newTerminal, terminal);
		return repo.save(newTerminal);
	}

	private void updateData(Terminal newTerminal, Terminal terminal) {
		newTerminal.setLogic(terminal.getLogic());
		newTerminal.setModel(terminal.getModel());
		newTerminal.setMxf(terminal.getMxf());
		newTerminal.setMxr(terminal.getMxr());
		newTerminal.setPlat(terminal.getPlat());
		newTerminal.setSam(terminal.getSam());
		newTerminal.setSerial(terminal.getSerial());
		newTerminal.setVerfm(terminal.getVerfm());
		newTerminal.setVersion(terminal.getVersion());
		
	}

}
