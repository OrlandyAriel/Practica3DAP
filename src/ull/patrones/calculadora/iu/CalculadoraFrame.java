package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.representacion.DivisionButton;

public class CalculadoraFrame 
{
	private JFrame m_ventana;
	private JLabel m_display;
	
	private double m_resultado;
	
	public CalculadoraFrame()
	{
		m_resultado =0.0;
		initComponent();
		configBotonesNumeros();
	}
	private void initComponent()
	{
		configPantalla();
		m_ventana = new JFrame("Práctica 3 DAP- Caluladora");
		m_ventana.setLayout(new BorderLayout());
		m_ventana.setVisible(true);
		m_ventana.setSize(250, 260);
		m_ventana.setResizable(false);
		m_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ventana.setLocationRelativeTo(null);
		
		m_ventana.getContentPane().add(m_display, BorderLayout.NORTH);
		m_ventana.getContentPane().add(new PanelBotones(), BorderLayout.CENTER);
		
	}
	
	private void configPantalla()
	{
		m_display = new JLabel(m_resultado+"");
		m_display.setHorizontalAlignment(JLabel.RIGHT);
		m_display.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		m_display.setVisible(true);
	}
	private void configBotonesNumeros()
	{
		
	}
}
