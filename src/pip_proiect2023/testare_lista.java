package pip_proiect2023;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class testare_lista{

    private List<Rectangle> rectangles;

    @Before
    public void setUp() {
        // Initializarea  listei cu elemente pentru testare
        rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(3, 4));
    }

    @Test
    public void testClearList() {
        // Vrificam daca lista nu este goala inainte  de apelul functuiei clearList()
    	
        Assert.assertFalse(rectangles.isEmpty());
        clearList();
        Assert.assertTrue(rectangles.isEmpty());
    }

    private void clearList() {
        rectangles = new ArrayList<>();
    }
    @Test
    public void testGetListReturnType() {
        List<Rectangle> result = getList();

        // Verificam daca rezultatul returnat este de tipul List<Rectangle>
        Assert.assertTrue(result instanceof List);
        Assert.assertTrue(result.get(0) instanceof Rectangle);
    }

    private List<Rectangle> getList() {
        return rectangles;
    }
    @Test
    public void testUndoList() {
        rectangles.add(new Rectangle(5, 6));
        Assert.assertEquals(3, rectangles.size());
        undoList();
        Assert.assertEquals(2, rectangles.size());
        Assert.assertFalse(rectangles.contains(new Rectangle(5, 6)));
    }

    private void undoList() {
        rectangles.remove(rectangles.size() - 1);
    }
}