package it.unisa.is20.piantalashop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unisa.is20.piantalashop.model.beans.*;

public class DButils {
		
    public static List<Product> queryProduct(Connection conn) throws SQLException {
        String sql = "SELECT * FROM prodotto";
 
        PreparedStatement ps = conn.prepareStatement(sql);
 
        ResultSet rs = ps.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            int idprodotto = rs.getInt("idprodotto");
            String nomeprodotto = rs.getString("nomeprodotto");
            float prezzo = rs.getFloat("prezzo");
            String descrizione = rs.getString("descrizione");
            float disponibilità = rs.getFloat("disponibilità");
            String path = rs.getString("path");
            int idagricoltore = rs.getInt("idagricoltore");
            int idcategoria = rs.getInt("idcategoria");
            Product product = new Product();
            product.setId(idprodotto);
            product.setNome(nomeprodotto);
            product.setPrezzo(prezzo);
            product.setDescrizione(descrizione);
            product.setDisponibilità(disponibilità);
            product.setPath(path);
            product.setIdAgricoltore(idagricoltore);
            product.setIdCategoria(idcategoria);
            list.add(product);
        }
        return list;
    }
}
