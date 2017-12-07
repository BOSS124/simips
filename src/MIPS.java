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
	private BNE bne;
	private MemoriaDados memoria;
	private RegAuxiliar regaux15;
	private RegAuxiliar regaux16;
	private RegAuxiliar regaux17;
	private RegAuxiliar regaux18;
	private RegAuxiliar regaux19;
	private Multiplexador mux4;

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

		caminhos = new ArrayList<CaminhoDados>();

		for(int i = 0; i < 100; i++)
			caminhos.add(new CaminhoDados());
		/* Adicionando componentes do simulador --------------------------------------*/

		bregs = new BancoRegistradores(360, 313);
		caminhos.get(0).novoPonto(new Point(471, 340));
		caminhos.get(0).novoPonto(new Point(500, 340));
		caminhos.get(1).novoPonto(new Point(471, 390));
		caminhos.get(1).novoPonto(new Point(500, 390));

		instCache = new InstCache(130, 313, bregs);
		caminhos.get(2).novoPonto(new Point(233, 373));
		caminhos.get(2).novoPonto(new Point(270, 373));

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
		caminhos.get(3).novoPonto(new Point(48, 368));
		caminhos.get(3).novoPonto(new Point(70, 368));

		pc = new ProgramCounter(70, 320);
		caminhos.get(4).novoPonto(new Point(94, 368));
		caminhos.get(4).novoPonto(new Point(130, 368));

		caminhos.get(5).novoPonto(new Point(112, 368));
		caminhos.get(5).novoPonto(new Point(112, 220));
		caminhos.get(5).novoPonto(new Point(150, 220));

		caminhos.get(6).novoPonto(new Point(130, 280));
		caminhos.get(6).novoPonto(new Point(150, 280));


		somador1 = new Somador(150, 200);
		caminhos.get(7).novoPonto(new Point(200, 250));
		caminhos.get(7).novoPonto(new Point(270, 250));
		caminhos.get(8).novoPonto(new Point(210, 250));
		caminhos.get(8).novoPonto(new Point(210, 180));
		caminhos.get(8).novoPonto(new Point(12, 180));
		caminhos.get(8).novoPonto(new Point(12, 333));
		caminhos.get(8).novoPonto(new Point(20, 333));

		regaux1 = new RegAuxiliar(270, 230, "PC+4");
		caminhos.get(9).novoPonto(new Point(332, 250));
		caminhos.get(9).novoPonto(new Point(500, 250));

		regaux2 = new RegAuxiliar(270, 353, "Inst");
		caminhos.get(10).novoPonto(new Point(332, 373));
		caminhos.get(10).novoPonto(new Point(347, 373));
		caminhos.get(10).novoPonto(new Point(347, 106));
		caminhos.get(10).novoPonto(new Point(360, 106));
		caminhos.get(11).novoPonto(new Point(347, 323));
		caminhos.get(11).novoPonto(new Point(360, 323));
		caminhos.get(12).novoPonto(new Point(347, 343));
		caminhos.get(12).novoPonto(new Point(360, 343));
		caminhos.get(13).novoPonto(new Point(347, 373));
		caminhos.get(13).novoPonto(new Point(347, 537));
		caminhos.get(13).novoPonto(new Point(380, 537));
		caminhos.get(14).novoPonto(new Point(347, 537));
		caminhos.get(14).novoPonto(new Point(347, 590));
		caminhos.get(14).novoPonto(new Point(500, 590));
		caminhos.get(15).novoPonto(new Point(347, 537));
		caminhos.get(15).novoPonto(new Point(347, 640));
		caminhos.get(15).novoPonto(new Point(500, 640));

		uncontrole = new UnidadeControle(360, 50);
		caminhos.get(16).novoPonto(new Point(435, 95));
		caminhos.get(16).novoPonto(new Point(500, 95));

		regaux3 = new RegAuxiliar(500, 75, "Ctrl");
		caminhos.get(17).novoPonto(new Point(562, 95));
		caminhos.get(17).novoPonto(new Point(690, 95));
		caminhos.get(17).novoPonto(new Point(690, 110));
		caminhos.get(17).novoPonto(new Point(710, 110));
		caminhos.get(18).novoPonto(new Point(697, 110));
		caminhos.get(18).novoPonto(new Point(697, 660));
		caminhos.get(18).novoPonto(new Point(595, 660));
		caminhos.get(18).novoPonto(new Point(595, 650));
		caminhos.get(19).novoPonto(new Point(697, 570));
		caminhos.get(19).novoPonto(new Point(640, 570));
		caminhos.get(19).novoPonto(new Point(640, 561));
		caminhos.get(20).novoPonto(new Point(697, 460));
		caminhos.get(20).novoPonto(new Point(588, 460));
		caminhos.get(20).novoPonto(new Point(588, 450));

		regaux19 = new RegAuxiliar(500, 230, "PC+4");
		caminhos.get(21).novoPonto(new Point(562, 250));
		caminhos.get(21).novoPonto(new Point(572, 250));
		caminhos.get(21).novoPonto(new Point(572, 210));
		caminhos.get(21).novoPonto(new Point(625, 210));
		caminhos.get(21).novoPonto(new Point(625, 225));
		caminhos.get(21).novoPonto(new Point(640, 225));

		regaux4 = new RegAuxiliar(500, 320, "Read1");
		caminhos.get(22).novoPonto(new Point(562, 340));
		caminhos.get(22).novoPonto(new Point(620, 340));

		regaux5 = new RegAuxiliar(500, 370, "Read2");
		caminhos.get(23).novoPonto(new Point(562, 390));
		caminhos.get(23).novoPonto(new Point(575, 390));
		caminhos.get(24).novoPonto(new Point(531, 407));
		caminhos.get(24).novoPonto(new Point(531, 455));
		caminhos.get(24).novoPonto(new Point(710, 455));

		signextend = new ExtensorSinal(380, 500);
		caminhos.get(25).novoPonto(new Point(426, 540));
		caminhos.get(25).novoPonto(new Point(500, 540));

		regaux6 = new RegAuxiliar(500, 520, "Ins[15-0]");
		caminhos.get(26).novoPonto(new Point(562, 540));
		caminhos.get(26).novoPonto(new Point(605, 540));
		caminhos.get(27).novoPonto(new Point(565, 540));
		caminhos.get(27).novoPonto(new Point(565, 270));
		caminhos.get(27).novoPonto(new Point(580, 270));
		caminhos.get(28).novoPonto(new Point(565, 425));
		caminhos.get(28).novoPonto(new Point(575, 425));

		regaux7 = new RegAuxiliar(500, 570, "Ins[20-16]");
		caminhos.get(29).novoPonto(new Point(562, 590));
		caminhos.get(29).novoPonto(new Point(580, 590));

		regaux8 = new RegAuxiliar(500, 620, "Ins[15-11]");
		caminhos.get(30).novoPonto(new Point(562, 640));
		caminhos.get(30).novoPonto(new Point(584, 640));

		shiftleft2 = new ShiftLeft2(580, 230);
		caminhos.get(31).novoPonto(new Point(615, 280));
		caminhos.get(31).novoPonto(new Point(640, 280));

		somador2 = new Somador(640, 200);
		caminhos.get(32).novoPonto(new Point(690, 260));
		caminhos.get(32).novoPonto(new Point(710, 260));

		ula = new ULA(620, 310);
		caminhos.get(33).novoPonto(new Point(670, 335));
		caminhos.get(33).novoPonto(new Point(710, 335));

		caminhos.get(34).novoPonto(new Point(670, 385));
		caminhos.get(34).novoPonto(new Point(710, 385));

		mux2 = new Multiplexador(575, 360, 2) {
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
		caminhos.get(35).novoPonto(new Point(604, 390));
		caminhos.get(35).novoPonto(new Point(620, 390));

		controleula = new ControleULA(600, 465);
		caminhos.get(36).novoPonto(new Point(640, 465));
		caminhos.get(36).novoPonto(new Point(640, 400));

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
		caminhos.get(37).novoPonto(new Point(610, 600));
		caminhos.get(37).novoPonto(new Point(710, 600));

		regaux9 = new RegAuxiliar(710, 90, "Ctrl2");
		caminhos.get(38).novoPonto(new Point(772, 110));
		caminhos.get(38).novoPonto(new Point(930, 110));
		caminhos.get(38).novoPonto(new Point(930, 125));
		caminhos.get(38).novoPonto(new Point(950, 125));
		caminhos.get(39).novoPonto(new Point(930, 125));
		caminhos.get(39).novoPonto(new Point(930, 490));
		caminhos.get(39).novoPonto(new Point(865, 490));
		caminhos.get(39).novoPonto(new Point(865, 447));
		caminhos.get(40).novoPonto(new Point(865, 110));
		caminhos.get(40).novoPonto(new Point(865, 330));
		caminhos.get(41).novoPonto(new Point(813, 110));
		caminhos.get(41).novoPonto(new Point(813, 290));


		regaux10 = new RegAuxiliar(710, 240, "PC+Salto");
		caminhos.get(42).novoPonto(new Point(772, 260));
		caminhos.get(42).novoPonto(new Point(787, 260));
		caminhos.get(42).novoPonto(new Point(787, 30));
		caminhos.get(42).novoPonto(new Point(5, 30));
		caminhos.get(42).novoPonto(new Point(5, 390));
		caminhos.get(42).novoPonto(new Point(20, 390));

		regaux11 = new RegAuxiliar(710, 320, "Zero");
		caminhos.get(43).novoPonto(new Point(741, 320));
		caminhos.get(43).novoPonto(new Point(741, 300));
		caminhos.get(43).novoPonto(new Point(800, 300));

		regaux12 = new RegAuxiliar(710, 365, "ULAOut");
		caminhos.get(44).novoPonto(new Point(772, 385));
		caminhos.get(44).novoPonto(new Point(800, 385));
		caminhos.get(45).novoPonto(new Point(786, 385));
		caminhos.get(45).novoPonto(new Point(786, 480));
		caminhos.get(45).novoPonto(new Point(950, 480));

		regaux13 = new RegAuxiliar(710, 430, "Read2");
		caminhos.get(46).novoPonto(new Point(772, 435));
		caminhos.get(46).novoPonto(new Point(800, 435));

		regaux14 = new RegAuxiliar(710, 580, "DestReg");
		caminhos.get(47).novoPonto(new Point(772, 600));
		caminhos.get(47).novoPonto(new Point(950, 600));

		bne = new BNE(800, 290);
		caminhos.get(48).novoPonto(new Point(825, 300));
		caminhos.get(48).novoPonto(new Point(840, 300));
		caminhos.get(48).novoPonto(new Point(840, 40));
		caminhos.get(48).novoPonto(new Point(32, 40));
		caminhos.get(48).novoPonto(new Point(32, 320));

		memoria = new MemoriaDados(800, 330);
		caminhos.get(49).novoPonto(new Point(918, 380));
		caminhos.get(49).novoPonto(new Point(950, 380));

		regaux15 = new RegAuxiliar(950, 105, "Ctrl3");
		caminhos.get(50).novoPonto(new Point(1012, 125));
		caminhos.get(50).novoPonto(new Point(1032, 125));
		caminhos.get(50).novoPonto(new Point(1032, 50));
		caminhos.get(50).novoPonto(new Point(470, 50));
		caminhos.get(50).novoPonto(new Point(470, 300));
		caminhos.get(50).novoPonto(new Point(415, 300));
		caminhos.get(50).novoPonto(new Point(415, 313));
		caminhos.get(51).novoPonto(new Point(1012, 125));
		caminhos.get(51).novoPonto(new Point(1064, 125));
		caminhos.get(51).novoPonto(new Point(1064, 350));

		regaux16 = new RegAuxiliar(950, 360, "MemRd");
		caminhos.get(52).novoPonto(new Point(1012, 380));
		caminhos.get(52).novoPonto(new Point(1050, 380));

		regaux17 = new RegAuxiliar(950, 460, "ULAOut2");
		caminhos.get(53).novoPonto(new Point(1012, 480));
		caminhos.get(53).novoPonto(new Point(1030, 480));
		caminhos.get(53).novoPonto(new Point(1030, 430));
		caminhos.get(53).novoPonto(new Point(1055, 430));

		regaux18 = new RegAuxiliar(950, 580, "DestReg2");
		caminhos.get(54).novoPonto(new Point(1012, 600));
		caminhos.get(54).novoPonto(new Point(1037, 600));
		caminhos.get(54).novoPonto(new Point(1037, 660));
		caminhos.get(54).novoPonto(new Point(340, 660));
		caminhos.get(54).novoPonto(new Point(340, 390));
		caminhos.get(54).novoPonto(new Point(360, 390));

		mux4 = new Multiplexador(1050, 350, 2) {
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
		caminhos.get(55).novoPonto(new Point(1080, 395));
		caminhos.get(55).novoPonto(new Point(1100, 395));
		caminhos.get(55).novoPonto(new Point(1100, 690));
		caminhos.get(55).novoPonto(new Point(355, 690));
		caminhos.get(55).novoPonto(new Point(355, 410));
		caminhos.get(55).novoPonto(new Point(360, 410));

		componentes = new ArrayList<Componente>();

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
		componentes.add(bne);
		componentes.add(memoria);
		componentes.add(regaux15);
		componentes.add(regaux16);
		componentes.add(regaux17);
		componentes.add(regaux18);
		componentes.add(mux4);
		componentes.add(regaux19);

		

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