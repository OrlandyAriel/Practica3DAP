package ull.patrones.calculadora.opeciones.representacion;

import java.awt.Insets;

import javax.swing.JButton;

public class Boton extends JButton
{
	private String m_sim;
	public Boton(String a_simbolo)
	{
		super(a_simbolo);
		m_sim= a_simbolo;
		initComponent();
	}
	private void initComponent()
	{	
		setVisible(true);
		setMargin(new Insets(15, 15,15, 15));
	}
	public String getSimbolo()
	{
		return m_sim;
	}
	
}
