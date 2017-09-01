package br.unisinos.tradutores.analisadorlexico;

import org.apache.commons.lang3.math.NumberUtils;


public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Boolean result = NumberUtils.isCreatable("5.6.6");
		System.out.println(result);
	}
}
