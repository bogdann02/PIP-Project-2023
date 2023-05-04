package pip_proiect2023;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class creareMeniuPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public creareMeniuPrincipal() {
	
	JFrame meniuPrincipal = new JFrame("Meniu principal");
	meniuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	meniuPrincipal.setResizable(false);
	meniuPrincipal.setLayout(null);
	meniuPrincipal.setSize(1080, 720);
	meniuPrincipal.setLocationRelativeTo(null);
	
	//aici se modifica dupa fiecare calculator in parte cu source path ul fiecaruia
	// Load image coord 102 294 - 975 360
	// help 102 391 - 524 456
	// exit 556 391 - 978 456 
	
	JLabel background = new JLabel(new ImageIcon("src\\pip_proiect2023\\[gui-1]fundal.png"));
	meniuPrincipal.setContentPane(background);
	
	JButton li = new JButton("");
	li.setBounds(102, 277, 975-120, 360-300);
	li.setOpaque(false);
	li.setContentAreaFilled(false);
	li.setBorderPainted(false);
	meniuPrincipal.add(li);
	
	JButton help = new JButton("");
	help.setBounds(97, 375, 524-110, 456-400);
	help.setOpaque(false);
	help.setContentAreaFilled(false);
	help.setBorderPainted(false);
	meniuPrincipal.add(help);
	
	JButton exit = new JButton("");
	exit.setBounds(552, 375, 524-110, 456-400);
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	meniuPrincipal.add(exit);
	
	ActionListener act_li=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand()=="")
				{
						System.out.println("Print load image");
				}
		}
	};
	li.addActionListener(act_li);
	
	ActionListener act_help=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "")
			{
				System.out.println("Print help");
			}
		}
	};
	help.addActionListener(act_help);
	
	ActionListener act_exit=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "")
			{
				System.out.println("Print exit");
			}
		}
	};
	exit.addActionListener(act_exit);
	
	meniuPrincipal.setVisible(true);
	}
}
