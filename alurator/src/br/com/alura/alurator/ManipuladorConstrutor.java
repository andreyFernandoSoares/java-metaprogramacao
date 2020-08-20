package br.com.alura.alurator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {

	private Constructor<?> construtor;

	public ManipuladorConstrutor(Constructor<?> construtor) {
		this.construtor = construtor;
	}

	public Object invoca() {
		try {
			return construtor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException("Deu erro no construtor ", e.getTargetException());
		}
	}

}
