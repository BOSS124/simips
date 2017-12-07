package mips;

import java.awt.Graphics;

public class InsIndicador extends Componente {
	private String texto;

	public InsIndicador(int posx, int posy) {
		super(posx, posy);
	}

	public void setInstrucao(String instrucao) {
		texto = instrucao;
	}

	public void draw(Graphics grf) {
		
	}
}