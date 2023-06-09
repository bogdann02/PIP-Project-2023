package pip_proiect2023;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class gui2 extends JFrame {
	  public static String incarcaImagine(String image) {
		  final String CALE_IMPLICITA = "images";
		   
	    	System.out.println(Paths.get(CALE_IMPLICITA, image).toString());
	            return Paths.get(CALE_IMPLICITA, image).toString();
	    }

	private JFrame frmGui;
	public static BufferedImage image;
	public BufferedImage copy_image;
	public static JLabel imageLabel;
	private JPanel drawingPanelContainer;
	private DrawingPanel currentDrawingPanel;
	public String save_cladire = "Export\\Cladire";
	public String save_masina = "Export\\Masina";
	public String save_semn = "Export\\Semn";
	public String save_semafor = "Export\\Semafor";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//do nothing
		
	}

	/**
	 * Create the application.
	 */
	public gui2(String path) {
		initialize(path);
		frmGui.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String path) {
		
		//declaram un nou jframe care va fi GUI2, care se deschide la actionarea butonului "Load Image" din cadrul GUI1
		
		frmGui = new JFrame();
		frmGui.setTitle("GUI-2");
		
		//dimensiunile standard vor fi 1920 px x 1080 px (fullscreen pentru o manevrare si vizualizare mai usoara a imaginii)
		
		frmGui.setBounds(0, 0, 1920, 1080);
		frmGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGui.getContentPane().setLayout(null);
		
		//acum vom face un Jlabel in cadrul caruia va fi setata poza importata ca poza de fundal pentru acel jlabel, de unde va fi prelucrata
		//String-ul "path" este primit ca parametru din fisierul "creareMeniuPrincipal.java", acest String fiind calea catre poza pe care o vom importa
		try {
			image = ImageIO.read(new File(path));
			image = resize(image, 1348,901);
			copy_image = ImageIO.read(new File(path));
			copy_image = resize(copy_image, 1348,901);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		imageLabel = new JLabel(new ImageIcon(image));
		
		//cu un padding de 26,67 fata de margini , dimensiunea jPanel-ului va fi 1348 x 901 (dimensiune generata de WindowBuilder)
		//pentru resize-ul imaginii de fiecare data
		
		drawingPanelContainer = new JPanel();
		drawingPanelContainer.setBounds(26,67,1348,901);
		drawingPanelContainer.setBorder((Border) new LineBorder(Color.BLACK, 10));
		drawingPanelContainer.add(imageLabel);
		
		
		drawingPanelContainer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					currentDrawingPanel.mousePressed(e);}
				catch (Exception e2) {
					System.out.println(e2);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					currentDrawingPanel.mouseReleased(e);
				}
				catch (Exception e3) {
					System.out.println(e3);
				}
			}
		});

		frmGui.add(drawingPanelContainer);
		
		JLabel background = new JLabel(new ImageIcon(incarcaImagine("[gui-2]fundal.png")));
		background.setBounds(0, 0, 1904, 1041);
		frmGui.getContentPane().add(background);
		
		
		//standardWidth este latimea unui buton, latimea fiind standard declarata
		//standardHeight_functionale este inaltimea butoanelor cele de sus, cele pe care apasam pentru a selecta tipul de crop
		//standardHeight este inaltimea butoanelor de jos, clear all, undo, done 
				
		int standardWidth = 1902-1420;
		int standardHeight_functionale = 100;
		int standardHeight = 80;
		
		//Crearea butoanelor
		
		JButton masina = new JButton("");
		//ii setam pozitia si dimensiunile la buton cu .setBounds(x,y,width,height)
		masina.setBounds(1400, 60, standardWidth, standardHeight_functionale);
		//facem butonul opac pentru a se vedea design-ul
		masina.setOpaque(false);
		masina.setContentAreaFilled(false);
		masina.setBorderPainted(false);
		//adaugam butonul pe frame 
		frmGui.add(masina);
		JButton semn = new JButton("");
		semn.setBounds(1400, 190, standardWidth, standardHeight_functionale);
		semn.setOpaque(false);
		semn.setContentAreaFilled(false);
		semn.setBorderPainted(false);
		frmGui.add(semn);
				
		JButton semafor = new JButton("");
		semafor.setBounds(1400, 310, standardWidth, standardHeight_functionale);
		semafor.setOpaque(false);
		semafor.setContentAreaFilled(false);
		semafor.setBorderPainted(false);
		frmGui.add(semafor);
				
		JButton cladire = new JButton("");
		cladire.setBounds(1400, 440, standardWidth, standardHeight_functionale);
		cladire.setOpaque(false);
		cladire.setContentAreaFilled(false);
		cladire.setBorderPainted(false);
		frmGui.add(cladire);
				
				
		JButton clear_all = new JButton("");
		clear_all.setBounds(1400, 640, standardWidth, standardHeight);
		clear_all.setOpaque(false);
		clear_all.setContentAreaFilled(false);
		clear_all.setBorderPainted(false);
		frmGui.add(clear_all);
				
		JButton undo = new JButton("");
		undo.setBounds(1400, 770, standardWidth, standardHeight);
		undo.setOpaque(false);
		undo.setContentAreaFilled(false);
		undo.setBorderPainted(false);
		frmGui.add(undo);
				
		JButton done = new JButton("");
		done.setBounds(1400, 900, standardWidth, standardHeight);
		done.setOpaque(false);
		done.setContentAreaFilled(false);
		done.setBorderPainted(false);
		frmGui.add(done);
		
		DrawingPanel draw_masina = new DrawingPanel();
		draw_masina.setColor(Color.RED);
		DrawingPanel draw_semn = new DrawingPanel();
		draw_semn.setColor(Color.GREEN);
		DrawingPanel draw_cladire = new DrawingPanel();
		draw_cladire.setColor(Color.BLUE);
		DrawingPanel draw_semafor = new DrawingPanel();
		draw_semafor.setColor(Color.YELLOW);
		
		//Adaugam functionalitatile butoanelor
		masina.addActionListener(e -> setCurrentDrawingPanel(draw_masina));
		semn.addActionListener(e -> setCurrentDrawingPanel(draw_semn));
		semafor.addActionListener(e -> setCurrentDrawingPanel(draw_semafor));
		cladire.addActionListener(e -> setCurrentDrawingPanel(draw_cladire));
		
		//Implementarea functionalitatilor butoanelor UNDO si CLEAR ALL
		//UNDO - sterge ultima decupare facuta
		//CLEAR ALL - sterge toate decuparile facute
		undo.addActionListener(e -> {
			currentDrawingPanel.undoLastItem();
			});
		clear_all.addActionListener(e -> {
			currentDrawingPanel.clearAllItems();
			});

		//Implementarea functionalitatii butonului DONE -> salveaza in folderele corespunzatoare
		//imaginile decupate

		done.addActionListener(e -> {
	
			for (Rectangle r: draw_masina.getList())
			{
				BufferedImage buff = cropImage(copy_image,r);
				saveImageToFolder(buff,save_masina);
			}
			for (Rectangle r:draw_cladire.getList())
			{
				BufferedImage buff = cropImage(copy_image,r);
				saveImageToFolder(buff,save_cladire);
			}
			for (Rectangle r:draw_semafor.getList())
			{
				BufferedImage buff = cropImage(copy_image,r);
				saveImageToFolder(buff,save_semafor);
			}
			for (Rectangle r:draw_semn.getList())
			{
				BufferedImage buff = cropImage(copy_image,r);
				saveImageToFolder(buff,save_semn);
			}
			
			
			System.exit(0);
		});
	}
	
	/**
	 * Functia retine variabila curenta de tip DrawingPanel in folosinta
	 * @param Variabila de tip DrawingPanel activa
	 */
	private void setCurrentDrawingPanel(DrawingPanel drawingPanel) {
        currentDrawingPanel = drawingPanel;
    }

	/**
	 * Extragerea imaginii decupate
	 * @param image Imaginea pe care lucram
	 * @param rectangle Dimensiunile si coordonatele imaginii pe care dorim sa o extragem
	 * @return Imaginea extrasa decupata
	 */
	public static BufferedImage cropImage(BufferedImage image, Rectangle rectangle) {
        // Crop the image
        BufferedImage croppedImage = image.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        return croppedImage;
    }


    /**
     * Salveaza imaginile in folderele corespunzatoare
     * @param image Imaginea decupata
     * @param folderPath Path-ul in care salvam imaginile decupate
     */

	public static void saveImageToFolder(BufferedImage image, String folderPath) {
        try {
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String randomFileName = UUID.randomUUID().toString() + ".png";
            File outputFile = new File(folder, randomFileName);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Image saved successfully to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving image: " + e.getMessage());
        }
    }
	

	/**
	 * Face resize la o imagine 
	 * @param img Imaginea pe care dorim sa o redimensionam
	 * @param newW Latimea noua dorita
	 * @param newH Inaltimea noua dorita
	 * @return Imaginea redimensionata
	 */

    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  
    
}