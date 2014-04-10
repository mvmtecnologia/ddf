package br.com.dicadefarmacia.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RemedioFarmaciaDTO implements Serializable {

	private Integer idRemedio;
	private Integer idFarmacia;
	private String nomeCompleto;
	private String nomeFabricante;
	private String generico;
	private String dosagem;
	private String forma;
	private String foto;
	private String principioAtivo;
	private String bairro;
	private String cidade;
	private String estado;
	private String logradouro;
	private String nomeFarmacia;
	private String telefone1;
	private String telefone2;
	private Double preco;
	private Double precoPromocao;
	
	public Integer getIdRemedio() {
		return idRemedio;
	}
	public void setIdRemedio(Integer idRemedio) {
		this.idRemedio = idRemedio;
	}
	public Integer getIdFarmacia() {
		return idFarmacia;
	}
	public void setIdFarmacia(Integer idFarmacia) {
		this.idFarmacia = idFarmacia;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	public String getGenerico() {
		return generico;
	}
	public void setGenerico(String generico) {
		this.generico = generico;
	}
	public String getDosagem() {
		return dosagem;
	}
	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}
	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
		this.forma = forma;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPrincipioAtivo() {
		return principioAtivo;
	}
	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNomeFarmacia() {
		return nomeFarmacia;
	}
	public void setNomeFarmacia(String nomeFarmacia) {
		this.nomeFarmacia = nomeFarmacia;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getPrecoPromocao() {
		return precoPromocao;
	}
	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}
	
}
