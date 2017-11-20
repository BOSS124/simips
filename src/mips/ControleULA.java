package mips;

import java.awt.Graphics;

public class ControleULA extends Componente {
	public ControleULA(int posx, int posy) {
		super(posx, posy);
	}

	public static int getULAControle(int funct, int ulaOp) {
		switch(ulaOp) {
			case 2:	//R-type
			if(funct == 0x20) return 2;
			if(funct == 0x22) return 6;
			if(funct == 0x24) return 0;
			if(funct == 0x25) return 1;
			break;

			case 0:	//Load Store
			return 2;

			case 1:	//branch
			return 6;
		}

		return 0;
	}

	public void draw(Graphics grf) {

	}
}