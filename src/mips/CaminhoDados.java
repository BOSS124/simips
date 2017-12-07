package mips;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class CaminhoDados {
	private ArrayList<Point> pontos;

	public CaminhoDados() {
		pontos = new ArrayList<Point>();
	}

	public void novoPonto(Point ponto) {
		pontos.add(ponto);
	}

	public void draw(Graphics grf) {
		int npontos = pontos.size();
		int i = npontos;
		Point p1, p2;

		if(npontos > 1) {
			while(--i > 0) {
				p1 = pontos.get(i);
				p2 = pontos.get(i-1);

				grf.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
			}

			p1 = pontos.get(npontos-1);
			p2 = pontos.get(npontos-2);
			double dist = (int) (p1.distance(p2));

			Point dir = new Point((int) ((p1.getX() - p2.getX()) / dist), (int) ((p1.getY() - p2.getY()) / dist));

			if(dir.getX() == 0.0f) {
				p2 = new Point((int) (p1.getX() + 3), (int) (p1.getY() - (dir.getY() * 3)));
				grf.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
				p2.setLocation((int) (p1.getX() - 3), (int) (p1.getY() - (dir.getY() * 3)));
				grf.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
			}
			else {
				p2 = new Point((int) (p1.getX() - (dir.getX() * 3)), (int) (p1.getY() + 3));
				grf.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
				p2.setLocation((int) (p1.getX() - (dir.getX() * 3)), (int) (p1.getY() - 3));
				grf.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
			}
		}
		
	}
}