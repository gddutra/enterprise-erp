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
@Table(name="tb_cliente", comment = "Cadastro central de clientes do ERP")
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "seq_id_cliente")
    @SequenceGenerator(name = "seq_id_cliente", sequenceName = "seq_id_cliente", allocationSize = 1, initialValue = 1)
    @Column(name = "id_cliente", comment = "Chave primária da tabela de clientes (Gerada via SEQUENCE Oracle)")
    private Long id;
    @Column(name = "nm_cliente", nullable = false, length = 100, comment = "Nome completo do cliente (para Pessoa Física) ou Nome Simplificado/Geral de identificação (para Pessoa Jurídica)")
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(name = "tp_cliente", nullable = false, length = 2, comment = "Tipo de pessoa do cliente para fins fiscais: PF (Pessoa Física) ou PJ (Pessoa Jurídica)")
    private TipoCliente tipoCliente;
    @Column(name = "nm_razao_social", length = 150, comment = "Razão Social completa e oficial da empresa registrada na Junta Comercial (exclusivo para Pessoa Jurídica)")
    private String razaoSocial;
    @Column(name = "nm_fantasia", length = 60, comment = "Nome comercial ou de fachada da empresa (exclusivo para clientes PJ)")
    private String nomeFantasia;
    @Column(name = "nr_documento", nullable = false, length = 14, unique = true, comment = "Número do documento de identificação (CPF para PF ou CNPJ para PJ) sem formatação")
    private String numeroDocumento;
    @Column(name = "tx_email", length = 50, comment = "Endereço de e-mail principal para contato e envio de notas fiscais eletrônicas (NF-e)")
    private String email;
    @Column(name = "nr_telefone", length = 15, comment = "Número de telefone fixo de contato com DDD e sem formatação")
    private String telefone;
    @Column(name = "nr_celular", length = 15, comment = "Número de telefone celular para contato/WhatsApp com DDD e sem formatação")
    private String celular;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", length = 20, comment = "Indicador de status do cliente: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro do cliente")
    private LocalDateTime dataCadastro;
}
