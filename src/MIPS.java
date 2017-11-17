import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import java.util.ArrayList;

import mips.Componente;

public class MIPS extends Canvas {
	private ArrayList<Componente> componentes;
	private Graphics grf;

	public MIPS() {
		super();

		setMinimumSize(new Dimension(1000, 720));
		setMaximumSize(new Dimension(1000, 720));
		setPreferredSize(new Dimension(1000, 720));

		componentes = new ArrayList<Componente>();

		createBufferStrategy(2);
		grf = getBufferStrategy().getDrawGraphics();
	}

	public void render(int tick) {
		if(grf == null) return;
		for(Componente c : componentes) {
			if(c != null) {
				c.draw(grf, tick);
			}
		}
	}
}