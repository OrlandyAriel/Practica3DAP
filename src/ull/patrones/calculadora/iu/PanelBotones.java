package ull.patrones.calculadora.iu;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.representacion.Boton;
import ull.patrones.calculadora.opeciones.representacion.DivisionButton;
import ull.patrones.calculadora.opeciones.representacion.IgualButton;
import ull.patrones.calculadora.opeciones.representacion.MultiplicacionButton;
import ull.patrones.calculadora.opeciones.representacion.RestaButton;
import ull.patrones.calculadora.opeciones.representacion.SumaButton;

public class PanelBotones extends JPanel
{
	private ArrayList<Boton> m_arrayBotones;
	
	public PanelBotones()
	{
		initComponent();
	}
	private void initComponent()
	{
		setLayout(new GridLayout(4, 4));
		setVisible(true);
		construirPanel();
	}
	private void construirPanel()
	{
		constrirArray();
		arrayOperacioens();
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				add(m_arrayBotones.get(i+j));
				System.err.println(m_arrayBotones.get(i+j).getSimbolo());
			}
		}
	}
	private void constrirArray()
	{
		m_arrayBotones = new ArrayList<>();
		for (int i = 9; i >=0; i--)
		{
			m_arrayBotones.add(new Boton(""+i));
		}	
	}
	private void arrayOperacioens()
	{
		m_arrayBotones.add(new DivisionButton());
		m_arrayBotones.add(new MultiplicacionButton());
		m_arrayBotones.add(new SumaButton());
		m_arrayBotones.add(new RestaButton());
		m_arrayBotones.add(new IgualButton());
	}
}
