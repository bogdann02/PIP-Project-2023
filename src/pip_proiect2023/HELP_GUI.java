package pip_proiect2023;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HELP_GUI extends creareMeniuPrincipal{

	private JFrame frmHelp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
	public void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("HELP");
		frmHelp.setBounds(0, 0, 1700, 1062);
		frmHelp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHelp.setSize(1700, 1062);
		frmHelp.setLocationRelativeTo(null);
		frmHelp.setVisible(true);
		JLabel ImagineHelp = new JLabel(new ImageIcon(incarcaImagine("[HELP]fundal.png")));
		
	   //stanga sus x 1350, y 40, dreapta jos 1560, 130, lungime 200, inaltime 90
        
        JButton back = new JButton("");
        back.setBounds(1440, 30, 200, 80);
    	back.setOpaque(false);
    	back.setContentAreaFilled(false);
    	back.setBorderPainted(false);
    	frmHelp.add(back);
    	frmHelp.add(ImagineHelp);
    	
    	ActionListener backact = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frmHelp.dispose();
			}
		};
		
		back.addActionListener(backact);
	}

}
