package pip_proiect2023;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HELP_GUI extends creareMeniuPrincipal{

	private JFrame frmHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HELP_GUI window = new HELP_GUI();
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HELP_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("HELP");
		frmHelp.setBounds(0, 0, 1920, 1080);
		frmHelp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHelp.setSize(1920,1080);
		
		JLabel ImagineHelp = new JLabel(new ImageIcon(incarcaImagine("")));
		frmHelp.setContentPane(ImagineHelp);
	}

}
