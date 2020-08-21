package br.com.alura.alurator;

import br.com.alura.alurator.conversor.ConversorXML;
import br.com.alura.alurator.ioc.ContainerIoC;
import br.com.alura.alurator.protocolo.Request;

public class Alurator {
	
	private String pacoteBase;
	private ContainerIoC container;

	public Alurator(String pacoteBase) {
		this.pacoteBase = pacoteBase;
		this.container = new ContainerIoC();
	}
	
	public Object executa(String url) {
		return new ConversorXML().converte(
				(new ManipuladorObjeto(container.getInstancia(new Reflexao().getClasse(pacoteBase+new Request(url).getNomeControle())))
				    .getMetodo(new Request(url).getNomeMetodo(), new Request(url).getQueryParams())
				    .invoca()));
	}

	public <T, K extends T> void registra(Class<T> tipoFonte, Class<K> tipoDestino) {
		container.registra(tipoFonte, tipoDestino);
	}
}
