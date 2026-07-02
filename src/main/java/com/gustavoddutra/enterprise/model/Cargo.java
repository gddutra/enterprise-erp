package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 02/07/2026
 */

@Entity
@Table(name = "tb_cargo", comment = "Cadastro central de cargos dos funcionários do ERP")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_cargo")
    @SequenceGenerator(name = "seq_id_cargo", sequenceName = "seq_id_cargo", initialValue = 1, allocationSize = 1)
    @Column(name = "id_cargo", comment = "Chave primária da tabela de cargos (Gerada via SEQUENCE Oracle)")
    private Long id;
    @Column(name = "nm_cargo", nullable = false, length = 50, comment = "Nome do cargo ou função (ex: Analista de Sistemas Senior, Gerente Financeiro)")
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", nullable = false, length = 20, comment = "Indicador de status do cargo: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro do cargo no sistema")
    private LocalDateTime dataCadastro;
}
