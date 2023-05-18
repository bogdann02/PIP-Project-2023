package pip_proiect2023;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public static String incarcaImagine(String image) {
        
   
    	System.out.println(Paths.get(CALE_IMPLICITA, image).toString());
            return Paths.get(CALE_IMPLICITA, image).toString();
    }
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
	
	ActionListener act_li= new ActionListener() {
		
        public void actionPerformed(ActionEvent e) {
        	
            JFileChooser fileChooser = new JFileChooser();
            
            //Creare filtru pentru butonul LOAD pentru a selecta doar fisierele de tip
            //"png", "jpg", "jpeg", "tif", "tiff"
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "tif", "tiff");
            fileChooser.setFileFilter(filter);
            
            int result = fileChooser.showOpenDialog(creareMeniuPrincipal.this);
            if (result == JFileChooser.APPROVE_OPTION) {
            	
                // User has selected a file
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                
                // Close the file chooser dialog box
                dispose();
                
                // Open another JFrame for editing the image
                
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
				//Vericiare functionalitate
				System.out.println("Print help");
				//Deschide un GUI cu indicatiile necesare folosirii aplicatiei
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
				//Vericiare functionalitate
				System.out.println("Print exit");
				//Inchide aplicatia
				System.exit(0);
			}
		}
	};
	exit.addActionListener(act_exit);
	
	meniuPrincipal.setVisible(true);
	}
}
