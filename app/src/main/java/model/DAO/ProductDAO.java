package model.DAO;

import model.Conection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public ProductDAO() {
    }

    public void cadastrarProduto(Product product) {
        String sql = "INSERT INTO PRODUCT (NOME, PRECO, QUANTIDADE, CODIGO, DESCRICAO) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = Conection.getConexao().prepareStatement(sql);
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getAmount());
            ps.setInt(4, product.getCodigo());
            ps.setString(5, product.getDescricao());
            ps.execute();
            ps.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

    }

    public void update(Product product) {
        String sql = "UPDATE product SET nome = ?, preco = ?, quantidade = ? WHERE codigo = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conection.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, product.getNameProduct());
            pstm.setDouble(2, product.getPrice());
            pstm.setInt(3, product.getAmount());
            pstm.setInt(4, product.getCodigo());
            pstm.execute();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public void deleteById(Product product) {
        String sql = "DELETE FROM product WHERE codigo = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conection.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, product.getCodigo());
            pstm.execute();
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public List<Product> getProducts() {
        String sql = "SELECT * FROM  product";
        List<Product> products = new ArrayList();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = Conection.getConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()) {
                Product product = new Product();
                product.setNameProduct(rset.getString("nome"));
                product.setPrice(rset.getDouble("preco"));
                product.setAmount(rset.getInt("quantidade"));
                product.setCodigo(rset.getInt("codigo"));
                product.setDescricao(rset.getString("descricao"));
                products.add(product);
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return products;
    }

}