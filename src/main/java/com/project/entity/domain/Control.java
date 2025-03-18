package com.project.entity.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "Control")

public class Control {
    @Id
    private Integer id;
    private Integer numeroControl;
    private Integer semanasGestacion;
    private Integer tensionSistolica;
    private Integer tensionDiastolica;
    private Integer peso;
    private String talla;
    private Integer imc;
    private Integer alturaUterina;
    @ManyToOne
    @JoinColumn(name = "Paciente_Documento", referencedColumnName = "Documento")
    private Patient paciente;
    private Date fechaUltimoControl;
    private Date fechaProximoControl;
    private Boolean asistencia;
}



