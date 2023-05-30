/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author PC PRAKTIKUM
 */
public class Modeldata extends AbstractTableModel{

    List<dtperpus> dp;
    
    public Modeldata(List<dtperpus>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "id";
            case 1:
                return "judul";
            case 2:
                return "genre";
            case 3:
                return "penulis";
            case 4:
                return "penerbit";
            case 5:
                return "lokasi" ;
            case 6:
                return "stock";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId();
            case 1:
                return dp.get(row).getJudul();
            case 2:
                return dp.get(row).getGenre();
            case 3:
                return dp.get(row).getPenulis();
            case 4:
                return dp.get(row).getPenerbit();
            case 5:
                return dp.get(row).getLokasi();
            case 6:
                return dp.get(row).getStock();
            default:
                return null;
        }
    }
    
}
