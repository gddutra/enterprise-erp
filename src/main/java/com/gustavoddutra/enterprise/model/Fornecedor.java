package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 22/06/2026
 */
@Entity
@Table(name = "tb_fornecedor", comment = "Cadastro central de fornecedores do ERP")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_fornecedor")
    @SequenceGenerator(name = "seq_id_fornecedor", sequenceName = "seq_id_fornecedor", allocationSize = 1, initialValue = 1)
    @Column(name = "id_fornecedor", comment = "Chave primária da tabela de fornecedores (Gerada via SEQUENCE Oracle)")
    private Long id;
    @Column(name = "nm_razao_social", length = 150, nullable = false, comment = "Razão Social completa e oficial da empresa fornecedora")
    private String razaoSocial;
    @Column(name = "nm_fantasia", length = 60, comment = "Nome comercial ou de fachada do fornecedor")
    private String nomeFantasia;
    @Column(name = "nr_cnpj", length = 14, nullable = false, unique = true, comment = "Número do CNPJ do fornecedor sem formatação")
    private String cnpj;
    @Column(name = "nr_inscricao_estadual", length = 20, comment = "Inscrição Estadual do fornecedor para fins de substituição tributária e emissão de NF-e")
    private String inscricaoEstadual;
    @Column (name = "tx_email", length = 50, comment = "E-mail de contato principal para envio de pedidos de compra e cotações")
    private String email;
    @Column(name = "nr_telefone", length = 15, comment = "Número de telefone fixo comercial do fornecedor com DDD e sem formatação")
    private String telefone;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", length = 20, comment = "Indicador de status do fornecedor: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro do fornecedor no sistema (Auditoria permanente)")
    private LocalDateTime dataCadastro;
}
