package ull.patrones.calculadora.opeciones.representacion;

import java.awt.Insets;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class Boton extends JButton
{
	private String m_sim;
	public Boton(String a_simbolo)
	{
		super(a_simbolo);
		m_sim = a_simbolo;
		initComponent();
	}
	private void initComponent()
	{	
		setVisible(true);
		//setBackground(Color.WHITE);
		setMargin(new Insets(5, 5, 5, 5));
	}
	public String getSimbolo()
	{
		return m_sim;
	}
	private double m_valor;
	public void setValor()
	{
		if(m_sim.matches("##.##"))
			m_valor = Double.parseDouble(m_sim);
		else 
			m_valor = 0;
	}
	public double getValor()
	{
		return m_valor;
	}
}

