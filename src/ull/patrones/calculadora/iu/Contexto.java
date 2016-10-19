package ull.patrones.calculadora.iu;

import ull.patrones.calculadora.opeciones.IOperacion;

public class Contexto
{
	private IOperacion m_operacion;
	
	public Contexto(IOperacion a_operacion)
	{
		this.m_operacion = a_operacion;
	}
	public double ejecutarEstrategia(double a_num1, double a_num2)
	{
		return m_operacion.operacion(a_num1, a_num2);
	}
}
