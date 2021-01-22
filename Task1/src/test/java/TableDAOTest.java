import DAO.DAOImpl;
import DAO.TableDAO;
import models.Shop;
import models.Table;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableDAOTest {
    private DAOImpl<Table, Long> dao = new TableDAO();

    @Test
    public void isFindObject(){

        Table table = dao.getObject(1L);
        Shop shop = new Shop(2L, "Komora", 998764537);
        assertEquals(table.toString(), new Table("Italy", 3700.00, 2019, shop, 1L, "Small", true).toString());
    }

    @Test
    public void isFindObjects(){
        LinkedList<Table> tables = dao.getObjects();
        Shop shop1 = new Shop(1L, "Medium", 876547834);
        Shop shop2 = new Shop(2L, "Komora", 998764537);
        Table table1 = new Table("Italy", 3700.00, 2019, shop2, 1L, "Small", true);
        Table table2 = new Table("France", 4000.00, 2020, shop1, 2L, "Medium", true);
        Table table3 = new Table("France", 4300.00, 2018, shop2, 3L, "Big", false);
        LinkedList<Table> tables1 = new LinkedList<>();
        tables1.add(table1);
        tables1.add(table2);
        tables1.add(table3);
        assertEquals(tables.size(), tables1.size());
    }
}
