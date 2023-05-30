/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.Dtdao;
import Implement.Dtimplement;
import Model.*;
import View.*;
import java.util.List;
/**
 *
 * @author PC PRAKTIKUM
 */
public class Dtcontroller {
    Dtimplement impldata;
    Utama frame;
    List<dtperpus> dp;
    
    public Dtcontroller(Utama frame){
        this.frame = frame;
        impldata = new Dtdao();
        dp = impldata.getAll();
    }
    
    public void isitabel(){
       dp = impldata.getAll();
       Modeldata md = new Modeldata(dp);
       frame.getjTable1().setModel(md);
    }
    
    public void insert(){
        dtperpus dt = new dtperpus();
        dt.setJudul(frame.getjTextJudul().getText());
        dt.setGenre(frame.getjTextGenre().getText());
        dt.setPenulis(frame.getjTextPenulis().getText());
        dt.setPenerbit(frame.getjTextPenerbit().getText());
        dt.setLokasi(frame.getjTextLokasi().getText());
        dt.setStock(frame.getjTextStock().getText());
        impldata.insert(dt);
    }
    
    public void update(){
        dtperpus dt = new dtperpus();
        dt.setJudul(frame.getjTextJudul().getText());
        dt.setGenre(frame.getjTextGenre().getText());
        dt.setPenulis(frame.getjTextPenulis().getText());
        dt.setPenerbit(frame.getjTextPenerbit().getText());
        dt.setLokasi(frame.getjTextLokasi().getText());
        dt.setStock(frame.getjTextStock().getText());
        dt.setId(Integer.parseInt(frame.getjTextId().getText()));
        impldata.update(dt);
    }
    
    public void delete(){
        dtperpus dt = new dtperpus();
        dt.setId(Integer.parseInt(frame.getjTextId().getText()));
        impldata.delete(dt);
    }
}
