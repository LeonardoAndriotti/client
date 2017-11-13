package com.carrer.client.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.carrer.client.validate.ValidationMessages;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal id;
	@NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
	private BigDecimal idcarrier;
	@NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
	private String datacriacao;
	@NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
	private String datafinalizado;
	@NotNull(message = ValidationMessages.MESSAGE_FIELD_NOT_NULL)
	private String status;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getIdcarrier() {
		return idcarrier;
	}

	public void setIdcarrier(BigDecimal idcarrier) {
		this.idcarrier = idcarrier;
	}

	public String getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(String datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getDatafinalizado() {
		return datafinalizado;
	}

	public void setDatafinalizado(String datafinalizado) {
		this.datafinalizado = datafinalizado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
