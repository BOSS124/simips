package mips;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.Graphics;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InstCache extends Componente {
	private static final int cont = 32;
	private static final int bytesInst = 4;

	private String instrucoes[];

	private Font fonteTexto;

	public InstCache(int posx, int posy) {
		super(posx, posy);

		instrucoes = new String[32];
		for(int i = 0; i < InstCache.cont; i++) {
			instrucoes[i] = "NOP";
		}

		fonteTexto = new Font("SansSerif", Font.BOLD, 12);
	}

	/*public int traduzir() {

	}*/

	public void draw(Graphics grf, int tick) {
		grf.setColor(Color.BLACK);
		grf.drawRect(posx, posy, 35, InstCache.cont * 20);

		grf.setFont(fonteTexto);
		int altura = grf.getFontMetrics().getHeight();

		for(int i = 0; i < InstCache.cont; i++) {
			grf.drawString(instrucoes[i], 5, ((((i + 1) * 20) + (i * 20)) / 2) - (altura / 2));
		}
	}

	private boolean instrucaoValida(String instrucao) {
		return true;
	}

	public void setInstruction(int index, String instrucao) {
		if(index >= 0 && index < InstCache.cont && instrucaoValida(instrucao)) {
			instrucoes[index] = Integer.toString(index * 4) + instrucao;
		}
	}
}