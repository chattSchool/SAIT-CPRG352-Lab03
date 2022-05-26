package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dakota
 */
public class ArithmeticCalculatorServlet extends HttpServlet {

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
        
        String defaultResultMessage = "---";
        request.setAttribute("result", defaultResultMessage);
        
        //Load JSP file
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
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
        
        //Capture first and second number inputs
        String first = request.getParameter("firstNum");
        String second = request.getParameter("secondNum");
        String resultMessage = "";
                
        //Ensure any values previously entered remain upon error
        request.setAttribute("firstNum", first);
        request.setAttribute("secondNum", second);
        
        //Input validation
        if(first == null || second == null || first.equals("") || second.equals("")) {
            resultMessage = "invalid";
        } else {
            try {
                int firstNum = Integer.parseInt(first);
                int secondNum = Integer.parseInt(second);

                //Detects the value of the calculation button pressed
                switch(request.getParameter("button")) {
                    case "+":
                        resultMessage = Integer.toString(add(firstNum, secondNum));
                        break;
                    case "-":
                        resultMessage = Integer.toString(subtract(firstNum, secondNum));
                        break;
                    case "*":
                        resultMessage = Integer.toString(multiply(firstNum, secondNum));
                        break;
                    case "%":
                        resultMessage = Integer.toString(modulus(firstNum, secondNum));
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                resultMessage = "invalid";
            }
        }
        
        request.setAttribute("result", resultMessage);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }
    
    private int add(int first, int second) {
        return first + second;
    }
    
    private int subtract(int first, int second) {
        return first - second;
    }
    
    private int multiply(int first, int second) {
        return first * second;
    }
    
    private int modulus(int first, int second) {
        return first % second;
    }
}
