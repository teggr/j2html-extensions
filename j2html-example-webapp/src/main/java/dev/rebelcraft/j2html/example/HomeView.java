package dev.rebelcraft.j2html.example;

import dev.rebelcraft.j2html.bootstrap.Quickstart;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Map;

@Component
public class HomeView extends AbstractView {

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String index = Quickstart.index();

        response.getWriter().write(index);

    }

}
