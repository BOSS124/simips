import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Font;


import mips.Componente;
import mips.InstCache;

public class MIPS extends Canvas {
	public Graphics grf;
	public static Font fonteTexto;
	private InstCache instCache;

	public MIPS() {
		Dimension dim = new Dimension(1000, 700);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);
		setSize(dim);
		setBackground(Color.WHITE);

		fonteTexto = new Font("SansSerif", Font.BOLD, 12);

		instCache = new InstCache(5, 20);
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

		grf.drawString(modoOp, 1, grf.getFontMetrics().getHeight() + 1);
		instCache.draw(grf);

		grf.dispose();
		bs.show();
	}
}