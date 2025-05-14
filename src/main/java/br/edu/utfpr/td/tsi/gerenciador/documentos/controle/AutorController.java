package br.edu.utfpr.td.tsi.gerenciador.documentos.controle;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {
    @Autowired
    private AutorService autorService;
    @GetMapping(value = "/cadastrarAutor")
    public String exibirPaginaCadastrarAutor() {
        return "cadastrarAutor";
    }

    @PostMapping(value = "/cadastrarAutor")
    public String cadastrarAutor(Autor autor) {
        autorService.cadastrar(autor);
        return "index";
    }
    /* Pagina cadastrarAutor criada
       Anotações @controller e @GetMapping prontas
    */
}
