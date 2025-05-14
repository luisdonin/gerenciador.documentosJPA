package br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;

public interface MongoDocumentoRepository extends MongoRepository<Documento, String> {

}
