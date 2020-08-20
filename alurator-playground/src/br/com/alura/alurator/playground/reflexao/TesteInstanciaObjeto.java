package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class<Controle> controleClasse1 = Controle.class;
	
		
		Class<? extends Controle> controleClasse2 = new Controle().getClass();
		
		Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Object objetoControle = controleClasse1.newInstance();
		
		System.out.println(objetoControle instanceof Controle);
	}
}
