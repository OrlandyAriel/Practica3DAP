package ull.patrones.calculadora.operaciones;
/**
 * @author Orlandy Ariel S�nchez A.
 * Clase que implementa la Interfaz IOperacion, esta es utilizada para la operaci�n de multiplicaci�n
 */
public class Multiplicacion implements IOperacion
{
	@Override
	public double operacion(double a_num1, double a_num2)
	{
		return a_num1 * a_num2;
	}
}
