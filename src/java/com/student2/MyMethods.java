
package com.student2;

import java.sql.*;
import javax.swing.JOptionPane;

public class MyMethods {

        Statement stm;
        ResultSet rs;
        Connection con;
        PreparedStatement prstm;

        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";

        public int MyDriver()  {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, "hr", "hr");
                  stm = con.createStatement();

            } catch (Exception sq) {
                JOptionPane.showMessageDialog(null, sq);

                return 1;
            }
            return 0;
        }
        public int MyExcution(String sqlstm){
            MyDriver();
            try{
                stm.executeUpdate(sqlstm);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
                return 1;
            }return 0;
        }

        public ResultSet MyQuery(String sqlstm) {
            MyDriver();
            try {
                rs=stm.executeQuery(sqlstm);

            } catch(Exception sq) {
                JOptionPane.showMessageDialog(null, sq);
            }
            return rs;
        }
    }
