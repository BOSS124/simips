package mips;

import java.awt.Graphics;

public class UnidadeControle extends Componente {
	private int inst;
	private int saida;

	public UnidadeControle(int posx, int posy) {
		super(posx, posy);
	}

	public void setInst(int inst) {
		this.inst = inst;
	}

	public int getSaida() {
		int temp = 0;

		if(inst >> 26 == 0) {	//R-format(op == 0)
			temp = 0x182;
		}
		else if(inst >> 26 == 0x23) {	//lw
			temp = 0x2B;
		}
		else if(inst >> 26 == 0x2B) {	//sw
			temp = 0x24;
		}
		else if(inst >> 26 == 0x05) {	//bne
			temp = 0x50;
		}

		return temp;
	}

	public void draw(Graphics grf) {

	}
}