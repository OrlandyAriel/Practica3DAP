package ull.patrones.calculadora.opeciones.representacion;

import java.awt.Insets;

import javax.swing.JButton;

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
