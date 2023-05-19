package pip_proiect2023;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Rectangle> rectangles;
    private Point startPoint, endPoint;
    public Color Culoare = Color.BLACK;
    
    /**
     * Constructor pentru select box
     * @param c Culoarea select box-ului
     */
    public DrawingPanel(Color c) {
        // Initialize the rectangles list
        rectangles = new ArrayList<>();
        Culoare = c;
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
            g.setColor(Culoare);
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        
        // Draw the selection rectangle if the mouse is being dragged
        if (startPoint != null && endPoint != null) {
            Rectangle selectionRectangle = createRectangle(startPoint, endPoint);
            g.setColor(Culoare);
            g.fillRect(selectionRectangle.x, selectionRectangle.y, selectionRectangle.width, selectionRectangle.height);
        }
    }
    /**
     * Creare Rectangle pentru crop
     * @param startPoint Punct colt stanga sus
     * @param endPoint Punct colt dreapta jos
     * @return Variabila de tip Rectangle
     */
    private Rectangle createRectangle(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        
        return new Rectangle(x, y, width, height);
    }
    
    //de testat daca parametrul returnat in urma apelului functiei getList() este de tip lista
    /**
     * Extragere lista cu Rectangles
     * @return Lista cu variabile Rectangles pentru crop
     */
    public List<Rectangle> getList() {
    	return rectangles;
    }
    
    //de testat daca lista nu este deja goala
    //in cazul in care are elemente, vedem daca se pot sterge elementele
    /**
     * Stergere lista cu variabile Rectangles
     */
    public void clearList()
    {
    	rectangles = new ArrayList<>();
    }
    
    //de testat daca exista cel putin 1 element care poate fi sters
    /**
     * Sterge ultimul element adaugat in lista cu variabile Rectangles
     */
    public void undoList()
    {
    	rectangles.remove(rectangles.size()-1);
    }
    
}
