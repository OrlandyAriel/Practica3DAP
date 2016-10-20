package ull.patrones.calculadora.principal;

import ull.patrones.calculadora.operaciones.Contexto;
import ull.patrones.calculadora.operaciones.Division;
import ull.patrones.calculadora.operaciones.Multiplicacion;
import ull.patrones.calculadora.operaciones.Resta;
import ull.patrones.calculadora.operaciones.Suma;

public class Practica3PruebaEstrategia
{
	public static void main(String[] args)
	{
		Contexto t_contexto= new Contexto(new Division());
		System.out.println(t_contexto.ejecutarEstrategia(6, 2));
		t_contexto = new Contexto(new Suma());
		System.out.println(t_contexto.ejecutarEstrategia(3, 3));
		t_contexto = new Contexto(new Resta());
		System.out.println(t_contexto.ejecutarEstrategia(-4, 2));
		t_contexto = new Contexto(new Multiplicacion());
		System.out.println(t_contexto.ejecutarEstrategia(.3, 6));
	}
}
