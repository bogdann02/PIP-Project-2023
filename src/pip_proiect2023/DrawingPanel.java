package pip_proiect2023;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Rectangle> rectangles;
    private Point startPoint, endPoint;
    
    public DrawingPanel() {
        // Initialize the rectangles list
        rectangles = new ArrayList<>();
        
        // Add a mouse listener to the panel to handle dragging and selecting
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                endPoint = e.getPoint();
                
                // Create a rectangle from the start and end points
                Rectangle rectangle = createRectangle(startPoint, endPoint);
                
                // Add the rectangle to the list and repaint the panel
                rectangles.add(rectangle);
                repaint();
            }
        });
        
        // Add a mouse motion listener to the panel to handle drawing the selection rectangle
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                repaint();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the rectangles on the graphics object
        for (Rectangle rectangle : rectangles) {
            g.setColor(Color.BLUE);
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        
        // Draw the selection rectangle if the mouse is being dragged
        if (startPoint != null && endPoint != null) {
            Rectangle selectionRectangle = createRectangle(startPoint, endPoint);
            g.setColor(new Color(0, 0, 255, 64));
            g.fillRect(selectionRectangle.x, selectionRectangle.y, selectionRectangle.width, selectionRectangle.height);
        }
    }
    /**
     * 
     * @param startPoint
     * @param endPoint
     * @return
     */
    private Rectangle createRectangle(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        
        return new Rectangle(x, y, width, height);
    }
    
    public static void main(String[] args) {
        // Create the frame and panel
    	
    	creareMeniuPrincipal meniuPrincipal = new creareMeniuPrincipal();
        /*JFrame frame = new JFrame("Selectie rectangle");
        JPanel panel = new DrawingPanel();
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Set the size of the frame and show it
        frame.setSize(500, 500);
        frame.setVisible(true);*/
    }
}
