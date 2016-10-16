package ull.patrones.calculadora.iu;

import java.awt.Button;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ull.patrones.calculadora.opeciones.representacion.DivisionButton;

public class PanelOperaciones extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Button> m_operaciones;
	public PanelOperaciones()
	{
		initComponent();
	}
	private void initComponent()
	{
		operacioens();
		configuracionPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setVisible(true);
		for (int i = 0; i < 5; i++)
		{
			add(new DivisionButton());
		}
	}
	private void configuracionPanel()
	{
		
	}
	private void operacioens()
	{
		m_operaciones = new ArrayList<>();
		//m_operaciones.add(new Division());
	}

}
