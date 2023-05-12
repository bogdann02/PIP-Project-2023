package pip_proiect2023;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class gui2 {

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
		
		frmGui.add(image_worker);
		
		
		JLabel lblNewLabel = new JLabel("background");
		lblNewLabel.setIcon(new ImageIcon(gui2.class.getResource("/pip_proiect2023/[gui-2]fundal.png")));
		lblNewLabel.setBounds(0, 0, 1904, 1041);
		frmGui.getContentPane().add(lblNewLabel);
	}
}