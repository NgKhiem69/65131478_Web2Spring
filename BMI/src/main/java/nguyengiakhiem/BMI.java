package nguyengiakhiem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BMI
 */
@WebServlet("/BMI")
public class BMI extends HttpServlet {

    // HIỂN THỊ FORM
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/bmi_form.html")
               .forward(request, response);
    }

    // XỬ LÝ BMI
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));

        double bmi = weight / (height * height);

        String result;
        if (bmi < 18.5)
            result = "Gầy";
        else if (bmi < 24.9)
            result = "Bình thường";
        else if (bmi < 29.9)
            result = "Thừa cân";
        else
            result = "Béo phì";

        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("bmi", String.format("%.2f", bmi));
        request.setAttribute("result", result);

        request.getRequestDispatcher("/bmi_result.jsp")
               .forward(request, response);
    }
}