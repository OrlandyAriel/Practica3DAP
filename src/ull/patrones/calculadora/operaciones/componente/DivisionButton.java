package ull.patrones.calculadora.operaciones.componente;

@SuppressWarnings("serial")
public class DivisionButton extends Boton 
{
	private final static String m_simbolo = "/";
	public DivisionButton()
	{
		super(m_simbolo);
		setVisible(true);
	}
}