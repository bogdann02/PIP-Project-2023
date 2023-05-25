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
        gui2.saveImageToFolder(image, outputFolder);
       
        File outputFile = new File(outputFolder + File.separator + "69e90967-610c-4c4d-a3c2-cfee99ddc6fd.jpg");
        assertTrue(outputFile.exists());
    }
}