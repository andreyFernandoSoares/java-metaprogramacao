package br.com.alura.alurator;

public class Reflexao {

	public ManipuladorClasse refleteClasse(String fqn) {
		Class<?> clazz = getClasse(fqn);
		return new ManipuladorClasse(clazz);
	}

	public Class<?> getClasse(String fqn) {
		try {
			Class<?> clazz = Class.forName(fqn);
			return clazz;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
