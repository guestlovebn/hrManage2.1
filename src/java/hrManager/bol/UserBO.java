/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hrManager.bol;

import hrManager.dal.DAO;
import hrManager.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserBO {

    public boolean authorization(User u) {
        String sql = "select * from Users where userName='" + u.getUserName() + "' and userPass='" + u.getUserPassword() + "'";
        DAO dao = new DAO();
        try {
            ResultSet rs = dao.executeQuery(sql);
            if (!rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
}
