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
	private UnidadeControle uncontrole;

	private ArrayList<Componente> componentes;
	private ArrayList<CaminhoDados> caminhos;

	public static boolean modoAuto;

	private boolean modoTroca;
	private boolean entradaPrograma;

	public MIPS() {
		Dimension dim = new Dimension(1000, 700);
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
		
		pc = new ProgramCounter(70, 320);
		somador1 = new Somador(150, 200);
		regaux1 = new RegAuxiliar(270, 180, "PC+4");
		regaux2 = new RegAuxiliar(270, 353, "Inst");
		uncontrole = new UnidadeControle(360, 50);
		

		componentes = new ArrayList<Componente>();
		caminhos = new ArrayList<CaminhoDados>();

		componentes.add(bregs);
		componentes.add(pc);
		componentes.add(instCache);
		componentes.add(somador1);
		componentes.add(regaux1);
		componentes.add(regaux2);
		componentes.add(uncontrole);

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