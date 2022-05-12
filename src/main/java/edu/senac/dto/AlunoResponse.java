package edu.senac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "nome", "cpf", "rg", "data_nascimento", "endereco", "cep", "cidade", "estado", "curso"})
public class AlunoResponse extends AlunoRequest {

    @JsonProperty("id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
