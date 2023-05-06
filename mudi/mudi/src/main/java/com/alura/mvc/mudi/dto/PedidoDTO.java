package com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusPedidos;

public class PedidoDTO {

	@NotBlank(message = "Preencha o campo")
	private String nomeProduto;
	@NotBlank(message = "Preencha o campo")
	private String urlProduto;
	@NotBlank(message = "Preencha o campo")
	private String urlImg;
	@NotBlank(message = "Preencha o campo")
	private BigDecimal vlr;
	@NotBlank(message = "Preencha o campo")
	private LocalDate dtEntrega;
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public BigDecimal getVlr() {
		return vlr;
	}

	public void setVlr(BigDecimal vlr) {
		this.vlr = vlr;
	}

	public LocalDate getDtEntrega() {
		return dtEntrega;
	}

	public void setDtEntrega(LocalDate dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido p = new Pedido();
		p.setDecricao(descricao);
		p.setNomeProduto(nomeProduto);
		p.setUrlImg(urlImg);
		p.setUrlProduto(urlProduto);
		p.setStatus(StatusPedidos.AGUARDANDO);
		p.setDtEntrega(dtEntrega);
		p.setVlr(vlr);

		return p;
	}

}
