package ull.patrones.calculadora.principal;

import ull.patrones.calculadora.operaciones.Contexto;
import ull.patrones.calculadora.operaciones.Division;
import ull.patrones.calculadora.operaciones.Multiplicacion;
import ull.patrones.calculadora.operaciones.Resta;
import ull.patrones.calculadora.operaciones.Suma;

public class Practica3PruebaEstrategia
{
	private static Contexto m_contexto;
	public static void main(String[] args)
	{
		m_contexto = new Contexto(new Division());
		System.out.println(m_contexto.ejecutarEstrategia(6, 2));
		m_contexto = new Contexto(new Suma());
		System.out.println(m_contexto.ejecutarEstrategia(3, 3));
		m_contexto = new Contexto(new Resta());
		System.out.println(m_contexto.ejecutarEstrategia(-4, 2));
		m_contexto = new Contexto(new Multiplicacion());
		System.out.println(m_contexto.ejecutarEstrategia(.3, 6));
	}
}
