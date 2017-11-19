import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import mips.InstCache;

public class Simulador extends JFrame implements Runnable {
	public static final String frameTitle = "Simulador MIPS";

	public static boolean info_registradores = false;
	public static boolean info_memoria = false;

	private MIPS mips;
	private boolean fimExec;
	private boolean modoAuto;

	public Simulador() {
		super(frameTitle);

		fimExec = false;
		modoAuto = false;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);

		mips = new MIPS();
		add(mips, BorderLayout.CENTER);
		pack();
		
		mips.createBufferStrategy(2);
		mips.grf = mips.getBufferStrategy().getDrawGraphics();

		setPreferredSize(new Dimension(mips.getWidth(), mips.getHeight()));
		setResizable(false);

		addKeyListener(new KeyAdapter() {
			public void KeyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case VK_R:
					Simulador.info_registradores = true;
					break;

					case VK_M:
					Simulador.info_memoria = true;
					break;
				}
			}

			public void KeyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
					case VK_R:
					Simulador.info_registradores = false;
					break;

					case VK_M:
					Simulador.info_memoria = false;
					break;
				}
			}
		});

		setVisible(true);
	}

	public void render(int tick) {
		mips.render(tick);
	}

	public void run() {
		while(fimExec == false) {

		}
	}
}