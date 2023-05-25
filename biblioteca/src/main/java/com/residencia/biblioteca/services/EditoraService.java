package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.biblioteca.dto.EditoraResumidaDTO;
import com.residencia.biblioteca.dto.LivroResumidoDTO;
import com.residencia.biblioteca.dto.ReceitaWsDTO;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List<Editora> getAllEditora() {
		return editoraRepository.findAll();
	}
	
	public Editora getEditoraById(Integer id) {
		return editoraRepository.findById(id).orElse(null);
	}
	
	public EditoraResumidaDTO getEditoraDTOById(Integer id) {
		Editora editora = editoraRepository.findById(id).orElse(null);
		
		EditoraResumidaDTO editoraResumidaDTO = new EditoraResumidaDTO();
		
		if(editora == null)
			return null;
		
		editoraResumidaDTO.setCodigoEditora(editora.getCodigoEditora());
		editoraResumidaDTO.setNome(editora.getNome());
		
		List<LivroResumidoDTO> listaLivroDTO = new ArrayList<>();
		
		for(Livro l : editora.getListaLivro()) {
			LivroResumidoDTO livroResumidoDTO = new LivroResumidoDTO();
			livroResumidoDTO.setNomeLivro(l.getNomeLivro());
			livroResumidoDTO.setNomeAutor(l.getNomeAutor());
			livroResumidoDTO.setDataLancamento(l.getDataLancamento());
			listaLivroDTO.add(livroResumidoDTO);
		}
		
		editoraResumidaDTO.setListaLivros(listaLivroDTO);
		
		return editoraResumidaDTO;
	}
	
	public Editora saveEditora(Editora editora) {
		return editoraRepository.save(editora);
	}
	
	public EditoraResumidaDTO saveEditoraDTO(EditoraResumidaDTO editoraResumida) {
		
		ReceitaWsDTO recDTO = consultaApiReceitaWs(editoraResumida.getCnpj());
		System.out.println("ReceitaWsDTO: " + recDTO);
		
		Editora editora = new Editora();
		
		editora.setNome(editoraResumida.getNome());
		
		return new EditoraResumidaDTO(editoraRepository.save(editora));
	}
	
	public Editora updateEditora(Editora editora, Integer id) {
		return editoraRepository.save(editora);
	}
	
	public Boolean deleteEditora(Integer id) {
		editoraRepository.deleteById(id);
		Editora editoraDeletada = editoraRepository.findById(id).orElse(null);
		if(editoraDeletada == null)
			return true;
		else 
			return false;
	}
	
	private ReceitaWsDTO consultaApiReceitaWs(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = "https://receitaws.com.br/v1/cnpj/{cnpj}";
		
		Map<String,String> params = new HashMap<String,String>();
		
		params.put("cnpj", cnpj);
		
		ReceitaWsDTO receitaDTO = restTemplate.getForObject(uri, ReceitaWsDTO.class, params);
		
		return receitaDTO;
	}
}
