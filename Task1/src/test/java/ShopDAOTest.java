import DAO.DAOImpl;
import DAO.ShopDAO;
import DAO.TableDAO;
import models.Shop;
import models.Table;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopDAOTest {
    private DAOImpl<Shop, Long> dao = new ShopDAO();

    @Test
    public void isFindObject(){

        Shop shop = dao.getObject(1L);
        assertEquals(shop.toString(), new Shop(1L, "Medium", 876547834).toString());
    }

    @Test
    public void isFindObjects(){
        LinkedList<Shop> shops = dao.getObjects();
        Shop shop1 = new Shop(1L, "Medium", 876547834);
        Shop shop2 = new Shop(2L, "Komora", 998764537);
        Shop shop3 = new Shop(3L, "4Room", 956730809);
        Shop shop4 = new Shop(4L, "Oldi", 679112345);
        LinkedList<Shop> shops1 = new LinkedList<>();
        shops1.add(shop1);
        shops1.add(shop2);
        shops1.add(shop3);
        shops1.add(shop4);
        assertEquals(shops.size(), shops1.size());
    }
}
