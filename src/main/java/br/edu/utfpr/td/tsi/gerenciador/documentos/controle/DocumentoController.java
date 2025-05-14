package br.edu.utfpr.td.tsi.gerenciador.documentos.controle;

import java.util.List;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;
import br.edu.utfpr.td.tsi.gerenciador.documentos.service.DocumentoService;

@Controller
public class DocumentoController {

	@Autowired
	private DocumentoService documentoService;
	@Autowired
	private AutorService autorService;



	@GetMapping(value = "/cadastrarDocumento")
	public String exibirPaginaCadastrarDocumento(Model model) {
		List<Autor> autores = autorService.listarTodos();
		model.addAttribute("autores", autores);
		return "cadastrarDocumento";
	}

	@PostMapping(value = "/cadastrarDocumento")
	public String cadastrarDocumento(Documento documento) {
		documentoService.cadastrar(documento);
		return "index";
	}

	@GetMapping(value = "/listarDocumentos")
	public String exibirPaginaListarDocumentos(Model model) {
		List<Documento> documentos = documentoService.listarTodos();
		model.addAttribute("documentos", documentos);
		return "listarDocumentos";
	}

	@GetMapping(value = "/removerDocumento")
	public String removerDocumentos(@RequestParam String idDocumento) {
		documentoService.remover(idDocumento);
		return "index";
	}

}
