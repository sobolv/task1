package DAO;

import models.Shop;
import models.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import Connection.DBConnection;

public class TableDAO implements DAOImpl<Table, Long> {
    Connection connection;
    DAOImpl<Shop, Long> dao = new ShopDAO();

    public TableDAO() {
        connection = DBConnection.getConnection();
    }

    @Override
    public Table getObject(Long id) {
        final Table table = new Table();
        Long shop_id;
        table.setId(id);
        try (PreparedStatement st = connection.prepareStatement("SELECT id, country, cost, `year`, shop_id, " +
                "`size`, boxes FROM furniture WHERE furniture_type = 'Table' AND id = (?)")){
            st.setLong(1, id);
            final ResultSet rs = st.executeQuery();
            if(rs.next()){
                table.setCountry(rs.getString("country"));
                table.setCost(Double.parseDouble(rs.getString("cost")));
                table.setYear(Integer.parseInt(rs.getString("year")));
                shop_id = Long.parseLong(rs.getString("shop_id"));
                table.setSize(rs.getString("size"));
                table.setBoxes(Boolean.parseBoolean(rs.getString("boxes")));
                Shop shop = dao.getObject(shop_id);
                table.setShop_id(shop);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return table;
    }

    @Override
    public LinkedList<Table> getObjects() {
        LinkedList<Table> tables = new LinkedList<>();
        Long shop_id;
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM furniture WHERE furniture_type = 'Table'")){
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Table table = new Table();
                table.setId(Long.parseLong(rs.getString("id")));
                table.setCountry(rs.getString("country"));
                table.setCost(Double.parseDouble(rs.getString("cost")));
                table.setYear(Integer.parseInt(rs.getString("year")));
                shop_id = Long.parseLong(rs.getString("shop_id"));
                table.setSize(rs.getString("size"));
                table.setBoxes(Boolean.parseBoolean(rs.getString("boxes")));
                Shop shop = dao.getObject(shop_id);
                table.setShop_id(shop);
                tables.add(table);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tables;
    }
}
