package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import com.gustavoddutra.enterprise.model.enums.TipoCliente;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 08/06/2026
 */
@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_id_cliente")
    @SequenceGenerator(name = "seq_id_cliente", sequenceName = "seq_id_cliente", allocationSize = 1, initialValue = 1)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false, length = 15)
    private TipoCliente tipoCliente;
    @Column(name = "razao_social", length = 150)
    private String razaoSocial;
    @Column(name = "nome_fantasia", length = 60)
    private String nomeFantasia;
    @Column(name = "numero_documento", nullable = false, length = 14, unique = true)
    private String numeroDocumento;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "telefone", length = 15)
    private String telefone;
    @Column(name = "celular", length = 15)
    private String celular;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_cadastro")
    private StatusCadastro statusCadastro;
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;
}
