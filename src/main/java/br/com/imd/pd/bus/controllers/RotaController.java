package br.com.imd.pd.bus.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.imd.pd.bus.models.Rota;

@Controller
public class RotaController {

    @GetMapping("/")
    public String listarRotas(Model model) {
        // Aqui você pode obter as informações das rotas do seu sistema
        // e passá-las para o modelo para serem exibidas na página
         try {
            // Chama o método getRotas da classe HttpUtils para obter a lista de rotas do Orion
            List<Rota> rotas = HttpUtils.getRotas("http://localhost:1026/v2/entities", null);

            // Passa as rotas para o modelo para serem exibidas na página
            model.addAttribute("rotas", rotas);
        } catch (IOException e) {
            System.out.println("estou tendo o erro : ");
            // Trate o erro de alguma forma apropriada, como exibir uma mensagem de erro na página
            e.printStackTrace();
        }
        
        return "listar_rotas"; // nome da página HTML para exibir a lista de rotas
    }

    // Método de exemplo para obter as rotas do sistema
    private List<Rota> obterRotasDoSistema() {
        // Aqui você pode implementar a lógica para obter as rotas do sistema
        // Pode ser a partir de um banco de dados, serviço externo, etc.
        // Retorne uma lista de objetos Rota com as informações necessárias
        return null;
        }
}
