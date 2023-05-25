package com.residencia.biblioteca.dto;

public class ReceitaWsDTO {

	private String nome;
	private String situacao;
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String uf;
	private String cep;
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ReceitaWsDTO [nome=" + nome + ", situacao=" + situacao + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", numero=" + numero + ", bairro=" + bairro + ", uf=" + uf + ", cep=" + cep + ", email="
				+ email + "]";
	}
	
	
	
	
//	 "uf": "SP",
//	  "complemento": "GALPAO DE ESTOCAGEM DOCAS F03 A F18 L06 E L07",
//	  "situacao": "ATIVA",
//	  "tipo": "FILIAL",
//	  "nome": "AMERICANAS S.A - EM RECUPERACAO JUDICIAL",
//	  "bairro": "PRESIDENTE ALTINO",
//	  "atividade_principal": [
//	    {
//	      "code": "47.89-0-99",
//	      "text": "Comércio varejista de outros produtos não especificados anteriormente"
//	    }
//	  ],
//	  "logradouro": "R HENRY FORD",
//	  "numero": "643",
//	  "abertura": "22/08/1995",
//	  "data_situacao": "03/11/2005",
//	  "natureza_juridica": "204-6 - Sociedade Anônima Aberta",
//	  "telefone": "(11) 4003-4848/ (11) 4003-5544",
//	  "cep": "06.210-108",
//	  "porte": "DEMAIS",
//	  "email": "fiscal.nfe@b2wdigital.com",
}
