package pip_proiect2023;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.imageio.ImageIO;

public class gui2 {
	  public static String incarcaImagine(String image) {
		  final String CALE_IMPLICITA = "images";
		   
	    	System.out.println(Paths.get(CALE_IMPLICITA, image).toString());
	            return Paths.get(CALE_IMPLICITA, image).toString();
	    }

	private JFrame frmGui;

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
		
		JLabel image_worker = new JLabel();
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
		
		//cu un padding de 26,67 fata de margini , dimensiunea jPanel-ului va fi 1348 x 901 (dimensiune generata de WindowBuilder)
		//pentru resize-ul imaginii de fiecare data
		
		image_worker.setBounds(26, 67, 1348, 901);
		Image scaledImage = image.getScaledInstance(1348, 901, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		image_worker.setIcon(scaledIcon);
		 image_worker.setBorder((Border) new LineBorder(Color.BLACK, 10));

		frmGui.add(image_worker);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(incarcaImagine("[gui-2]fundal.png")));
		//meniuPrincipal.setContentPane(lblNewLabel);
		
		//JLabel lblNewLabel = new JLabel("background");
		//lblNewLabel.setIcon(new ImageIcon(gui2.class.getResource("[gui-2]fundal.png")));
		lblNewLabel.setBounds(0, 0, 1904, 1041);
		frmGui.getContentPane().add(lblNewLabel);
		
		
		//standardWidth este latimea unui buton, latimea fiind standard declarata
		//standardHeight_functionale este inaltimea butoanelor cele de sus, cele pe care apasam pentru a selecta tipul de crop
		//standardHeight este inaltimea butoanelor de jos, clear all, undo, done 
				
		int standardWidth = 1902-1420;
		int standardHeight_functionale = 100;
		int standardHeight = 80;
				
		//creem butonul
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
	}
	
	public static BufferedImage cropImage(BufferedImage image, Rectangle rectangle) {
        // Crop the image
        BufferedImage croppedImage = image.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        return croppedImage;
    }

    public static void saveImage(BufferedImage image, String outputFolder) {
        // Generate a random file name
        String randomFileName = UUID.randomUUID().toString() + ".jpg";

        // Create the output folder if it doesn't exist
        File folder = new File(outputFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Save the image to the specified output folder with the random file name
        String outputPath = outputFolder + File.separator + randomFileName;
        try {
            ImageIO.write(image, "jpg", new File(outputPath));
            System.out.println("Image saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}