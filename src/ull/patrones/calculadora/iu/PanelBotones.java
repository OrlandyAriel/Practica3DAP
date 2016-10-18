package ull.patrones.calculadora.iu;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.representacion.Boton;
import ull.patrones.calculadora.opeciones.representacion.DivisionButton;
import ull.patrones.calculadora.opeciones.representacion.IgualButton;
import ull.patrones.calculadora.opeciones.representacion.MultiplicacionButton;
import ull.patrones.calculadora.opeciones.representacion.RestaButton;
import ull.patrones.calculadora.opeciones.representacion.SumaButton;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel
{
	private Boton [][] m_ArrayBoton;
	public PanelBotones()
	{
		initComponent();
	}
	private void initComponent()
	{
		setLayout(new GridLayout(5, 5));
		setVisible(true);
		rellenarMatrizBotones();
		construirPanel();
		
	}
	private void rellenarMatrizBotones()
	{
		m_ArrayBoton = new Boton[4][4];
		int t_count=1;
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
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
		m_ArrayBoton[3][2] = new IgualButton();
		
	}
	private void construirPanel()
	{
		
		for (int i = 0; i < m_ArrayBoton.length; i++)
		{
			for (int j = 0; j < m_ArrayBoton.length; j++)
			{
				System.out.println(m_ArrayBoton[i][j].getText());
				this.add(m_ArrayBoton[i][j]);
			}
		}
	}

}
