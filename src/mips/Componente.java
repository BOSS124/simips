package mips;

import java.awt.Graphics;

public abstract class Componente {
	protected int posx;
	protected int posy;

	public Componente(int posx, int posy) {
		this.posx = posx;
		this.posy = posy;
	}

	public abstract void draw(Graphics grf);

	public void setPosX(int posx) {
		this.posx = posx;
	}

	public void setPosY(int posy) {
		this.posy = posy;
	}

	public void moveX(int stepSize) {
		this.posx += stepSize;
	}

	public void moveY(int stepSize) {
		this.posy += stepSize;
	}
}