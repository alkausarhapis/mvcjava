/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvctoko.DAOImplement;

import java.awt.List;
import mvctoko.Model.Model_Member;

/**
 *
 * @author SMKN4
 */
public interface Implement_Member {
    public void insert(Model_Member b);
    public void update(Model_Member b);
    public void delete(int id);
    
    public java.util.List<Model_Member> getAll();
    public java.util.List<Model_Member> getCariNama(String nama);
}
