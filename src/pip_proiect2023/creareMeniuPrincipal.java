package pip_proiect2023;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class creareMeniuPrincipal extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String CALE_IMPLICITA = "images";
	
	/**
	 * 
	 * @param image Numele imaginii 
	 * @return Path-ul unde se gaseste poza selectata
	 */

    public static String incarcaImagine(String image) {
        
   
    	System.out.println(Paths.get(CALE_IMPLICITA, image).toString());
            return Paths.get(CALE_IMPLICITA, image).toString();
    }
    /**
     * Functie de creare a Meniului Principal
     */
	public creareMeniuPrincipal() {
	
	// Se creaza GUI1 pentru meniul principal
	JFrame meniuPrincipal = new JFrame("Meniu principal");
	meniuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	meniuPrincipal.setResizable(false);
	meniuPrincipal.setLayout(null);
	meniuPrincipal.setSize(1080, 720);
	meniuPrincipal.setLocationRelativeTo(null);
	
	//Cream fundalul pentru GUI1 pe care il setam cu o imagine
	JLabel background = new JLabel(new ImageIcon(incarcaImagine("[gui-1]fundal.png")));
	meniuPrincipal.setContentPane(background);
	
	//Crearea butonului de LOAD IMAGE
	JButton li = new JButton("");
	li.setBounds(102, 277, 975-120, 360-300);
	li.setOpaque(false);
	li.setContentAreaFilled(false);
	li.setBorderPainted(false);
	meniuPrincipal.add(li);
	
	//Crearea butonului de HELP
	JButton help = new JButton("");
	help.setBounds(97, 375, 524-110, 456-400);
	help.setOpaque(false);
	help.setContentAreaFilled(false);
	help.setBorderPainted(false);
	meniuPrincipal.add(help);
	
	//Crearea butonului de EXIT
	JButton exit = new JButton("");
	exit.setBounds(552, 375, 524-110, 456-400);
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	meniuPrincipal.add(exit);
	
	
	//Implementarea functionarii butonului de LOAD IMAGE	
	ActionListener act_li = new ActionListener() {
		/**
		 * Functie pentru actiunea butonului LOAD IMAGE
		 */
	    public void actionPerformed(ActionEvent e) {
	        JFileChooser fileChooser = new JFileChooser();
	        
	        // Setarea directorului curent la folderul dorit
	        String folderPath = "Path";
	        fileChooser.setCurrentDirectory(new File(folderPath));
	        
	        // Crearea filtrului pentru a selecta doar fisierele de imagine
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "tif", "tiff");
	        fileChooser.setFileFilter(filter);
	        
	        int result = fileChooser.showOpenDialog(creareMeniuPrincipal.this);
	        if (result == JFileChooser.APPROVE_OPTION) {
	            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
	            dispose();
	            new gui2(filePath);
	        }
	    }
	};
	li.addActionListener(act_li);
	
	//Implementarea functionarii butonului de HELP
	ActionListener act_help=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "")
			{
				System.out.println("Print help");
				HELP_GUI help_gui = new HELP_GUI();
				meniuPrincipal.dispose();
			}
		}
	};
	help.addActionListener(act_help);
	
	//Implementarea functionarii butonului EXIT
	ActionListener act_exit=new ActionListener() {
		
		@Override
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand() == "")
			{
				System.out.println("Print exit");
				System.exit(0);
			}
		}
	};
	exit.addActionListener(act_exit);
	
	meniuPrincipal.setVisible(true);
	}
}