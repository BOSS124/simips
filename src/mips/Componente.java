package mips;

import java.awt.Graphics;

public abstract class Componente {
	protected int posx;
	protected int posy;
	protected boolean ativo;

	public Componente(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
		this.ativo = false;
	}

	public abstract void draw(Graphics grf, int tick);
}