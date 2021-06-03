package com.webstore.carvalho.usuario.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

/**
 * @author Alex de Carvalho
 * @version 1.0.0-alpha
 *
 * Classe Model Usuário que representa entidade "usuario" na base de dados
 */
@Entity
@ApiModel(description = "Usuário do Sistema")
@SequenceGenerator(schema = "principal", name = "seq_usuario", sequenceName = "seq_usuario_api", allocationSize = 1)
public class Usuario {

    @ApiModelProperty("Identificador")
    @Getter
    @Id
    @Column(name = "usuarioId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    @ApiModelProperty("Nome do Usuário")
    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    @ApiModelProperty("Email do Usuário")
    @Getter @Setter
    @Email
    @Column(nullable = false)
    private String email;

    @ApiModelProperty("Login de Acesso")
    @Getter @Setter
    private String username;

    @ApiModelProperty("Senha de Acesso")
    @Getter @Setter
    private String password;

    @ApiModelProperty("Data do Cadastro")
    @Getter @Setter
    @Column(nullable = false)
    private LocalDateTime datacadastro = LocalDateTime.now();

    @ApiModelProperty("Usuário ativo no sistema")
    @Getter @Setter
    @Column(nullable = false)
    private Boolean ativo = true;

    public Usuario(){}
}
