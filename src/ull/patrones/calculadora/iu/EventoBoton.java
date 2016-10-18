package ull.patrones.calculadora.iu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventoBoton implements ActionListener
{
	private String m_simbolo;
	public EventoBoton(String a_simbolo)
	{
		m_simbolo = a_simbolo;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		CalculadoraFrame.setPantalla(m_simbolo);
	}
}
