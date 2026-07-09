package com.gustavoddutra.enterprise.model;

import com.gustavoddutra.enterprise.model.enums.StatusCadastro;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Autor: Gustavo Dutra
 * Data : 16/06/2026
 */
@Entity
@Table(name = "tb_produto", comment = "Cadastro central de produtos e mercadorias do ERP")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_produto")
    @SequenceGenerator(name = "seq_id_produto", sequenceName = "seq_id_produto",  allocationSize = 1, initialValue = 1)
    @Column(name = "id_produto", comment = "Chave primária do produto (Sequence)")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unidade_medida",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_produto_unidade_medida"),
            comment = "Chave estrangeira (FK) conectando o produto à sua respectiva unidade de medida"
    )
    private UnidadeMedida unidadeMedida;
    @Column(name = "cd_gtin", length = 14, unique = true, nullable = false, comment = "Código de barras global do produto (EAN/GTIN)")
    private String gtin;
    @Column(name = "nm_produto", length = 150, nullable = false, comment = "Nome comercial do produto")
    private String nome;
    @Column(name = "ds_produto", length = 500, comment = "Descrição detalhada das características do produto")
    private String descricao;
    @Column(name = "vl_custo", precision = 15, scale = 2, nullable = false, comment = "Preço de custo unitário do produto")
    private BigDecimal precoCusto;
    @Column(name = "vl_venda", precision =  15, scale = 2, nullable = false, comment = "Preço de venda unitário do produto")
    private BigDecimal precoVenda;
    @Enumerated(EnumType.STRING)
    @Column(name = "st_cadastro", length = 20, comment = "Indicador de status do produto: ATIVO, BLOQUEADO ou INATIVO")
    private StatusCadastro statusCadastro;
    @Column(name = "dt_cadastro", nullable = false, updatable = false, comment = "Data e hora do cadastro do produto")
    private LocalDateTime dataCadastro;
}
