package com.equifax.trial.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workers")
public class Worker implements Serializable {

    public static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "rut", nullable = false)
    private String dni;

    @Column(name = "activo")
    private Boolean active;

    @Column(name = "fecha_ingreso")
    private Date hireDate;
}
