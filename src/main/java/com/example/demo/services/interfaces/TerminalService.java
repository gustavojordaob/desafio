package com.example.demo.services.interfaces;

import com.example.demo.domain.Terminal;

import java.util.List;

public interface TerminalService {

    public List<Terminal> findAll();

    public Terminal findByLogic(Integer logic);

    public Terminal insert(Terminal terminal);

    public Terminal update(Terminal terminal);

}
