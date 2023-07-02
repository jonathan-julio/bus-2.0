package br.com.imd.pd.bus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String exibirTelaLogin() {
        return "login"; // nome da página HTML para exibir a tela de login
    }

    // Adicione outros métodos para as opções de gerenciamento de rotas
    // Por exemplo: cadastrarRota(), editarRota(), excluirRota(), etc.
}

