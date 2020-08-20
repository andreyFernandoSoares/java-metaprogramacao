package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Constructor<?> declaredConstructor = controleClasse.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);
		
		Object subcontrole = declaredConstructor.newInstance();
		
		for (Method m : controleClasse.getMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		for (Method m : controleClasse.getDeclaredMethods()) {
			System.out.println(m);
		}
		
		System.out.println();
		
		Method m = controleClasse.getDeclaredMethod("metodoSubControle2");
		m.setAccessible(true);
		Object retorno = m.invoke(subcontrole);
		System.out.println(retorno);
	}

}
