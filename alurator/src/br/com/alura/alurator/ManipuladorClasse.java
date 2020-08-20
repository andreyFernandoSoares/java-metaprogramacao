package br.com.alura.alurator;

public class ManipuladorClasse {

	private Class<?> clazz;

	public ManipuladorClasse(Class<?> clazz) {
		this.clazz = clazz;
	}

	public ManipuladorConstrutor getConstrutorPadrao() {
		try {
			return new ManipuladorConstrutor(clazz.getDeclaredConstructor());
		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public ManipuladorObjeto criaInstancia() {
		return new ManipuladorObjeto(getConstrutorPadrao().invoca());
	}
}
