package mips;

public class Registrador {
	private String nome;
	private int valor;
	private int codigo;

	public Registrador(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
		this.valor = 0;
	}

	public String getNome() {
		return nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}
}