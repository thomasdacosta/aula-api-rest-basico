package edu.senac.repository;

import edu.senac.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAlunoByNomeContainingIgnoreCase(String nome);

}
