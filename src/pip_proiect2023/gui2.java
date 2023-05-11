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
		frmGui = new JFrame();
		frmGui.setTitle("GUI-2");
		frmGui.setBounds(0, 0, 1920, 1080);
		frmGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGui.getContentPane().setLayout(null);
		
		//Creem un JLabel pentru locul unde vom prelucra imaginea
		
		JLabel image_worker = new JLabel();
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage();
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