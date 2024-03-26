package com.equifax.trial.backend.response.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
public class ResultDetail implements Serializable {

    @JsonProperty("activo")
    private Boolean active;

    @JsonProperty("fecha_ingreso")
    private String hireDate;
}
