import DAO.CupboardDAO;
import DAO.DAOImpl;
import DAO.ShopDAO;
import DAO.TableDAO;
import models.Cupboard;
import models.Shop;
import models.Table;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        DAOImpl<Shop, Long> dao = new ShopDAO();
        LinkedList<Shop> shops = dao.getObjects();
        Shop shop = dao.getObject(3L);
        for(Shop s : shops){
            System.out.println(s.toString());
        }

        DAOImpl<Table, Long> dao1 = new TableDAO();
        LinkedList<Table> tables = dao1.getObjects();
        for(Table t : tables){
            System.out.println(t.toString());
        }
        DAOImpl<Cupboard, Long> dao2 = new CupboardDAO();
        Cupboard cupboard = dao2.getObject(4L);
        System.out.println(cupboard.toString());
    }
}
