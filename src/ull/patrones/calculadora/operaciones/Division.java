package ull.patrones.calculadora.operaciones;

public class Division implements IOperacion
{
	@Override
	public double operacion(double a_num1, double a_num2)
	{
		return a_num1 / a_num2;
	}
}
