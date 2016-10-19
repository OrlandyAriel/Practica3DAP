package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ull.patrones.calculadora.opeciones.Division;
import ull.patrones.calculadora.opeciones.Multiplicacion;
import ull.patrones.calculadora.opeciones.Resta;
import ull.patrones.calculadora.opeciones.Suma;
import ull.patrones.calculadora.opeciones.representacion.Boton;
import ull.patrones.calculadora.opeciones.representacion.DivisionButton;
import ull.patrones.calculadora.opeciones.representacion.MultiplicacionButton;
import ull.patrones.calculadora.opeciones.representacion.RestaButton;
import ull.patrones.calculadora.opeciones.representacion.SumaButton;

public class FrameCalculadora extends JFrame
{
	private JLabel m_display;
	private boolean m_oper2;
	private String m_resultado;//

	private JPanel m_gridBotones;
	private Boton m_botonContex;

	private double m_primerOperando;
	private double m_segundoOperando;

	private static Contexto m_contexto;
	private Boton[][] m_ArrayBoton;

	public FrameCalculadora()
	{
		m_resultado = "0.0";
		configPanelBotones();

		initComponent();
	}

	private void configPanelBotones()
	{
		m_gridBotones = new JPanel();
		m_gridBotones.setLayout(new GridLayout(4, 4));
		m_gridBotones.setVisible(true);
		m_gridBotones.setBorder(new EmptyBorder(4, 4, 4, 4));
		configBotonesNumeros();
		configBotonesOperacion();
	}

	public void setPantalla(String a_result)
	{

		if (m_resultado.equals("0.0") )
			m_resultado = a_result;
		else
			m_resultado += a_result;
			

		m_display.setText(m_resultado);
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

	private void configBotonesNumeros()
	{
		m_ArrayBoton = new Boton[4][4];
		int t_count = 1;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				Boton t_btn = new Boton(t_count + "");
				t_btn.addActionListener(
						new ActionListener()
						{
							@Override
							public void actionPerformed(ActionEvent e)
							{
								setPantalla(t_btn.getSimbolo());
							}
						}
				);
				m_ArrayBoton[i][j] = t_btn;
				t_count++;
			}
		}
		m_ArrayBoton[3][0] = new Boton(".");
		m_ArrayBoton[3][1] = new Boton("0");
		Boton igual = new Boton("=");
		igual.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				operacionPerformed();
				
			}
		});
		m_ArrayBoton[3][2] = igual;
		
		configBotonesOperacion();
		anadirBotones();
	}
	private void resetPantalla()
	{
		m_display.setText(m_resultado);
	}
	private void anadirBotones()
	{
		for (int i = 0; i < m_ArrayBoton.length; i++)
		{
			for (int j = 0; j < m_ArrayBoton[0].length; j++)
			{
				m_gridBotones.add(m_ArrayBoton[i][j]);
			}
		}
	}

	private void configBotonesOperacion()
	{
		m_botonContex = new DivisionButton();
		m_botonContex.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						m_contexto = new Contexto(new Division());
						setPantalla(m_botonContex.getText());
						guardNumero();
						m_oper2 = true;
					}
				}
		);
		m_ArrayBoton[0][3] = m_botonContex;
		m_botonContex =  new MultiplicacionButton();
		m_botonContex.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						m_contexto = new Contexto(new Multiplicacion());
						setPantalla(m_botonContex.getText());
						guardNumero();
						m_oper2 = true;
					}
				}
		);
		m_ArrayBoton[1][3] =m_botonContex;
		m_botonContex =  new SumaButton();
		m_botonContex.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						m_contexto = new Contexto(new Suma());
						setPantalla(m_botonContex.getText());
						guardNumero();
						m_oper2 = true;
					}
				}
		);
		m_ArrayBoton[2][3] =m_botonContex;
		m_botonContex =  new RestaButton();
		m_botonContex.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						m_contexto = new Contexto(new Resta());
						setPantalla(m_botonContex.getText());
						guardNumero();
						m_oper2 = true;
					}
				}
		);
		m_ArrayBoton[3][3] = m_botonContex;
	}

	private void guardNumero()
	{
		String aux = m_display.getText();
		String[] operand = aux.split("x|\\/|\\+|-|=");
		if (m_oper2 == true)
			m_segundoOperando = Double.parseDouble(operand[1]);
		else
			m_primerOperando = Double.parseDouble(operand[0]);

	}

	private void operacionPerformed()
	{
		guardNumero();
		m_primerOperando = m_contexto.ejecutarEstrategia(m_primerOperando, m_segundoOperando);
		m_oper2 = false;
		m_resultado = m_primerOperando+"";
		resetPantalla();
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
