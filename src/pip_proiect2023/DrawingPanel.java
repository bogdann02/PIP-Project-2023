package pip_proiect2023;
import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel {

	private List<Rectangle> regionList;
	private Color color;
	private Point startPoint;
	private Point endPoint;

	public DrawingPanel() {
		regionList = new ArrayList<>();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void mousePressed(MouseEvent e) {
		startPoint = e.getPoint();
	}

	public void mouseReleased(MouseEvent e) {
		endPoint = e.getPoint();
		int x = Math.min(startPoint.x, endPoint.x);
		int y = Math.min(startPoint.y, endPoint.y);
		int width = Math.abs(startPoint.x - endPoint.x);
		int height = Math.abs(startPoint.y - endPoint.y);
		drawRegion(x, y, width, height);
	}

	public void undoLastItem() {
		if (!regionList.isEmpty()) {
			regionList.remove(regionList.size() - 1);
		}
	}

	public void clearAllItems() {
		regionList.clear();
	}

	private void drawRegion(int x, int y, int width, int height) {
		Graphics2D g2d = gui2.image.createGraphics();
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(x, y, width, height);
		g2d.dispose();
		gui2.imageLabel.repaint();
		regionList.add(new Rectangle(x, y, width, height));
	}

	public void paintRegions() {
		Graphics2D g2d = gui2.image.createGraphics();
		for (Rectangle region : regionList) {
			g2d.setColor(color);
			g2d.setStroke(new BasicStroke(5));
			g2d.drawRect(region.x, region.y, region.width, region.height);
			g2d.dispose();
			gui2.imageLabel.repaint();
		}
	}
	
	public List<Rectangle> getList() {
		return this.regionList;
	}
}

