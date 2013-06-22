/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Customer", urlPatterns = {"/Customer"})
public class Customer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("Customer Servlet");
            String id = request.getParameter("txtId");

            BankBean bb = new BankBean();
            bb.setId(Integer.parseInt(id));

            BankDB db = new BankDB();
            ResultSet record = db.select(bb);

            if (record.next()) {
                request.setAttribute("data", bb);
                out.println("hello");

                float balance = record.getFloat(3);
                bb.setId(record.getInt(1));
                bb.setName(record.getString(2));
                bb.setBalance(balance);
                
                if (balance > 10000) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/GoodCustomer.jsp");
                    rd.forward(request, response);
                    out.print("");
                }
                if (balance > 0) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/NormalCustomer.jsp");
                    rd.forward(request, response);
                    out.print("NormalCustomer");
                }
                if (balance < 0) {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/BedCustomer.jsp");
                    rd.forward(request, response);
                    out.print("BedCustomer");
                }
            } else {
                request.setAttribute("data","Invalid ID...");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }
            out.println(id);
        } catch (Exception ex) {
            out.println(ex);
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
