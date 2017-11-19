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
		String aritimeticos = "(?i)(add|sub|and|or)\\s*?\\$(s[0-7]|t[0-9]),\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?\\$(s[0-7]|t[0-9]|zero)";
		String loadStore = "(?i)(lw|sw)\\s*?\\$(s[0-7]|t[0-9]),\\s*?([0-9a-fA-F]{1,2}+)\\(\\$(s[0-7]|t[0-9]|zero)\\)";
		String bne = "(?i)bne\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?([0-9a-fA-F]{1,2}+)";

		if(Pattern.matches(aritimeticos, instrucao)) return true;

		else if(Pattern.matches(loadStore, instrucao)) return true;

		else if(Pattern.matches(bne, instrucao)) return true;

		else return false;
	}

	public void setInstruction(int index, String instrucao) {
		if(index >= 0 && index < InstCache.cont && instrucaoValida(instrucao)) {
			instrucoes[index] = instrucao;
		}
	}
}