package pip_proiect2023;

import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class testare_fct_imagini {
    @Test
    public void testCropImage() {
        // Definim un test pentru decuparea unei imagini
        // și verificăm rezultatul așteptat utilizând aserțiuni
        
        // Exemplu:
        
        // Cream o imagine fictivă pentru testare
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        
        // Definim dreptunghiul pentru decupare
        Rectangle rectangle = new Rectangle(100, 100, 200, 200);
        
        // Apelăm metoda cropImage
        BufferedImage croppedImage = gui2.cropImage(image, rectangle);
        
        // Verificăm lățimea și înălțimea așteptată a imaginii decupate
        assertEquals(200, croppedImage.getWidth());
        assertEquals(200, croppedImage.getHeight());
    }

    @Test
    public void testSaveImage() {
        // Definim un test pentru salvarea unei imagini
        // și verificăm rezultatul așteptat utilizând aserțiuni
        
        // Exemplu:
        
        // Cream o imagine fictivă pentru testare
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        
        // Specificăm folderul de ieșire pentru salvarea imaginii
        String outputFolder = "cale_catre_folder_iesire";
        
        // Apelăm metoda saveImage
        gui2.saveImage(image, outputFolder);
        
        // Verificăm că imaginea a fost salvată cu succes
        // Putem verifica dacă fișierul există în folderul de ieșire sau orice altă condiție dorită
       
        File outputFile = new File(outputFolder + File.separator + "9f96b9c2-1e33-4841-9190-a057c2d81b85.jpg");
        assertTrue(outputFile.exists());
    }
}