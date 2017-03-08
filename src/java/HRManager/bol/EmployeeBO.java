/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager.bol;

import HRManager.ConvertData;
import HRManager.dal.DAO;
import HRManager.entities.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class EmployeeBO {

    /**
     *
    add new Employee to database
     */
    public int add(Employee e) {
        ConvertData cv = new ConvertData();
        String sql = "INSERT INTO Employees(LastName, FirstName, BirthDate, HireDate, Address, City, Country, " +
                "HomePhone, Mobile, Email, Note) VALUES('" + e.getLastName() + "', '" + e.getFirstName() +
                "', '" + cv.date2string(e.getBirthDate(), HRManager.ValidData.EN_DATE) +
                "', '" + cv.date2string(e.getHireDate(), HRManager.ValidData.EN_DATE) + "', '" +
                e.getAddress() + "', '" + e.getCity() + "', '" + e.getCountry() + "', '" + e.getHomePhone() + "', '" +
                e.getMobile() + "', '" + e.getEmail() + "', '" + e.getNote() + "')";
        DAO dao = new DAO();
        System.out.println(sql);
        return dao.executeUpdateQuery(sql);
    }

    /**
     *
    delete Employee into database
     */
    public int delete(Employee e) {
        String sql = "DELETE FROM Employees WHERE EmployeeID=" + e.getEmployeeID();
        DAO dao = new DAO();
        return dao.executeUpdateQuery(sql);
    }

    /**
     *
    update old Employee  by new Employee into database
     */
    public int edit(Employee e) {
        ConvertData cv = new ConvertData();
        String sql = "UPDATE Employees SET LastName='" + e.getLastName() + "', FirstName='" + e.getFirstName() +
                "', BirthDate='" + cv.date2string(e.getBirthDate(), HRManager.ValidData.EN_DATE) +
                "', HireDate='" + cv.date2string(e.getHireDate(), HRManager.ValidData.EN_DATE) +
                "', Address='" + e.getAddress() + "', City='" + e.getCity() + "', Country='" + e.getCountry() +
                "', HomePhone='" + e.getHomePhone() + "', Mobile='" + e.getMobile() + "', Email='" + e.getEmail() +
                "', PhotoPath='" + e.getPhotoPath() + "', Note='" + e.getNote() +
                "' WHERE EmployeeID=" + e.getEmployeeID();
        DAO dao = new DAO();
        return dao.executeUpdateQuery(sql);
    }

    /**
     *
    Lay ve tat ca cac Employee co trong CSDL.
     */
    public ArrayList<Employee> select() {
        String sql = "select * from Employees";
        DAO dao = new DAO();

        ArrayList<Employee> vE = new ArrayList();
        try {
            ResultSet rs = dao.executeQuery(sql);
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setLastName(rs.getString("LastName"));
                e.setFirstName(rs.getString("FirstName"));
                e.setBirthDate(rs.getDate("BirthDate"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setAddress(rs.getString("Address"));
                e.setCity(rs.getString("City"));
                e.setCountry(rs.getString("Country"));
                e.setHomePhone(rs.getString("HomePhone"));
                e.setMobile(rs.getString("Mobile"));
                e.setEmail(rs.getString("Email"));
                e.setPhotoPath(rs.getString("PhotoPath"));
                e.setNote(rs.getString("Note"));
                vE.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return vE;
    }

    /**
     *
    Tim kiem Employee co trong CSDL.
     */
    public ArrayList<Employee> find(int option, String value) {
        String sql = "";
        switch (option) {
            case 0:
                sql = "select * from Employees where firstname='" + value + "' or lastname='" + value + "'";
                break;
            case 1:
                sql = "select * from Employees where city='" + value + "'";
                break;
        }
        DAO dao = new DAO();

        ArrayList<Employee> vE = new ArrayList();
        try {
            ResultSet rs = dao.executeQuery(sql);
            while (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setLastName(rs.getString("LastName"));
                e.setFirstName(rs.getString("FirstName"));
                e.setBirthDate(rs.getDate("BirthDate"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setAddress(rs.getString("Address"));
                e.setCity(rs.getString("City"));
                e.setCountry(rs.getString("Country"));
                e.setHomePhone(rs.getString("HomePhone"));
                e.setMobile(rs.getString("Mobile"));
                e.setEmail(rs.getString("Email"));
                e.setPhotoPath(rs.getString("PhotoPath"));
                e.setNote(rs.getString("Note"));
                vE.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return vE;
    }

    /**
     *
    get Employee by EmployeeID
     */
    public Employee getByID(int id) {
        String sql = "select * from Employees where EmployeeID=" + id;
        DAO dao = new DAO();
        try {
            ResultSet rs = dao.executeQuery(sql);
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setLastName(rs.getString("LastName"));
                e.setFirstName(rs.getString("FirstName"));
                e.setBirthDate(rs.getDate("BirthDate"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setAddress(rs.getString("Address"));
                e.setCity(rs.getString("City"));
                e.setCountry(rs.getString("Country"));
                e.setHomePhone(rs.getString("HomePhone"));
                e.setMobile(rs.getString("Mobile"));
                e.setEmail(rs.getString("Email"));
                e.setPhotoPath(rs.getString("PhotoPath"));
                e.setNote(rs.getString("Note"));
                return e;
            }
        } catch (SQLException ex) {
            dao.closeConnection();
            return null;
        }
        dao.closeConnection();
        return null;
    }

    /**
     *
    Convert from Vector to Employee Array
     */
    private Employee[] convertToArray(Vector v) {
        int n = v.size();
        if (n < 1) {
            return null;
        }
        Employee[] arrEmployee = new Employee[n];
        for (int i = 0; i < n; i++) {
            arrEmployee[i] = (Employee) v.get(i);
        }
        return arrEmployee;
    }
}