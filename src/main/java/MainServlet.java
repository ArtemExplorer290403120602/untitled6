import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config)  {
        System.out.println("This is init zapychen!!!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        logRequestTime(req.getSession());
        PrintWriter out=resp.getWriter();
        out.print("<h2> Приложение Артем на сайте!!!</h2>");
    }

    private void logRequestTime(HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        System.out.println("Запрос получен в " + currentTime);

        // Сохраняем время запроса в атрибут сессии
        session.setAttribute("requestTime", currentTime);

    }
}
