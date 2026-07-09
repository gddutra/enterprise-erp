package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 08/07/2026
 */

@Entity
@Table(name = "tb_unidade_medida", comment = "Cadastro central de unidades de medida do ERP (ex: Unidade, Quilograma, Litro)")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_unidade_medida")
    @SequenceGenerator(name = "seq_id_unidade_medida", sequenceName = "seq_id_unidade_medida", initialValue = 1, allocationSize = 1)
    @Column(name = "id_unidade_medida", comment = "Chave primária da tabela de unidades de medida (Gerada via SEQUENCE Oracle)")
    private Long id;
    @Column(name = "sg_unidade_medida", length = 6, nullable = false, unique = true, comment = "Sigla oficial da unidade de medida (ex: UN, KG, LT, CX)")
    private String sigla;
    @Column(name = "tx_descricao", length = 50, nullable = false, comment = "Descrição completa da unidade de medida (ex: Unidade, Quilograma)")
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", length = 20, nullable = false, comment = "Indicador de status da unidade de medida: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro da unidade de medida no sistema")
    private LocalDateTime dataCadastro;
}
