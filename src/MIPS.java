import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import mips.*;

public class MIPS extends Canvas {
	public Graphics grf;
	public static Font fonteTexto;

	private ProgramCounter pc;
	private InstCache instCache;
	private BancoRegistradores bregs;
	private CaminhoDados d1;

	public MIPS() {
		Dimension dim = new Dimension(1000, 700);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);
		setSize(dim);
		setBackground(Color.WHITE);

		fonteTexto = new Font("SansSerif", Font.BOLD, 12);

		pc = new ProgramCounter(150, 320);
		bregs = new BancoRegistradores(500, 500);
		instCache = new InstCache(5, 20, bregs);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics grf = bs.getDrawGraphics();
		grf.setFont(MIPS.fonteTexto);

		String modoOp = (Simulador.modoAuto) ? "MODO: Automático" : "MODO: Manual";

		grf.clearRect(0, 0, getWidth(), getHeight());
		
		grf.drawString(modoOp, 1, grf.getFontMetrics().getHeight() + 1);
		pc.draw(grf);
		instCache.draw(grf);
		bregs.draw(grf);

		grf.dispose();
		bs.show();
	}
}