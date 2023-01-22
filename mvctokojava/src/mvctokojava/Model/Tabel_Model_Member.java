package mvctokojava.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SMKN4
 */
public class Tabel_Model_Member extends AbstractTableModel {
     java.util.List<Model_Member> list_member;
    
    public Tabel_Model_Member(java.util.List<Model_Member> list_member) {
        this.list_member = list_member;
    }

    @Override
    public int getRowCount() {
        return list_member.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID/KODE";
            case 1:
                return "NAMA";
            case 2:
                return "NO TELP";
            case 3:
                return "ALAMAT";
            case 4:
                return "PAKET";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list_member.get(row).getId();
            case 1:
                return list_member.get(row).getNama();
            case 2:
                return list_member.get(row).getNo_telp();
            case 3:
                return list_member.get(row).getAlamat();
            case 4:
                return list_member.get(row).getPaket();
            default:
                return null;
        }
    }
}
