package edu.senac.controller;

import edu.senac.dto.AlunoRequest;
import edu.senac.dto.AlunoResponse;
import edu.senac.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/senac")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlunoResponse>> buscarAluno(@RequestParam(value = "nome") String nome) {
        return ResponseEntity.ok(alunoService.buscarAluno(nome));
    }

    @PostMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> criarAluno(@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(alunoService.criarAluno(alunoRequest));
    }

    @PutMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> atualizarAluno(@RequestBody AlunoRequest alunoRequest) {
        return ResponseEntity.ok(alunoService.atualizarAluno(alunoRequest));
    }

    @DeleteMapping(value = "/aluno/{id_aluno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoResponse> excluirAluno(@PathVariable(value = "id_aluno") Integer idAluno) {
        return ResponseEntity.ok(alunoService.excluirAluno(idAluno));
    }

}
