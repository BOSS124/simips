import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;


import mips.Componente;
import mips.InstCache;

public class MIPS extends Canvas {
	public Graphics grf;

	private InstCache instCache;

	public MIPS() {
		Dimension dim = new Dimension(1000, 700);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setPreferredSize(dim);
		setSize(dim);
		setBackground(Color.WHITE);

		instCache = new InstCache(0, 20);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(2);
			return;
		}

		Graphics grf = bs.getDrawGraphics();
		instCache.draw(grf);

		grf.dispose();
		bs.show();
	}
}