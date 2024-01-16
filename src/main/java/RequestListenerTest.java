import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebListener
public class RequestListenerTest implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Запрос обрабатывается! ");
        HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
        String requestTime = (String) session.getAttribute("requestTime");
        System.out.println("Время запроса: " + requestTime);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Запрос завершен.");
    }
}
