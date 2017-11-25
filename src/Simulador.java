import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.image.BufferStrategy;


import javax.swing.JFrame;


import mips.InstCache;

public class Simulador extends JFrame implements Runnable {
	public static final String frameTitle = "Simulador MIPS";

	public static boolean info_registradores = false;
	public static boolean info_memoria = false;

	public static final int maxFPS = 60;

	private MIPS mips;
	private boolean fimExec;

	public Simulador() {
		super(frameTitle);

		fimExec = false;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setFocusable(true);

		mips = new MIPS();
		add(mips, BorderLayout.CENTER);
		pack();

		setPreferredSize(new Dimension(mips.getWidth(), mips.getHeight()));
		setResizable(false);
		setLocationRelativeTo(null);

		setVisible(true);

		mips.requestFocus();
	}

	public void run() {
		long lastRender = 0;
		long msFrame = (1000/(long) Simulador.maxFPS);

		while(fimExec == false) {
			if((System.currentTimeMillis() - lastRender) >= msFrame) {
				mips.render();
				mips.tick();
				lastRender = System.currentTimeMillis();
			}
		}
	}
}