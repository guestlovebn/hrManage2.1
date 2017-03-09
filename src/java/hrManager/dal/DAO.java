/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hrManager.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private Connection cnn;
    private String driver;
    private String urlDriver;
    private String hostName;
    private String port;
    private String databaseName;
    private String userName;
    private String password;

    public DAO() {
        this.driver = "com.mysql.jdbc.Driver";
        this.urlDriver = "jdbc:mysql://";
        this.hostName = "127.0.0.1";
        this.port = "5069";
        this.databaseName = "HrManageCodeRefactoring";
        this.userName = "root";
        this.password = "0412";
        this.openConnection();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        if (cnn == null) {
            openConnection();
        }
        ResultSet rs = null;
        Statement stm = cnn.createStatement();
        rs = stm.executeQuery(sql);
        return rs;
    }

    public int executeUpdateQuery(String sql) {
        if (cnn == null) {
            openConnection();
        }
        int resultCount = 0;
        try {
            Statement stm = cnn.createStatement();
            resultCount = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return resultCount;
    }

    public void openConnection() {
        try {
            Class.forName(this.driver);
            cnn = DriverManager.getConnection(this.urlDriver + this.hostName + ":" + this.port + "/" + this.databaseName, this.userName, this.password);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return cnn;
    }

    public void closeConnection() {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException ex) {
            }
        }
    }

    /**
     * @return the urlDriver
     */
    public String getUrlDriver() {
        return urlDriver;
    }

    /**
     * @param urlDriver the urlDriver to set
     */
    public void setUrlDriver(String urlDriver) {
        this.urlDriver = urlDriver;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * @return the databaseName
     */
    public String getDatabaseName() {
        return databaseName;
    }

    /**
     * @param databaseName the databaseName to set
     */
    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}
