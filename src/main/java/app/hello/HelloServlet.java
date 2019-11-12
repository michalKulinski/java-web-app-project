package app.hello;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Hello", urlPatterns = {"/api/*"})
public class HelloServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(HelloServlet.class);

    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";

    private HelloService service;

    /**
     *Servlet container needs it
     */
//    unused
    public HelloServlet(){
        this(new HelloService());
    }

    public HelloServlet(HelloService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request with parameters " + req.getParameterMap());
        String name = req.getParameter(NAME_PARAM);
        String lang = req.getParameter(LANG_PARAM);
        resp.getWriter().write(service.prepareGreeting(name, lang));
    }
}
