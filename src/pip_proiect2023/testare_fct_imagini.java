package pip_proiect2023;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class testare_fct_imagini {
	
	/**
	 * Testam daca functia testCropImage() decupeaza imaginea
	 */
    @Test
    public void testCropImage() {
        // Definim un test pentru decuparea unei imagini
        // verificam rezultatul asteptat utilizand asertiuni
        
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Rectangle rectangle = new Rectangle(100, 100, 200, 200);
        BufferedImage croppedImage = gui2.cropImage(image, rectangle);
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
        
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        String outputFolder = "cale_catre_folder_iesire";

        
        // Apelam metoda saveImage
        gui2.saveImageToFolder(image, outputFolder);
        
        // Verificam ca imaginea a fost salvata cu succes
        // Putem verifica daca fisierul exista in folderul de iesire sau orice alta conditie dorita

       
        File outputFile = new File(outputFolder + File.separator + "3a7ba506-d088-4d41-9702-6c739a9a120c.jpg");
        assertTrue(outputFile.exists());
    }
}