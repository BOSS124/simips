import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Simulador extends JFrame implements Runnable {
	public static final String frameTitle = "Simulador MIPS";
	private MIPS mips;
	private InstCache instCache;

	public Simulador() {
		super(frameTitle);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));

		instCache = new InstCache();
		mips = new MIPS();

		add(instCache);
		add(mips);
		pack();
		setVisible(true);
	}
	
	public void tick() {

	}

	public void render() {
		mips.render();
	}

	public void run() {

	}
}