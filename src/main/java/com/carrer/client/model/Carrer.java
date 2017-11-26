package com.carrer.client.model;

import com.carrer.client.validate.ValidationMessages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "carrer")
public class Carrer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
    @NotNull(message = ValidationMessages.MESSAGE_QUANT_NOT_NULL)
    private BigDecimal quantidade;
    @NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
    private BigDecimal idUser;
    @NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
    private BigDecimal idProduto;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public BigDecimal getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }
}
