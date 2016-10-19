package ull.patrones.calculadora.iu;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ull.patrones.calculadora.opeciones.representacion.Boton;

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
				Boton aux = new Boton(t_count+"");
				aux.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
					}
				});
				addBoton(i,j, aux);
				t_count++;
			}
		}
		addBoton(3,0, new Boton("."));
		addBoton(3,1, new Boton("0"));
		addBoton(3,2, new Boton("="));
	}
	
	public void addBoton(int x, int y, Boton a_boton)
	{
		m_ArrayBoton[x][y] = a_boton;
		anadirBotones();
	}
	private void anadirBotones()
	{
		for (int i = 0; i < m_ArrayBoton.length; i++)
		{
			for (int j = 0; j < m_ArrayBoton[0].length; j++)
			{
				if(m_ArrayBoton[i][j]!=null)
					this.add(m_ArrayBoton[i][j]);
			}
		}
	}
}
