package ull.patrones.calculadora.operaciones;

public class MainPrac
{
	public static void main(String[] args)
	{
		Contexto a= new Contexto(new Division());
		System.out.println(a.ejecutarEstrategia(6, 2));
		a = new Contexto(new Suma());
		System.out.println(a.ejecutarEstrategia(3, 3));
		a = new Contexto(new Resta());
		System.out.println(a.ejecutarEstrategia(-4, 2));
		a = new Contexto(new Multiplicacion());
		System.out.println(a.ejecutarEstrategia(.3, 6));
	}
}
