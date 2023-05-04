package pip_proiect2023;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class creareMeniuPrincipal extends DrawingPanel{
	
	public creareMeniuPrincipal() {
	
	JFrame meniuPrincipal = new JFrame("Meniu principal");
	meniuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	meniuPrincipal.setResizable(false);
	meniuPrincipal.setLayout(null);
	meniuPrincipal.setSize(1080, 720);
	meniuPrincipal.setLocationRelativeTo(null);
	
	//aici se modifica dupa fiecare calculator in parte cu source path ul fiecaruia
	
	JLabel background = new JLabel(new ImageIcon("src\\pip_proiect2023\\[gui-1]fundal.png"));
	
	meniuPrincipal.setContentPane(background);
	
	meniuPrincipal.setVisible(true);
	}
}
