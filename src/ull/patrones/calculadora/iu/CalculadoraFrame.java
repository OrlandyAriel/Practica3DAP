package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalculadoraFrame 
{
	private JFrame m_ventana;
	private static JLabel m_display;
	
	private static String m_resultado;
	private GridBotones m_gridBotones;
	public CalculadoraFrame()
	{
		m_resultado = "0.0";
		configBotonesNumeros();
		initComponent();
		
	}
	public static void setPantalla(String a_result)
	{
		m_resultado += a_result;
		m_display.setText(m_resultado);
	}
	private void configBotonesNumeros()
	{
		m_gridBotones = new GridBotones();
	}
	private void initComponent()
	{
		configPantalla();
		m_ventana = new JFrame("Práctica 3 DAP- Caluladora");
		m_ventana.setLayout(new BorderLayout());
		m_ventana.setVisible(true);
		m_ventana.setSize(260, 200);
		m_ventana.setResizable(false);
		m_ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_ventana.setLocationRelativeTo(null);
		
		m_ventana.getContentPane().add(m_display, BorderLayout.NORTH);
		m_ventana.getContentPane().add(m_gridBotones, BorderLayout.CENTER);
	}
	
	private void configPantalla()
	{
		m_display = new JLabel(m_resultado);
		m_display.setHorizontalAlignment(JLabel.RIGHT);
		m_display.setFont(new Font("Arial", Font.BOLD, 20));
		m_display.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		m_display.setVisible(true);
	}
}
