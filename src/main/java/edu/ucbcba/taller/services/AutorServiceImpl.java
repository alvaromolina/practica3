package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Autor;
import edu.ucbcba.taller.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by alvaro on 26/4/17.
 */
@Service
public class AutorServiceImpl implements AutorService {

    private AutorRepository autorRepository;

    @Autowired
    @Qualifier(value = "autorRepository")
    public void setAutorRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Iterable<Autor> listAllAutors() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getAutorById(Integer id) {
        return autorRepository.findOne(id);
    }

    @Override
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Integer id) {
        autorRepository.delete(id);
    }
}
