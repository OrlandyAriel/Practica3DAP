package ull.patrones.calculadora.principal;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.Division;
import ull.patrones.calculadora.opeciones.IOperacion;

public class PanelOperaciones extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<IOperacion> m_operaciones;
	public PanelOperaciones()
	{
		initComponent();
	}
	private void initComponent()
	{
		operacioens();
		configuracionPanel();
		for (int i = 0; i < m_operaciones.size(); i++)
		{
			
		}
	}
	private void configuracionPanel()
	{
		
	}
	private void operacioens()
	{
		m_operaciones = new ArrayList<>();
		m_operaciones.add(new Division());
	}

}
