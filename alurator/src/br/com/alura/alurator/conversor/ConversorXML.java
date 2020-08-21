package br.com.alura.alurator.conversor;

import java.lang.reflect.Field;
import java.util.Collection;

import br.com.alura.alurator.anotacao.NomeTagXml;

public class ConversorXML {
	
	public String converte(Object objeto) {
		Class<? extends Object> clazz = objeto.getClass();
		StringBuilder xmlBuilder = new StringBuilder();
		
		try {
			if (objeto instanceof Collection) {
				Collection<?> colecao = (Collection<?>) objeto;
				
				xmlBuilder.append("<lista>");
				
				for (Object o : colecao) {
					String xml = converte(o);
					xmlBuilder.append(xml);
				}
				
				xmlBuilder.append("</lista>");
			} else {
				xmlBuilder.append("<"+clazz.getDeclaredAnnotation(NomeTagXml.class).value()+">");
				
				for (Field atributo : clazz.getDeclaredFields()) {
					atributo.setAccessible(true);
					xmlBuilder.append("<"+atributo.getName()+">");
					xmlBuilder.append(atributo.get(objeto));
					xmlBuilder.append("</"+atributo.getName()+">");
				}
				
				xmlBuilder.append("</"+clazz.getDeclaredAnnotation(NomeTagXml.class).value()+">");
			}
			
			return xmlBuilder.toString();
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
