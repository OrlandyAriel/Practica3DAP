package ull.patrones.calculadora.operaciones;
/**
 * @author Orlandy Ariel Sánchez A.
 * Clase que implementa la Interfaz IOperacion, esta es utilizada para la operación de división
 */
public class Division implements IOperacion
{
	@Override
	public double operacion(double a_num1, double a_num2)
	{
		return a_num1 / a_num2;
	}
}
