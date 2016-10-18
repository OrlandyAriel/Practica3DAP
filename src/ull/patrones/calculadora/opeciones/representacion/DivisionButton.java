package ull.patrones.calculadora.opeciones.representacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DivisionButton extends Boton
{
	private final static String m_simbolo = "/";
	public DivisionButton()
	{
		super(m_simbolo);
		setVisible(true);
		evento();
	}
	private void evento()
	{
		this.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
	}
}
