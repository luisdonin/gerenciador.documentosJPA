package br.edu.utfpr.td.tsi.gerenciador.documentos.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;
import br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia.MongoDocumentoRepository;

@Service
public class DocumentoServiceImpl implements DocumentoService {

	@Autowired
	private MongoDocumentoRepository documentoRepository;
	@Autowired
	private AutorService autorService;

	@Override
	public void cadastrar(Documento documento) {
		/*LocalDate dataNascimento = documento.getAutor().getDataNascimento();
		int idadeAutor = Period.between(dataNascimento, LocalDate.now()).getYears();
		if (idadeAutor >= 18) {

		}*/
		documentoRepository.save(documento);
	}

	@Override
	public List<Documento> listarTodos() {
		List<Documento> documentos = documentoRepository.findAll();
		documentos.forEach(doc -> {
			if (doc.getAutor() != null && doc.getAutor().getId() != null) {
				Autor autor = autorService.listarTodos()
						.stream()
						.filter(a -> a.getId().equals(doc.getAutor().getId()))
						.findFirst()
						.orElse(null);
				doc.setAutor(autor);
			}
		});
		return documentos;
	}

	@Override
	public void remover(String idDocumento) {
		documentoRepository.deleteById(idDocumento);
	}

}
