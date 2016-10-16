package ull.patrones.calculadora.opeciones.representacion;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class RestaButton extends Boton
{
	private final static String m_simbolo = "-";
	public RestaButton()
	{
		super(m_simbolo);
		setToolTipText(m_simbolo);
		setVisible(true);
	}

}
