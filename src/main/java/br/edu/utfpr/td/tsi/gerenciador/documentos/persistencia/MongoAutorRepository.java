package br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAutorRepository extends MongoRepository<Autor, String> {
}
