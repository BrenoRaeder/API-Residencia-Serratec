package com.residencia.biblioteca.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.residencia.biblioteca.dto.UploadArquivoDTO;
import com.residencia.biblioteca.exception.UploadArquivoExcepetion;


@Service
public class UploadArquivoService {
	
	@Value("${pasta.upload.arquivos}")
	private String pastaUploadArquivo;
	
	private Path localArmazenamentoArquivo;
	
	public UploadArquivoDTO armazenaArquivo(MultipartFile file) {
		String clearFileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(clearFileName.contains("..")) {
				throw new UploadArquivoExcepetion("Ocorreu um erro no caminho do arquivo");
			}
			
			this.localArmazenamentoArquivo = Paths.get(pastaUploadArquivo).toAbsolutePath().normalize();
			
			//transformando o local de armazenamento do porperties em um path
			Path pastaDestino = this.localArmazenamentoArquivo.resolve(clearFileName);
			Files.copy(file.getInputStream(), pastaDestino, StandardCopyOption.REPLACE_EXISTING);
		
			return new UploadArquivoDTO(clearFileName, pastaUploadArquivo, file.getContentType(), file.getSize());
		} catch(IOException ex) {
			throw new UploadArquivoExcepetion("Ocorreu um erro ao armazaenar o arquivo");
		}
	
	}
}
