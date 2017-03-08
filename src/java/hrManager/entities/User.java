/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager.entities;

public class User implements java.io.Serializable {

    private int userID;
    private String userName;
    private String userPassword;

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean equals(User u) {
        return this.userName.equals(u.userName);
    }
}