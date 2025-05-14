package br.edu.utfpr.td.tsi.gerenciador.documentos.service;

import java.util.List;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;

public interface DocumentoService {

	public void cadastrar(Documento documento);

	public List<Documento> listarTodos();

	public void remover(String idDocumento);

}
