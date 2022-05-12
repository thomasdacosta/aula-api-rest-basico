package edu.senac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.senac.utils.DataDeserializer;
import edu.senac.utils.DataSerializer;

import java.time.Instant;

@JsonPropertyOrder({"nome", "cpf", "rg", "data_nascimento", "endereco", "cep", "cidade", "estado", "curso"})
public class AlunoRequest {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("id_aluno")
    private Integer idAluno;

    @JsonProperty("curso")
    private CursoRequest curso;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("data_nascimento")
    @JsonDeserialize(using = DataDeserializer.class)
    @JsonSerialize(using = DataSerializer.class)
    private Instant dataNascimento;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("estado")
    private String estado;

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public CursoRequest getCurso() {
        return curso;
    }

    public void setCurso(CursoRequest curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
