package com.webstore.carvalho.usuario.model;

import com.webstore.carvalho.usuario.EscopoPerfil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Perfil do Usuário que representa entidade a qual define se o escopo de um usúario
 * se é Administrador, Gerente, Visitante.... e outros
 */
@Entity
@ApiModel(description = "Perfil do Usuário")
@Table(schema = "principal")
@SequenceGenerator(schema = "principal", name = "seq_perfil", sequenceName = "seq_perfil_api", allocationSize = 1)
public class Perfil {

    @ApiModelProperty("Identificador")
    @Column(name = "perfilId")
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_perfil")
    private Long id;

    @ApiModelProperty("Nome do Perfil")
    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty("Escopo do Perfil")
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    @Column(nullable = false)
    private EscopoPerfil escopoPerfil;

    @ApiModelProperty("Data do Cadastro")
    @Getter @Setter
    @Column(name = "datacadastro", nullable = false)
    private LocalDateTime datacadastro = LocalDateTime.now();

    @ApiModelProperty("Perfil do usuário Ativo")
    @Getter @Setter
    @Column(nullable = false)
    private Boolean ativo = true;

    public Perfil(){}
}