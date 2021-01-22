package DAO;

import models.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Connection.DBConnection;

public class ShopDAO implements DAOImpl<Shop, Long>{

    Connection connection;

    public ShopDAO() {
        connection = DBConnection.getConnection();
    }

    @Override
    public Shop getObject(Long id) {
        final Shop shop = new Shop();
        shop.setId(id);
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM shop WHERE id = (?)")){
            st.setLong(1, id);
            final ResultSet rs = st.executeQuery();
            if(rs.next()){
                shop.setName(rs.getString("name"));
                shop.setNumber(Integer.parseInt(rs.getString("number")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return shop;
    }

    @Override
    public LinkedList<Shop> getObjects() {
        LinkedList<Shop> shops = new LinkedList<>();
        try (PreparedStatement st = connection.prepareStatement("SELECT * FROM shop")){
            final ResultSet rs = st.executeQuery();
            while (rs.next()){
                Shop shop = new Shop();
                shop.setId(Long.parseLong(rs.getString("id")));
                shop.setName(rs.getString("name"));
                shop.setNumber(Integer.parseInt(rs.getString("number")));
                shops.add(shop);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return shops;
    }
}
