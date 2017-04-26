package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.Autor;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}