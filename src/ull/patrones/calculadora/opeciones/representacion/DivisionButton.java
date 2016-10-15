package ull.patrones.calculadora.opeciones.representacion;

import javax.swing.JButton;

public class DivisionButton extends JButton
{
	private final static String m_simbolo = "/";
	public DivisionButton()
	{
		super(m_simbolo);
		setVisible(true);
		setBounds(44, 44, 44, 44);
	}
	
}
