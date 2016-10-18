package ull.patrones.calculadora.opeciones.representacion;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.JButton;

import ull.patrones.calculadora.iu.EventoBoton;


@SuppressWarnings("serial")
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
		setBackground(Color.WHITE);;
		setMargin(new Insets(5, 5, 5, 5));
		this.addActionListener(new EventoBoton(m_sim));
	}
	public String getSimbolo()
	{
		return m_sim;
	}
}
