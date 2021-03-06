package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.descontos.SemDesconto;
@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Sessao sessao;
	
	private BigDecimal preco;
	@ManyToOne
	private Lugar lugar;
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	
	/**
	 *@return 
	 * @deprecated hibernate only
	 */
	
	public Ingresso(){
	}
	


	
	public Ingresso(Sessao sessao,TipoDeIngresso tipoDeIngresso, Lugar lugar){
		this.sessao=sessao;
		this.tipoDeIngresso=tipoDeIngresso;
		this.preco=this.tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar=lugar;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}
	
	public BigDecimal getPreco(){
		return preco.setScale(2, RoundingMode.HALF_UP);
	}
	public void setPreco(BigDecimal preco){
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", sessao=" + sessao + ", preco=" + preco + ", lugar=" + lugar
				+ ", tipoDeIngresso=" + tipoDeIngresso + "]";
	}



		
}
	
	
	
	
	
	
	
	
	

