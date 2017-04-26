package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Autor;

/**
 * Created by alvaro on 26/4/17.
 */
public interface AutorService {
    Iterable<Autor> listAllAutors();

    Autor getAutorById(Integer id);

    Autor saveAutor(Autor autor);

    void deleteAutor(Integer id);
}
