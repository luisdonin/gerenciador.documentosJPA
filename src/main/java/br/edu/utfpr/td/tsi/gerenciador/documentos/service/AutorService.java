package br.edu.utfpr.td.tsi.gerenciador.documentos.service;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;

import java.util.List;

public interface AutorService {
     void cadastrar(Autor autor);

     List<Autor> listarTodos();

     void remover(String idAutor);


}
//classe autor importada e metodos definidos