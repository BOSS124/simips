package mips;

import java.util.ArrayList;
import java.awt.Graphics;

public class BancoRegistradores extends Componente {
	private ArrayList<Registrador> registradores;

	public BancoRegistradores(int posx, int posy) {
		super(posx, posy);
		registradores = new ArrayList<Registrador>();

		registradores.add(new Registrador("zero", 0));
		registradores.add(new Registrador("t0", 8));
		registradores.add(new Registrador("t1", 9));
		registradores.add(new Registrador("t2", 10));
		registradores.add(new Registrador("t3", 11));
		registradores.add(new Registrador("t4", 12));
		registradores.add(new Registrador("t5", 13));
		registradores.add(new Registrador("t6", 14));
		registradores.add(new Registrador("t7", 15));
		registradores.add(new Registrador("t8", 24));
		registradores.add(new Registrador("t9", 25));
		registradores.add(new Registrador("s0", 16));
		registradores.add(new Registrador("s1", 17));
		registradores.add(new Registrador("s2", 18));
		registradores.add(new Registrador("s3", 19));
		registradores.add(new Registrador("s4", 20));
		registradores.add(new Registrador("s5", 21));
		registradores.add(new Registrador("s6", 22));
		registradores.add(new Registrador("s7", 23));
	}

	public boolean registradorExiste(String nome) {
		for(Registrador r : registradores) {
			if(r.getNome().equals(nome))
				return true;
		}
		return false;
	}

	public boolean registradorExiste(int codigo) {
		for(Registrador r : registradores) {
			if(r.getCodigo() == codigo)
				return true;
		}
		return false;
	}

	public Registrador getRegistrador(int codigo) {
		for(Registrador r : registradores) {
			if(r.getCodigo() == codigo)
				return r;
		}
		return null;
	}

	public void setValorReg(int codigo, int valor) {
		if(codigo == 0) return;
		for(Registrador r : registradores) {
			if(r.getCodigo() == codigo) {
				r.setValor(valor);
				break;
			}
		}
	}

	public void setValorReg(String nome, int valor) {
		if(nome.equals("zero")) return;
		for(Registrador r : registradores) {
			if(r.getNome().equals(nome)) {
				r.setValor(valor);
				break;
			}
		}
	}



	public void draw(Graphics grf) {

	}
}