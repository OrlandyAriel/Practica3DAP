package ull.patrones.calculadora.opeciones.representacion;

import javax.swing.JButton;

public class MultiplicacionButton extends Boton
{
	private final static String m_simbolo = "x";
	public MultiplicacionButton()
	{
		super(m_simbolo);
		setToolTipText(m_simbolo);
		setVisible(true);
	}
}
