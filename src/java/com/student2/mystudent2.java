/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.student2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author User
 */
public class mystudent2 extends HttpServlet {

    MyMethods mm = new MyMethods();
    String Id;
    String Name;
    String Age;
    String stm;
    PrintWriter out;

    protected void dataInput(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        Id = request.getParameter("stdId");
        Name = request.getParameter("stdname");
        Age = request.getParameter("stage");

    }

    protected void processInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        dataInput(request, response);
        stm = "insert into student2 values (" + Id + ",'" + Name + "'," + Age + ")";
        int i = mm.MyExcution(stm);
        if (i != 1) {
            out.println("<br> Record has been Inserted");
        } else {
            out.println("failed to insert the date");
        }
        out.close();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mystudent2</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mystudent2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String f = "/error.jsp";
        String t = "/form.jsp";

        response.setContentType("text/html");
        dataInput(request, response);
        stm = "select * from student2 where id=" + Id;
        ResultSet res = mm.MyQuery(stm);

        String un = null;
        if (res != null) {
            try {
                while (res.next()) {
                    un = res.getString("name");

                }
            } catch (SQLException e) {
            }

            if (Name.equalsIgnoreCase(un)) {
                // JOptionPane.showMessageDialog(null, "Success");
                RequestDispatcher rd = getServletContext().getRequestDispatcher(t);
                rd.forward(request, response);
            } else {
                //    JOptionPane.showMessageDialog(null, "Failed");
                RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
                rd.forward(request, response);
            }

        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher(f);
            rd.forward(request, response);
        }

    }

    protected void processSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataInput(request, response);
        stm = "select * from student2";
        ResultSet res = mm.MyQuery(stm);
        try {
            ResultSetMetaData rsmd = res.getMetaData();
            int columns = rsmd.getColumnCount();
            out.print("<table border=" + 1 + ">");
            out.print("<thead>");
            out.print("<tr>");
            for (int i = 0; i < columns; i++) {
                out.print("<td>");
                out.print(rsmd.getColumnLabel(i + 1));
                out.print("</td>");
            }
            out.print("</td>");
            out.print("</thead>");
            while (res.next()) {
                out.print("<tr>");
                for (int i = 0; i < columns; i++) {
                    out.print("<td>");
                    out.print(res.getString(i + 1));
                    out.print("</td>");
                }
                out.print("</tr>");

            }
            out.print("</table>");

        } catch (Exception e) {
            out.close();
        }

    }

    protected void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataInput(request, response);
        stm = "update student2 SET NAME='" + Name + "', AGE =" + Age + " where ID=" + Id;

        try {
            int i = mm.MyExcution(stm);
            if (i != 1) {
                out.println("<br> Record has been Updated");
            } else {
                out.println("failed to Update the date");
            }
            out.close();
        } catch (Exception e) {
        }

    }

    protected void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataInput(request, response);
        stm = "DELETE FROM student2 where ID=" +Id;
         try {
            int i = mm.MyExcution(stm);
            if (i != 1) {
                out.println("<br> Record has been Deleted");
            } else {
                out.println("failed to Delete the date");
            }
            out.close();
        } catch (Exception e) {
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processInsert(request, response);
        processLogin(request, response);
        processSearch(request, response);
        processUpdate(request, response);
        processDelete(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("insert") != null) {
            processInsert(request, response);
        }

        if (request.getParameter("login") != null) {
            processLogin(request, response);
        }
        if (request.getParameter("show") != null) {
            processSearch(request, response);
        }
        if (request.getParameter("update") != null) {
            processUpdate(request, response);
        }
        if (request.getParameter("delete") != null) {
            processDelete(request, response);
        }

//        if(request.getParameter("update") != null){
//            processInsert(request, response);
//        }
//        if(request.getParameter("delete") != null){
//            processInsert(request, response);
//        }
//      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
