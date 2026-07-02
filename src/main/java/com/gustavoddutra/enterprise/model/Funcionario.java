package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 02/07/2026
 */
@Entity
@Table(name = "tb_funcionario", comment = "Cadastro central de funcionários do ERP")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_funcionario")
    @SequenceGenerator(name = "seq_id_funcionario", sequenceName = "seq_id_funcionario", initialValue = 1, allocationSize = 1)
    @Column(name = "id_funcionario", comment = "Chave primária da tabela de funcionários (Gerada via SEQUENCE Oracle)")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo", foreignKey = @ForeignKey(name = "fk_funcionario_cargo"), comment = "Chave estrangeira (FK) conectando o funcionário ao seu respectivo cargo em tb_cargo")
    private Cargo cargo;
    @Column(name = "nm_funcionario", length = 100, nullable = false, comment = "Nome completo do colaborador")
    private String nome;
    @Column(name = "nr_cpf", length = 11, nullable = false, unique = true, comment = "Número do CPF do funcionário sem formatação")
    private String cpf;
    @Column(name = "nr_matricula", length = 20, nullable = false, unique = true, comment = "Matrícula interna exclusiva do colaborador no ERP")
    private String matricula;
    @Column(name = "vl_salario", precision = 12, scale = 2, nullable = false, comment = "Valor do salário nominal atual do funcionário")
    private BigDecimal salario;
    @Column(name = "dt_admissao", nullable = false, comment = "Data oficial de admissão do colaborador na empresa")
    private LocalDate dataAdmissao;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", length = 20, comment = "Indicador de status do funcionário: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro do funcionário no sistema")
    private LocalDateTime dataCadastro;

}
