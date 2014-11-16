package cdzdapp.web;

import cdzdapp.util.Database;
import cdzdapp.util.EnvironmentDetection;
import cdzdapp.util.ServerInfo;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        ServerInfo serverInfo = new ServerInfo();

        Map<String, Object> status = new LinkedHashMap<>();
        status.put("version", serverInfo.getVersion());
        status.put("server", serverInfo.getHostName());
        status.put("env", EnvironmentDetection.detectEnvironment());
        status.put("dbConnectionOk", Database.INSTANCE.canConnect());

        response.getWriter().print(new GsonBuilder().create().toJson(status));
    }
}