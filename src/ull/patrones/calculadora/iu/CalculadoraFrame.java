package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ull.patrones.calculadora.opeciones.Division;
import ull.patrones.calculadora.opeciones.IOperacion;
import ull.patrones.calculadora.opeciones.representacion.Boton;
import ull.patrones.calculadora.opeciones.representacion.DivisionButton;
import ull.patrones.calculadora.opeciones.representacion.MultiplicacionButton;
import ull.patrones.calculadora.opeciones.representacion.RestaButton;
import ull.patrones.calculadora.opeciones.representacion.SumaButton;

public class CalculadoraFrame extends JFrame
{
	private static JLabel m_display;
	
	private static String m_resultado;//
	
	private GridBotones m_gridBotones;
	
	private Boton m_botonContex;

	private double m_primerOperando;
	private double m_segundoOperando;
	
	public CalculadoraFrame()
	{
		m_resultado = "0.0";
		configBotonesNumeros();
		
		initComponent();
	}
	public  void setPantalla(String a_result)
	{
		m_resultado += a_result;
		m_display.setText(m_resultado);
	}
	private void configBotonesNumeros()
	{
		m_gridBotones = new GridBotones();
		configBotonesOperacion();
	}
	private void initComponent()
	{
		configPantalla();
		setTitle("Práctica 3 DAP- Caluladora");
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(260, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().add(m_display, BorderLayout.NORTH);
		this.getContentPane().add(m_gridBotones, BorderLayout.CENTER);
	}
	private void configBotonesOperacion()
	{	
		m_botonContex = new DivisionButton();
		m_botonContex.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				operacionPerformed(new Division());
			}

		});
		m_gridBotones.addBoton(0,3, new DivisionButton());
		m_gridBotones.addBoton(1,3, new MultiplicacionButton());
		m_gridBotones.addBoton(2, 3 , new SumaButton());
		m_gridBotones.addBoton(3,3, new RestaButton());
	}
	private void operacionPerformed(IOperacion a_operacion)
	{
		a_operacion.operacion(m_primerOperando, m_segundoOperando);
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
