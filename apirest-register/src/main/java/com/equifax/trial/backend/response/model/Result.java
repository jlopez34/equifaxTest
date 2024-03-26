package com.equifax.trial.backend.response.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Result implements Serializable {

    @JsonProperty("nombre_input")
    private String nombreInput;

    @JsonProperty("rut_input")
    private String rutInput;

    @JsonProperty("datos")
    private ResultDetail detail;
}
