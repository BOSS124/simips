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
	public static final int cont = 32;
	private static final int bytesInst = 4;

	private BancoRegistradores banco;
	private String instrucoes[];

	private static final String aritimeticos = "(?i)(add|sub|and|or)\\s*?\\$(s[0-7]|t[0-9]),\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?\\$(s[0-7]|t[0-9]|zero)";
	private static final String loadStore = "(?i)(lw|sw)\\s*?\\$(s[0-7]|t[0-9]),\\s*?(\\d+)\\(\\$(s[0-7]|t[0-9]|zero)\\)";
	private static final String bne = "(?i)bne\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?\\$(s[0-7]|t[0-9]|zero),\\s*?(\\d+)";
	private static final String nop = "(?i)nop";

	public InstCache(int posx, int posy, BancoRegistradores banco) {
		super(posx, posy);

		instrucoes = new String[32];
		for(int i = 0; i < InstCache.cont; i++) {
			instrucoes[i] = "NOP";
		}

		this.banco = banco;
	}

	public int traduzir(int index) {
		int inst = 0;
		int op = 0, rs = 0, rt = 0, rd = 0, shamt = 0, funct = 0, imm = 0;
		Pattern p;
		Matcher m;

		p = Pattern.compile(InstCache.aritimeticos);
		m = p.matcher(instrucoes[index]);

		if(m.matches()) {
			String mne = m.group(1);
			if(mne.equalsIgnoreCase("add")) {
				op = 0x00;
				shamt = 0;
				funct = 0x20;
			}
			else if(mne.equalsIgnoreCase("sub")) {
				op = 0x00;
				shamt = 0;
				funct = 0x22;
			}
			else if(mne.equalsIgnoreCase("and")) {
				op = 0x00;
				shamt = 0;
				funct = 0x24;
			}
			else if(mne.equalsIgnoreCase("or")) {
				op = 0x00;
				shamt = 0;
				funct = 0x25;
			}

			rd = banco.getRegistrador(m.group(2)).getCodigo();
			rs = banco.getRegistrador(m.group(3)).getCodigo();
			rt = banco.getRegistrador(m.group(4)).getCodigo();

			inst |= op << 26;
			inst |= rs << 21;
			inst |= rt << 16;
			inst |= rd << 11;
			inst |= shamt << 6;
			inst |= funct;

			return inst;
		}

		p = Pattern.compile(InstCache.loadStore);
		m = p.matcher(instrucoes[index]);

		if(m.matches()) {
			String mne = m.group(1);
			if(mne.equalsIgnoreCase("lw")) {
				op = 0x23;
			}
			else {
				op = 0x2B;
			}

			rt = banco.getRegistrador(m.group(4)).getCodigo();
			rs = banco.getRegistrador(m.group(2)).getCodigo();
			imm = Integer.parseInt(m.group(3), 10);

			inst |= op << 26;
			inst |= rs << 21;
			inst |= rt << 16;
			inst |= imm;

			return inst;
		}

		p = Pattern.compile(InstCache.bne);
		m = p.matcher(instrucoes[index]);

		if(m.matches()) {
			op = 0x05;
			rs = banco.getRegistrador(m.group(1)).getCodigo();
			rt = banco.getRegistrador(m.group(2)).getCodigo();
			imm = Integer.parseInt(m.group(3), 10);

			inst |= op << 26;
			inst |= rs << 21;
			inst |= rt << 16;
			inst |= imm;

			return inst;
		}

		p = Pattern.compile(InstCache.nop);
		m = p.matcher(instrucoes[index]);

		if(m.matches()) {
			op = 0;
			shamt = 0;
			funct = 0x20;
			rs = 0;
			rt = 0;
			rd = 0;

			inst |= op << 26;
			inst |= rs << 21;
			inst |= rt << 16;
			inst |= rd << 11;
			inst |= shamt << 6;
			inst |= funct;

			return inst;
		}

		return inst;
	}

	public void draw(Graphics grf) {
		int altura = grf.getFontMetrics().getHeight();
		int largura = grf.getFontMetrics().stringWidth("Mem. Instruções");

		grf.drawRect(posx, posy, largura + 10, largura + 10);
		grf.drawString("Mem. Instruções", posx + 5, posy + ((largura + 10) / 2) + (altura / 2));
	}

	public static boolean instrucaoValida(String instrucao) {
		if(Pattern.matches(InstCache.aritimeticos, instrucao)) return true;

		else if(Pattern.matches(InstCache.loadStore, instrucao)) return true;

		else if(Pattern.matches(InstCache.bne, instrucao)) return true;

		else if(Pattern.matches(InstCache.nop, instrucao)) return true;

		else return false;
	}

	public void setInstrucao(int index, String instrucao) {
		if(index >= 0 && index < InstCache.cont && InstCache.instrucaoValida(instrucao)) {
			instrucoes[index] = instrucao;
		}
	}

	public String getInstrucoes() {
		String temp = new String();

		for(int i = 0; i < InstCache.cont; i++) {
			temp = temp.concat(instrucoes[i]);
			if(i < (InstCache.cont - 1)) temp = temp.concat("\n");
		}

		return temp;
	}
}