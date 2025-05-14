package br.edu.utfpr.td.tsi.gerenciador.documentos.service;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia.MongoAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//criei o pacote service
@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private MongoAutorRepository autorRepository;
    @Override
    public void cadastrar(Autor autor) {
        LocalDate dataNascimento = autor.getDataNascimento();
        int idadeAutor = LocalDate.now().getYear() - dataNascimento.getYear();
        if (idadeAutor >= 18) {
            autorRepository.save(autor);
        }
    }

    @Override
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    @Override
    public void remover(String idAutor) {
        autorRepository.deleteById(idAutor);
    }



}
