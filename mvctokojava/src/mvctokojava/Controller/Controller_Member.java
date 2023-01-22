/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctokojava.Controller;

import javax.swing.JOptionPane;
import mvctokojava.DAO.DAO_Member;
import mvctokojava.DAOImplement.Implement_Member;
import mvctokojava.Model.Model_Member;
import mvctokojava.Model.Tabel_Model_Member;
import mvctokojava.View.View_Member;

/**
 *
 * @author SMKN4
 */
public class Controller_Member {
    View_Member frame_member;
    Implement_Member implement_member;
    java.util.List<Model_Member> list_member;
    
    public Controller_Member (View_Member frame_member) {
        this.frame_member = frame_member;
        implement_member = new DAO_Member();
        list_member = implement_member.getAll();
    }
    
//    Reset Button
    public void bersih() {
        frame_member.getTxtId().setText("");
        frame_member.getTxtNama().setText("");
        frame_member.getTxtNo_Telp().setText("");
        frame_member.getTxtAlamat().setText("");
        frame_member.getTxtPaket().setSelectedItem("-PILIH PAKET-");
        frame_member.getTxtCariData().setText("");
    }
    
//    Tampil data ke tabel
    public void isiTabel() {
        list_member = implement_member.getAll();
        Tabel_Model_Member tmb = new Tabel_Model_Member(list_member);
        frame_member.getTabelDataMember().setModel(tmb);
    }
    
//    Menampilkan data ke form
    public void pilih(int row) {
        frame_member.getTxtId().setText(list_member.get(row).getId().toString()); //gettxtid = getter viewmember, getid = geter modelmember
        frame_member.getTxtNama().setText(list_member.get(row).getNama());
        frame_member.getTxtNo_Telp().setText(list_member.get(row).getNo_telp());
        frame_member.getTxtAlamat().setText(list_member.get(row).getAlamat());
        frame_member.getTxtPaket().setSelectedItem(list_member.get(row).getPaket());
    }
    
//    Insert data
    public void insert() {
        if(!frame_member.getTxtNama().getText().trim().isEmpty()&!frame_member.getTxtNo_Telp().getText().trim().isEmpty()&!frame_member.getTxtAlamat().getText().trim().isEmpty()) {
            Model_Member b = new Model_Member();
            b.setNama(frame_member.getTxtNama().getText());
            b.setNo_telp(frame_member.getTxtNo_Telp().getText());
            b.setAlamat(frame_member.getTxtAlamat().getText());
            b.setPaket(frame_member.getTxtPaket().getSelectedItem().toString());
            
            implement_member.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Data Tidak Boleh Kosong");
        }
    }
    
//    Update data
    public void update() {
        if (!frame_member.getTxtId().getText().trim().isEmpty()) {
            Model_Member b = new Model_Member();
            b.setNama(frame_member.getTxtNama().getText());
            b.setNo_telp(frame_member.getTxtNo_Telp().getText());
            b.setAlamat(frame_member.getTxtAlamat().getText());
            b.setPaket(frame_member.getTxtPaket().getSelectedItem().toString());
            b.setId(Integer.parseInt(frame_member.getTxtId().getText())); 

            implement_member.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silakan pilih data yang akan di Update");
        }
    }
    
//    Delete data
    public void delete() {
        if(!frame_member.getTxtId().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame_member.getTxtId().getText());
            implement_member.delete(id);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silakan pilih data yang akan di Hapus");
        }
    }
    
//    Cari data
    public void isiTabelCariNama() {
        list_member = implement_member.getCariNama(frame_member.getTxtCariData().getText());
        Tabel_Model_Member tmb = new Tabel_Model_Member(list_member);
        frame_member.getTabelDataMember().setModel(tmb);
    }
    
    public void cariNama() {
        if (!frame_member.getTxtCariData().getText().trim().isEmpty()) {
            implement_member.getCariNama(frame_member.getTxtCariData().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silakan Pilih Data!!!");
        }
    }
}
