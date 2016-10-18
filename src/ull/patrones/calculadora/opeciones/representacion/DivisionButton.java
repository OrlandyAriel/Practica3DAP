package ull.patrones.calculadora.opeciones.representacion;

@SuppressWarnings("serial")
public class DivisionButton extends Boton
{
	private final static String m_simbolo = "/";
	public DivisionButton()
	{
		super(m_simbolo);
		setToolTipText(m_simbolo);
		setVisible(true);
	}
}
