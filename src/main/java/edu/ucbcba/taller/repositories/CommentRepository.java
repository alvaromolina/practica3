package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.Comment;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}