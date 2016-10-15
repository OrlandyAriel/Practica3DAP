package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.representacion.DivisionButton;

public class CalculadoraFrame 
{
	private JFrame m_ventana;
	private JLabel m_display;
	
	private JPanel m_panelArriba;
	private JPanel m_panelIzquierdo;
	private JPanel m_panelDerecho;
	
	private DivisionButton m_division;
	
	public CalculadoraFrame()
	{
		initComponent();
	}
	private void initComponent()
	{
		m_ventana = new JFrame("Práctica 3 DAP- Caluladora");
		m_ventana.setLayout(new BorderLayout());
		m_ventana.setVisible(true);
		m_ventana.setSize(300, 400);
		m_ventana.setResizable(false);
		m_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ventana.setLocationRelativeTo(null);
		m_display = new JLabel("prueba texto");
		m_display.setVisible(true);
		m_ventana.getContentPane().add(m_display, BorderLayout.NORTH);
	}
	
	
	
}
