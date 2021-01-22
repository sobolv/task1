import DAO.CupboardDAO;
import DAO.DAOImpl;
import models.Cupboard;
import models.Shop;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CupboardDAOTest {
    private DAOImpl<Cupboard, Long> dao = new CupboardDAO();

    @Test
    public void isFindObject(){

        Cupboard cupboard = dao.getObject(4L);
        Shop shop = new Shop(3L, "4Room", 956730809);
        assertEquals(cupboard.toString(), new Cupboard("Spain", 4500.00, 2018, shop, 4L, "White", 22).toString());
    }

    @Test
    public void isFindObjects(){
        LinkedList<Cupboard> cupboards = dao.getObjects();
        Shop shop3 = new Shop(3L, "4Room", 956730809);
        Shop shop4 = new Shop(4L, "Oldi", 679112345);
        Cupboard cupboard1 = new Cupboard("Spain", 4500.00, 2018, shop3, 4L, "White", 22);
        Cupboard cupboard2 = new Cupboard("Italy", 4499.99, 2019, shop4, 5L, "Black", 18);
        Cupboard cupboard3 = new Cupboard("Spain", 4299.99, 2020, shop3, 4L, "Brown", 20);
        LinkedList<Cupboard> cupboards1 = new LinkedList<>();
        cupboards1.add(cupboard1);
        cupboards1.add(cupboard2);
        cupboards1.add(cupboard3);
        assertEquals(cupboards.size(), cupboards1.size());
    }
}
