package br.com.alura.alurator.playground.controle;

public class SubControle extends Controle {
	
	private SubControle() {}
	
	private SubControle(String s) {}
	
	public void metodoSubControle1() {
		System.out.println("Executando methodo 1");
	}
	
	private String metodoSubControle2() {
		System.out.println("Executando methodo 2");
		return "Executando methodo 2 kkkkkkkkkkkkk";
	}
}
