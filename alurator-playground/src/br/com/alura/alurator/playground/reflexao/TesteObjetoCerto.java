package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TesteObjetoCerto  {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		
		Class<SubControle> controleClasse1 = SubControle.class;
		
		Class<?> controleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Constructor<SubControle> constructorSubControle = controleClasse1.getDeclaredConstructor();
		
		constructorSubControle.setAccessible(true);
		SubControle subControle = constructorSubControle.newInstance();
		
		System.out.println(subControle);
	}
	
}