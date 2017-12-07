package mips;

import java.awt.Graphics;

public class RegAuxiliar extends Componente {
	String nome;
	int valor;

	public RegAuxiliar(int posx, int posy, String nome) {
		super(posx, posy);
		this.nome = nome;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public void draw(Graphics grf) {
		String valorStr = String.format("%1$8X", valor);

		int altura = grf.getFontMetrics().getHeight();
		int larguraValor = grf.getFontMetrics().stringWidth(valorStr);
		int larguraNome = grf.getFontMetrics().stringWidth(nome);
		int largura = (larguraValor >= larguraNome) ? larguraValor : larguraNome;

		grf.drawRect(posx, posy, largura + 6, 2 * altura + 10);
		grf.drawString(nome, posx + 3, posy + altura + 5);
		grf.drawString(valorStr, posx + 3, posy + 2 * altura);
	}
}