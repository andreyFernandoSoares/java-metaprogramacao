package br.com.alura.alurator;

import br.com.alura.alurator.protocolo.Request;

public class Alurator {
	
	private String pacoteBase;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
		
	}
	
	public Object executa(String url) {
	   
	   return new Reflexao().refleteClasse(pacoteBase+new Request(url).getNomeControle())
                            .criaInstancia()
							.getMetodo(new Request(url).getNomeMetodo(), new Request(url).getQueryParams())
							.invoca();
	}
}
