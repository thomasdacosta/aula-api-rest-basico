package edu.senac.service;

import edu.senac.dto.AlunoRequest;
import edu.senac.dto.AlunoResponse;
import edu.senac.entity.Aluno;
import edu.senac.repository.AlunoRepository;
import edu.senac.utils.AlunoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoResponse criarOuAtualizarAluno(AlunoRequest alunoRequest) {
        Aluno novoAluno = AlunoConverter.toAluno(alunoRequest);
        return AlunoConverter.toAlunoResponse(alunoRepository.save(novoAluno));
    }

    public List<AlunoResponse> buscarAluno(String nome) {
        return alunoRepository.findAlunoByNomeContainingIgnoreCase(nome)
                .stream().map(c -> {
                    return AlunoConverter.toAlunoResponse(alunoRepository.save(c));
                }).collect(Collectors.toList());
    }

    public Integer excluirAluno(Integer idAluno) {
        alunoRepository.deleteById(idAluno);
        return idAluno;
    }

}
