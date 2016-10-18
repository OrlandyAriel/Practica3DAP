package ull.patrones.calculadora.iu;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ull.patrones.calculadora.opeciones.representacion.Boton;
import ull.patrones.calculadora.opeciones.representacion.DivisionButton;
import ull.patrones.calculadora.opeciones.representacion.MultiplicacionButton;
import ull.patrones.calculadora.opeciones.representacion.RestaButton;
import ull.patrones.calculadora.opeciones.representacion.SumaButton;

public class GridBotones extends JPanel
{
	private Boton [][] m_ArrayBoton;
	public GridBotones()
	{
		setLayout(new GridLayout(4,4));
		setVisible(true);
		setBorder(new EmptyBorder(4, 4, 4, 4));
		rellenarMatrizBotones();
	
	}
	private void rellenarMatrizBotones()
	{
		m_ArrayBoton = new Boton[4][4];
		int t_count=1;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				m_ArrayBoton[i][j] = new Boton(t_count+"");
				t_count++;
			}
		}
		m_ArrayBoton[0][3] = new DivisionButton();
		m_ArrayBoton[1][3] = new MultiplicacionButton();
		m_ArrayBoton[2][3] = new SumaButton();
		m_ArrayBoton[3][3] = new RestaButton();
		m_ArrayBoton[3][0] = new Boton(".");
		m_ArrayBoton[3][1] = new Boton("0");
		m_ArrayBoton[3][2] = new Boton("=");
		
		anadirBotones();
	}
	private void anadirBotones()
	{
		for (int i = 0; i < m_ArrayBoton.length; i++)
		{
			for (int j = 0; j < m_ArrayBoton[0].length; j++)
			{
				this.add(m_ArrayBoton[i][j]);
			}
		}
	}
}
