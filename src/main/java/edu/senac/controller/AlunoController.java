package edu.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.senac.dto.AlunoRequest;
import edu.senac.dto.AlunoResponse;
import edu.senac.service.AlunoService;

@RestController
@RequestMapping("/v1/senac")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlunoResponse>> buscarAluno(
    		@RequestParam(value = "nome") String nome) {
        return ResponseEntity.ok(alunoService.buscarAluno(nome));
    }

    @PostMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> criarAluno(
    		@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(alunoService.criarAluno(alunoRequest));
    }

    @PutMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> atualizarAluno(
    		@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(alunoService.atualizarAluno(alunoRequest));
    }

    @DeleteMapping(value = "/aluno/{id_aluno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> excluirAluno(@PathVariable(value = "id_aluno") Integer idAluno) {
        return ResponseEntity.ok(alunoService.excluirAluno(idAluno));
    }

}
