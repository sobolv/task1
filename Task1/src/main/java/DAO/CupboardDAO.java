package DAO;

import models.Cupboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;
import models.Shop;

public class CupboardDAO implements DAOImpl<Cupboard, Long>{

    Connection connection;
    DAOImpl<Shop, Long> dao = new ShopDAO();

    public CupboardDAO() {
        connection = DBConnection.getConnection();
    }

    @Override
    public Cupboard getObject(Long id) {
        final Cupboard cupboard = new Cupboard();
        Long shop_id;
        cupboard.setId(id);
        try (PreparedStatement st = connection.prepareStatement("SELECT id, country, cost, `year`, shop_id, " +
                "color, shelves FROM furniture WHERE furniture_type = 'Cupboard' AND id = (?)")){
            st.setLong(1, id);
            final ResultSet rs = st.executeQuery();
            if(rs.next()){
                cupboard.setCountry(rs.getString("country"));
                cupboard.setCost(Double.parseDouble(rs.getString("cost")));
                cupboard.setYear(Integer.parseInt(rs.getString("year")));
                shop_id = Long.parseLong(rs.getString("shop_id"));
                cupboard.setColor(rs.getString("color"));
                cupboard.setShelves(Integer.parseInt(rs.getString("shelves")));
                Shop shop = dao.getObject(shop_id);
                cupboard.setShop_id(shop);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupboard;
    }

    @Override
    public LinkedList<Cupboard> getObjects() {
        LinkedList<Cupboard> cupboards = new LinkedList<>();
        Long shop_id;
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM furniture WHERE furniture_type = 'Cupboard'")){
            final ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cupboard cupboard = new Cupboard();
                cupboard.setId(Long.parseLong(rs.getString("id")));
                cupboard.setCountry(rs.getString("country"));
                cupboard.setCost(Double.parseDouble(rs.getString("cost")));
                cupboard.setYear(Integer.parseInt(rs.getString("year")));
                shop_id = Long.parseLong(rs.getString("shop_id"));
                cupboard.setColor(rs.getString("color"));
                cupboard.setShelves(Integer.parseInt(rs.getString("shelves")));
                Shop shop = dao.getObject(shop_id);
                cupboard.setShop_id(shop);
                cupboards.add(cupboard);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cupboards;
    }
}
