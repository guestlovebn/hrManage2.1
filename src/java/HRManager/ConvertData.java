/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager;

import java.util.Calendar;
import java.util.Date;
public class ConvertData {
    /**
     *
    get number day between 2 Date
     */
    public int diff(Date d1, Date d2) {
        long value = d1.getTime() - d2.getTime();
        return (int) (value / (1000 * 60 * 60 * 24));
    }

    /**
     *
    convert from String to Date
     */
    public Date string2date(String str) {
        ValidData valid = new ValidData();
        if (!valid.isDate(str)) {
            return null;
        }
        String[] arr = str.split("[\\/\\-]");
        int dd = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1])-1;
        int yyyy = Integer.parseInt(arr[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm, dd);
        return cal.getTime();
    }

    /**
     *
    convert from String to Date
     */
    public Date string2date(String str, int option) {
        ValidData valid = new ValidData();
        if (!valid.isDate(str, option)) {
            return null;
        }
        String[] arr = str.split("[\\/\\-]");
        int dd = 0, mm = 0;
        if (option == ValidData.VN_DATE) {
            dd = Integer.parseInt(arr[0]);
            mm = Integer.parseInt(arr[1])-1;
        } else if (option == ValidData.EN_DATE) {
            mm = Integer.parseInt(arr[0]);
            dd = Integer.parseInt(arr[1]);
        }
        int yyyy = Integer.parseInt(arr[2]);
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm, dd);
        return cal.getTime();
    }

    /**
     *
    convert from Date to String
     */
    public String date2string(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        String str = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
        return str;
    }

    /**
     *
    convert from Date to String
     */
    public String date2string(Date d, int option) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        String str = "";
        if (option == ValidData.EN_DATE) {
            str = (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
        } else if (option == ValidData.VN_DATE) {
            str = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
        }
        return str;
    }

    /**
     *
    convert from Date(java.util.Date) to sqlDate (java.sql.Date)
     */
    public java.sql.Date date2sqlDate(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        long millis = cal.getTime().getTime();
        java.sql.Date dSQL = new java.sql.Date(millis);
        return dSQL;
    }

    /**
     *
    convert from sqlDate (java.sql.Date) to Date(java.util.Date)
     */
    public Date sqlDate2date(java.sql.Date dSQL) {
        Calendar cal = Calendar.getInstance();
        long millis = dSQL.getTime();
        cal.setTimeInMillis(millis);
        return cal.getTime();
    }
}
