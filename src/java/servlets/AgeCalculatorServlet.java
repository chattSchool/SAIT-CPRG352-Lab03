package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dakota Chatt
 * 
 */
public class AgeCalculatorServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Loading JSP file
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Capture age parameter
        String age = request.getParameter("age");
        
        //Validating age input
        if(age == null || age.equals("")) {
            String errorMessage = "You must give your current age.";
            request.setAttribute("message", errorMessage);
        } else {
            //Parsing to integer form and detecting if proper data type
            try {
                int ageNum = Integer.parseInt(age);
                ageNum = incAge(ageNum);
                
                String ageCalcMessage = "Your age next birthday will be " + ageNum;
                request.setAttribute("message", ageCalcMessage);
                
            } catch (NumberFormatException e) {
                String errorMessage = "You must enter a number.";
                request.setAttribute("message", errorMessage);
            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
    
    /**
     * Increments the supplied age by one
     * 
     * @param age
     * @return supplied age plus one
     */
    private int incAge(int age) {
        return ++age;
    }
}
