package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "Lang", urlPatterns = {"/api/langs"})
public class LangServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LangServlet.class);

    private LangRepository repository;
    private ObjectMapper mapper;


    /**
     *Servlet container needs it
     */
//    unused
    public LangServlet(){
        this(new LangRepository(), new ObjectMapper());
    }

    LangServlet(LangRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request with parameters " + req.getParameterMap());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), repository.findAll());
        //resp.getWriter().write(service.prepareGreeting(name, lang));
    }
}
