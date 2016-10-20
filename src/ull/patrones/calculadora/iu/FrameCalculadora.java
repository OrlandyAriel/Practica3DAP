package ull.patrones.calculadora.iu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ull.patrones.calculadora.operaciones.Contexto;
import ull.patrones.calculadora.operaciones.Division;
import ull.patrones.calculadora.operaciones.IOperacion;
import ull.patrones.calculadora.operaciones.Multiplicacion;
import ull.patrones.calculadora.operaciones.Resta;
import ull.patrones.calculadora.operaciones.Suma;
import ull.patrones.calculadora.operaciones.componente.Boton;
/**
 * 
 * @author Orlandy Ariel Sánchez A.
 * Clase FrameCalculadora, encargada de mostrar los componentes graficos
 */
public class FrameCalculadora extends JFrame
{//ATRIBUTOS
	private JLabel m_pantalla;
	private boolean m_oper2;// "bandera" para saber cuando se espera el siguiente operando
	private String m_resultado;

	private JPanel m_gridBotones;

	private double m_primerOperando;
	private double m_segundoOperando;

	private Contexto m_contexto;
	private Boton[][] m_ArrayBoton;
	private Boton m_botonC;
	//CONSTRUCTOR/ES Y MÉTODOS
	public FrameCalculadora()
	{
		initOperando();
		configPanelBotones();

		initComponent();
	}
	private void initOperando()
	{
		m_resultado = "0.0";
		m_primerOperando = 0;
		m_segundoOperando = 0;
	}
	/**
	 * Método para configurar el panel de los Botones.
	 */
	private void configPanelBotones()
	{
		m_gridBotones = new JPanel();
		m_gridBotones.setLayout(new GridLayout(4, 4));
		m_gridBotones.setVisible(true);
		configBotonC();
		configBotonesNumeros();
		configBotonesOperacion();
	}
	/**
	 * Configura el botón C (Clear), para que borre todo el contenido.
	 */
	private void configBotonC()
	{
		m_botonC = new Boton("C");
		m_botonC.setVisible(true);
		m_botonC.setMargin(new Insets(5, 5, 5, 5));
		m_botonC.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						initOperando();
						resetPantalla();
					}
				}
		);
	}
	private void setPantalla(String a_result)
	{

		if (m_resultado.equals("0.0"))
			m_resultado = a_result;
		else
			m_resultado += a_result;

		m_pantalla.setText(m_resultado);
	}
	/**
	 * Método para inializar la ventana
	 */
	private void initComponent()
	{
		configPantalla();
		setTitle("Práctica 3 DAP- Caluladora");
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(260, 270);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.add(m_pantalla, BorderLayout.NORTH);
		this.add(m_gridBotones, BorderLayout.CENTER);
		this.add(m_botonC, BorderLayout.SOUTH);

	}
	/**
	 * Método par agregar los numeros del 0 al 9, y el .
	 */
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
		m_ArrayBoton[3][0].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						setPantalla(".");
					}
				}
		);
		m_ArrayBoton[3][1] = new Boton("0");
		m_ArrayBoton[3][1].addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setPantalla("0");
			}
		});
		configBotonesOperacion();
		addBotonesGrid();
	}
	/**
	 * Resetea la pantalla y solo muestra el resultado, luego de una operacion
	 */
	private void resetPantalla()
	{
		m_pantalla.setText(m_resultado);
	}
	/**
	 * Añade los botones al gridLayout
	 */
	private void addBotonesGrid()
	{
		for (int i = 0; i < m_ArrayBoton.length; i++)
		{
			for (int j = 0; j < m_ArrayBoton[0].length; j++)
			{
				m_gridBotones.add(m_ArrayBoton[i][j]);
			}
		}
	}
	/**
	 * Crea y configura los botones de las operaciones =,/,*,+ y -
	 */
	private void configBotonesOperacion()
	{
		m_ArrayBoton[3][2] = new Boton("=");
		m_ArrayBoton[3][2].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						operacionIgualPerformed();
					}
				}
		);
		m_ArrayBoton[0][3] = new Boton("/");
		m_ArrayBoton[0][3].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						operacionPerformed(new Division(), m_ArrayBoton[0][3]);
					}
				}
		);
		m_ArrayBoton[1][3] = new Boton("x");
		m_ArrayBoton[1][3].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						operacionPerformed(new Multiplicacion(), m_ArrayBoton[1][3]);
					}
				}
		);
		m_ArrayBoton[2][3] = new Boton("+");
		m_ArrayBoton[2][3].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						operacionPerformed(new Suma(), m_ArrayBoton[2][3]);
					}
				}
		);
		m_ArrayBoton[3][3] = new Boton("-");
		m_ArrayBoton[3][3].addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						operacionPerformed(new Resta(), m_ArrayBoton[3][3]);
					}
				}
		);
	}
	/**
	 * Método que se encarga de guardar la peración y el operando seleccionado
	 * @param a_oper
	 * @param a_btn
	 */
	private void operacionPerformed(IOperacion a_oper, Boton a_btn)
	{
		m_contexto = new Contexto(a_oper);
		setPantalla(a_btn.getText());
		guardarNumeroOperando();
		m_oper2 = true;
	}
	/**
	 * método para guardar el número en el operando adecuado
	 */
	private void guardarNumeroOperando()
	{
		String aux = m_pantalla.getText();
		String[] operand = aux.split("x|\\/|\\+|-|=");
		if (m_oper2 == true)
			m_segundoOperando = Double.parseDouble(operand[1]);
		else
			if(!operand[0].isEmpty())//si hay algún número
				m_primerOperando = Double.parseDouble(operand[0]);
	}
	/**
	 * realiza la operación pertinente según seleccione el usuario
	 */
	private void operacionIgualPerformed()
	{
		if(m_oper2 == true)
		{
			guardarNumeroOperando();
			m_primerOperando = m_contexto.ejecutarEstrategia(m_primerOperando, m_segundoOperando);
			m_oper2 = false;
			m_resultado = m_primerOperando + "";
		}
		resetPantalla();
	}
	/**
	 * Método para configurar la pantalla 
	 */
	private void configPantalla()
	{
		m_pantalla = new JLabel(m_resultado);
		m_pantalla.setHorizontalAlignment(JLabel.RIGHT);
		m_pantalla.setBackground(Color.WHITE);
		m_pantalla.setFont(new Font("Consolas", Font.BOLD, 23));
		m_pantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		m_pantalla.setOpaque(true);
		m_pantalla.setVisible(true);
	}
}
