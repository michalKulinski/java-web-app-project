package app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloServlet.class);
    private static final String NAME_PARAM = "name";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request with parameters " + req.getParameterMap());

//           String name = Optional.ofNullable(req.getParameter(NAME_PARAM)).orElse("world");
//           resp.getWriter().write("Hello " + name + "!");

        String name = req.getParameter(NAME_PARAM);
        resp.getWriter().write(checkNameParameter(name));
    }

    private String checkNameParameter(String name) {
        if (name == null || name.isEmpty()) {
            name = "Hello world";
        } else {
            name = "Hello " + name + "!";
        }
        return name;
    }
}
