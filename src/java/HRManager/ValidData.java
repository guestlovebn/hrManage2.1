/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidData {

    final public static int VN_DATE = 0;
    public final static int EN_DATE = 1;

    public boolean isPassword(String password) {
        String reg = "^[a-zA-Z]\\w{6,25}$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(password);
        return m.find();
    }

    public boolean isEmail(String email) {
        String reg = "^[a-zA-Z]\\w*\\@[a-zA-Z]\\w*\\.\\w*$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(email);
        return m.find();
    }

    public boolean isPhone(String phone) {
        String reg = "^[0-9][0-9]{6,9}[0-9]$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(phone);
        return m.find();
    }

    /**
     *
    check a String is Date
     */
    public boolean isDate(String date) {
        boolean check = false;
        String reg = "^[0-9][0-9]{0,1}[\\-\\/][0-9]{1,2}[\\-\\/][0-9][0-9][0-9][0-9]$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(date);
        if (m.find()) {
            String[] arr = date.split("[\\/\\-]");
            int dd = Integer.parseInt(arr[0]);
            int mm = Integer.parseInt(arr[1]);
            int yyyy = Integer.parseInt(arr[2]);
            if (yyyy > 1900 && yyyy < 2010) {
                switch (mm) {
                    case 2:
                        if (yyyy % 4 == 0) {
                            if (dd > 0 && dd < 30) {
                                check = true;
                            }
                        } else if (dd > 0 && dd < 29) {
                            check = true;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dd > 0 && dd < 31) {
                            check = true;
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dd > 0 && dd < 32) {
                            check = true;
                        }
                        break;
                }
            }
        }
        return check;
    }

    /**
     *
    check a String is Date
     */
    public boolean isDate(String date, int option) {
        boolean check = false;
        String reg = "^[0-9][0-9]{0,1}[\\-\\/][0-9]{1,2}[\\-\\/][0-9][0-9][0-9][0-9]$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(date);
        if (m.find()) {
            String[] arr = date.split("[\\/\\-]");
            int dd = 0, mm = 0;
            if (option == VN_DATE) {
                dd = Integer.parseInt(arr[0]);
                mm = Integer.parseInt(arr[1]);
            } else if (option == EN_DATE) {
                mm = Integer.parseInt(arr[0]);
                dd = Integer.parseInt(arr[1]);
            }
            int yyyy = Integer.parseInt(arr[2]);
            if (yyyy > 1900 && yyyy < 2010) {
                switch (mm) {
                    case 2:
                        if (yyyy % 4 == 0) {
                            if (dd > 0 && dd < 30) {
                                check = true;
                            }
                        } else if (dd > 0 && dd < 29) {
                            check = true;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dd > 0 && dd < 31) {
                            check = true;
                        }
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dd > 0 && dd < 32) {
                            check = true;
                        }
                        break;
                }
            }
        }
        return check;
    }
}