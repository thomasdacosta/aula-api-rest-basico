package edu.senac.service;

import edu.senac.dto.AlunoRequest;
import edu.senac.dto.AlunoResponse;
import edu.senac.entity.Aluno;
import edu.senac.exception.AlunoException;
import edu.senac.repository.AlunoRepository;
import edu.senac.utils.AlunoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private static final String ALUNO_NAO_ENCONTRADO = "Aluno não encontrado";

    @Autowired
    private AlunoRepository alunoRepository;

    public AlunoResponse criarAluno(AlunoRequest alunoRequest) {
        Aluno novoAluno = AlunoConverter.toAluno(alunoRequest);
        return AlunoConverter.toAlunoResponse(alunoRepository.save(novoAluno));
    }

    public AlunoResponse atualizarAluno(AlunoRequest alunoRequest) {
        if (alunoRepository.findById(alunoRequest.getIdAluno()).isEmpty())
            throw new AlunoException(ALUNO_NAO_ENCONTRADO);

        Aluno novoAluno = AlunoConverter.toAluno(alunoRequest);
        return AlunoConverter.toAlunoResponse(alunoRepository.save(novoAluno));
    }

    public List<AlunoResponse> buscarAluno(String nome) {
        return alunoRepository.findAlunoByNomeContainingIgnoreCase(nome)
                .stream().map(c -> AlunoConverter.toAlunoResponse(alunoRepository.save(c))).collect(Collectors.toList());
    }

    public AlunoResponse excluirAluno(Integer idAluno) {
        if (alunoRepository.findById(idAluno).isEmpty())
            throw new AlunoException(ALUNO_NAO_ENCONTRADO);

        AlunoResponse alunoResponse = new AlunoResponse();
        alunoResponse.setIdAluno(idAluno);

        alunoRepository.deleteById(idAluno);
        return alunoResponse;
    }

}
