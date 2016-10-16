package ull.patrones.calculadora.opeciones.representacion;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class SumaButton extends Boton
{

	private final static String m_simbolo = "+";
	public SumaButton()
	{
		super(m_simbolo);
		setToolTipText(m_simbolo);
		setVisible(true);
	}
}