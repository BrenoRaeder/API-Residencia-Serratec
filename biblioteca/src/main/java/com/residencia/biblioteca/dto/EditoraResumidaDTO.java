package com.residencia.biblioteca.dto;

import java.util.List;

import com.residencia.biblioteca.entities.Editora;

public class EditoraResumidaDTO {

	private Integer codigoEditora;
	private String nome;
	private String cnpj;
	private List<LivroResumidoDTO> listaLivros;
	
	public EditoraResumidaDTO() {
		
	}
	
	public EditoraResumidaDTO(Editora editora) {
		this.codigoEditora = editora.getCodigoEditora();
		this.nome = editora.getNome();
	}



	public Integer getCodigoEditora() {
		return codigoEditora;
	}
	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<LivroResumidoDTO> getListaLivros() {
		return listaLivros;
	}
	public void setListaLivros(List<LivroResumidoDTO> listaLivros) {
		this.listaLivros = listaLivros;
	}
}
