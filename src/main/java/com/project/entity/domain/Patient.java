package com.project.entity.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@Table(name = "Paciente")

public class Patient {
    @Id

    private Integer documento;
    private String primeroNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Integer edad;
    private Integer eapbId;
    private Integer regimenId;
    private Boolean servicioSaludActivo;
    private Integer telefonoPersonal;
    private Integer telefonoFamiliar;
    private String direccionResidencia;
    private Integer ipsId;
    private Date fechaUltimaMenstruacion;
    private Boolean primerEmbarazo;
    private Date fechaUltimoParto;
    private Date fechaProbableParto;
    private Integer antecedentesId;
    private Integer registroId;
    private Boolean pacienteDesaparecida;
    private Boolean pacienteAsa;
    private String riesgoEventoTromboembolico;
}