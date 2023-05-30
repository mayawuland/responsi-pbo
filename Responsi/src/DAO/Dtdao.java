/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import Koneksi.Connector;
import Model.*;
import View.*;
import Implement.Dtimplement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC PRAKTIKUM
 */
public class Dtdao implements Dtimplement{

    Connection connection;
    
    final String select = "select * from dataperpus";
    final String insert = "insert into dataperpus (judul,genre,penulis,penerbit,lokasi,stock) values (?,?,?,?,?,?);";
    final String update = "update dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?;";
    final String delete = "delete from dataperpus where id=?;";
    
    public Dtdao(){
        connection = Connector.connection();
    }
    
    @Override
    public void insert(dtperpus a) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, a.getJudul());
        statement.setString(2, a.getGenre());
        statement.setString(3, a.getPenulis());
        statement.setString(4, a.getPenerbit());
        statement.setString(5, a.getLokasi());
        statement.setString(6, a.getStock());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while(rs.next()){
            a.setId(rs.getInt(1));
        }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(dtperpus b) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(update);
        statement.setString(1, b.getJudul());
        statement.setString(2, b.getGenre());
        statement.setString(3, b.getPenulis());
        statement.setString(4, b.getPenerbit());
        statement.setString(5, b.getLokasi());
        statement.setString(6, b.getStock());
        statement.setInt(7, b.getId());
        statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(dtperpus c) {
        PreparedStatement statement = null;
        try{
        statement = connection.prepareStatement(delete);
        statement.setInt(1, c.getId());
        statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<dtperpus> getAll() {
        List<dtperpus> dn = null;
        try{
        dn = new ArrayList<dtperpus>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(select);
        while(rs.next()){
            dtperpus akun = new dtperpus();
            akun.setId(rs.getInt("id"));
            akun.setJudul(rs.getString("judul"));
            akun.setGenre(rs.getString("genre"));
            akun.setPenulis(rs.getString("penulis"));
            akun.setPenerbit(rs.getString("penerbit"));
            akun.setLokasi(rs.getString("lokasi"));
            akun.setStock(rs.getString("stock"));
            dn.add(akun);
        }
        }catch(SQLException ex){
        Logger.getLogger(Dtdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dn;
    }
    
}
