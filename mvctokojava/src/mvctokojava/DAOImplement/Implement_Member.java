/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvctokojava.DAOImplement;

import java.awt.List;
import mvctokojava.Model.Model_Member;

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
