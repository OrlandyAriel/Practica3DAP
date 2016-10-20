package ull.patrones.calculadora.operaciones.componente;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
/**
 * @author Orlandy Ariel Sánchez A.
 *	Clase que hereda de la clase de java JButton, la cual representará los distintos botones
 */
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
		setFont(new Font("Consolas", Font.BOLD, 23));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setMargin(new Insets(5, 5, 5, 5));
	}
	public String getSimbolo()
	{
		return m_sim;
	}
}

