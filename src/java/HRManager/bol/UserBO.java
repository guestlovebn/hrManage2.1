/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager.bol;

import HRManager.dal.DAO;
import HRManager.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBO {

    public boolean authorization(User u) {
//        String sql = "select * from users where username='" + u.getUserName() + "' and userpassword='" + u.getUserPassword() + "'";
//        DAO dao = new DAO();
//        try {
//            ResultSet rs = dao.executeQuery(sql);
//            if (!rs.next()) {
//                return false;
//            }
//        } catch (SQLException ex) {
//            //SinhNX_Lib.getLogger(this.getClass().getName()).error("Can't get data from database. " + ex.toString());
//
//            return false;
//        }
        return true;
    }
}
