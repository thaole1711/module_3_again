import com.example.login.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.time.LocalDateTime;


@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        if (action.equals("login")) {
           String user = req.getParameter("user");
           String password = req.getParameter("password");
           if(user.equals("addmin") && password.equals("123abc")) {
               LocalDateTime now = LocalDateTime.now();
               req.setAttribute("now",now);
              req.getRequestDispatcher("/view/success.jsp").forward(req,resp);
           }   else{
                 resp.sendRedirect("/view/login?mess=ten dang nhap hoac mat khau khong dung");
               }
        }
    }
}

