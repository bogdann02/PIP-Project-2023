package pip_proiect2023;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class testare_fct_imagini {
	
	/**
	 * Testam daca functia testCropImage() cropeaza imaginea
	 */
    @Test
    public void testCropImage() {
        // Definim un test pentru decuparea unei imagini
        // verificam rezultatul asteptat utilizand asertiuni
        
        // Exemplu:
        
        // Cream o imagine fictiva pentru testare
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        
        // Definim dreptunghiul pentru decupare
        Rectangle rectangle = new Rectangle(100, 100, 200, 200);
        
        // Apelam metoda cropImage
        BufferedImage croppedImage = gui2.cropImage(image, rectangle);
        
        // Verificam latimea si lungimea asteptata a imaginii decupate
        assertEquals(200, croppedImage.getWidth());
        assertEquals(200, croppedImage.getHeight());
    }
    
    /**
     * Testam daca functia testSaveImage() salveaza imaginea
     */
    @Test
    public void testSaveImage() {
        // Definim un test pentru salvarea unei imagini
        // si verificam rezultatul asteptat utilizand asertiuni
        
        // Exemplu:
        
        // Cream o imagine fictiva pentru testare
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        
        // Specificam folderul de iesire pentru salvarea imaginii
        String outputFolder = "cale_catre_folder_iesire";
        
        // Apelam metoda saveImage
        gui2.saveImage(image, outputFolder);
        
        // Verificam ca imaginea a fost salvata cu succes
        // Putem verifica daca fisierul exista in folderul de iesire sau orice alta conditie dorita
       
        File outputFile = new File(outputFolder + File.separator + "69e90967-610c-4c4d-a3c2-cfee99ddc6fd.jpg");
        assertTrue(outputFile.exists());
    }
}