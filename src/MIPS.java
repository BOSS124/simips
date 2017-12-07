import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import mips.*;

public class MIPS extends Canvas {
	public Graphics grf;
	public static Font fonteTexto;

	private ProgramInput pi;

	private Multiplexador mux1;
	private ProgramCounter pc;
	private InstCache instCache;
	private Somador somador1;
	private BancoRegistradores bregs;
	private CaminhoDados d1;
	private RegAuxiliar regaux1;
	private RegAuxiliar regaux2;
	private RegAuxiliar regaux3;
	private RegAuxiliar regaux4;
	private RegAuxiliar regaux5;
	private RegAuxiliar regaux6;
	private RegAuxiliar regaux7;
	private RegAuxiliar regaux8;
	private RegAuxiliar regaux9;
	private RegAuxiliar regaux10;
	private RegAuxiliar regaux11;
	private RegAuxiliar regaux12;
	private UnidadeControle uncontrole;
	private ExtensorSinal signextend;
	private ShiftLeft2 shiftleft2;
	private Somador somador2;
	private ULA ula;
	private Multiplexador mux2;
	private ControleULA controleula;
	private Multiplexador mux3;
	private RegAuxiliar regaux13;
	private RegAuxiliar regaux14;
	private RegAuxiliar regaux15;
	private RegAuxiliar regaux16;
	private RegAuxiliar regaux17;
	private RegAuxiliar regaux18;

	private ArrayList<Componente> componentes;
	private ArrayList<CaminhoDados> caminhos;

	public static boolean modoAuto;

	private boolean modoTroca;
	private boolean entradaPrograma;

	public MIPS() {
		Dimension dim = new Dimension(1300, 700);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);
		setSize(dim);
		setFocusable(true);
		setBackground(Color.WHITE);

		fonteTexto = new Font("SansSerif", Font.BOLD, 10);

		modoAuto = false;

		modoTroca = false;
		entradaPrograma = false;

		/* Adicionando componentes do simulador --------------------------------------*/

		bregs = new BancoRegistradores(360, 313);
		instCache = new InstCache(130, 313, bregs);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				pi = new ProgramInput(instCache);
			}
		});
		
		mux1 = new Multiplexador(18, 320, 2) {
			public int getSaida(int seletor) {
				switch(seletor) {
					case 0:
						return entradas[0];
					case 1:
						return entradas[1];
					default:
						return 0;
				}
			}
		};

		pc = new ProgramCounter(70, 320);
		somador1 = new Somador(150, 200);
		regaux1 = new RegAuxiliar(270, 180, "PC+4");
		regaux2 = new RegAuxiliar(270, 353, "Inst");
		uncontrole = new UnidadeControle(360, 50);
		regaux3 = new RegAuxiliar(500, 75, "Ctrl");
		regaux4 = new RegAuxiliar(500, 320, "Read1");
		regaux5 = new RegAuxiliar(500, 370, "Read2");
		signextend = new ExtensorSinal(380, 500);
		regaux6 = new RegAuxiliar(500, 520, "Ins[15-0]");
		regaux7 = new RegAuxiliar(500, 570, "Ins[20-16]");
		regaux8 = new RegAuxiliar(500, 620, "Ins[15-11]");
		shiftleft2 = new ShiftLeft2(580, 230);
		somador2 = new Somador(640, 200);
		ula = new ULA(620, 310);

		mux2 = new Multiplexador(568, 360, 2) {
			public int getSaida(int seletor) {
				switch(seletor) {
					case 0:
						return entradas[0];
					case 1:
						return entradas[1];
					default:
						return 0;
				}
			}
		};

		controleula = new ControleULA(600, 465);

		mux3 = new Multiplexador(580, 560, 2) {
			public int getSaida(int seletor) {
				switch(seletor) {
					case 0:
						return entradas[0];
					case 1:
						return entradas[1];
					default:
						return 0;
				}
			}
		};

		regaux9 = new RegAuxiliar(710, 90, "Ctrl2");
		regaux10 = new RegAuxiliar(710, 240, "PC+Salto");
		regaux11 = new RegAuxiliar(710, 330, "Zero");
		regaux12 = new RegAuxiliar(710, 380, "ULAOut");
		regaux13 = new RegAuxiliar(710, 430, "Read2");
		regaux14 = new RegAuxiliar(710, 472, "DestReg");


		componentes = new ArrayList<Componente>();
		caminhos = new ArrayList<CaminhoDados>();

		componentes.add(bregs);
		componentes.add(pc);
		componentes.add(instCache);
		componentes.add(somador1);
		componentes.add(regaux1);
		componentes.add(regaux2);
		componentes.add(uncontrole);
		componentes.add(regaux3);
		componentes.add(regaux4);
		componentes.add(regaux5);
		componentes.add(signextend);
		componentes.add(regaux6);
		componentes.add(regaux7);
		componentes.add(regaux8);
		componentes.add(mux1);
		componentes.add(shiftleft2);
		componentes.add(somador2);
		componentes.add(ula);
		componentes.add(mux2);
		componentes.add(controleula);
		componentes.add(mux3);
		componentes.add(regaux9);
		componentes.add(regaux10);
		componentes.add(regaux11);
		componentes.add(regaux12);
		componentes.add(regaux13);
		componentes.add(regaux14);

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_SPACE:
					modoTroca = true;
					break;

					case KeyEvent.VK_P:
					entradaPrograma = true;
					break;
				}
			}
		});
	}

	public void tick() {
		if(modoTroca == true) {
			modoAuto = !modoAuto;
			modoTroca = false;
		}

		if(entradaPrograma == true) {
			if(!pi.isShowing()) {
				pi.mostrar();
			}
			entradaPrograma = false;
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics grf = bs.getDrawGraphics();
		grf.setColor(Color.BLACK);
		grf.setFont(MIPS.fonteTexto);

		String modoOp = (MIPS.modoAuto) ? "MODO: Automático" : "MODO: Manual";

		grf.clearRect(0, 0, getWidth(), getHeight());
		
		grf.drawString(modoOp, 1, grf.getFontMetrics().getHeight() + 1);

		for(Componente c : componentes) {
			c.draw(grf);
		}

		for(CaminhoDados cd : caminhos) {
			cd.draw(grf);
		}

		grf.dispose();
		bs.show();
	}
}