package cn.iisheng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cn.iisheng.domain.UserDO;
import cn.iisheng.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author iisheng
 * @date 2018/03/20 20:41:26
 */
@WebServlet(urlPatterns = "/hello", asyncSupported = true)
public class HelloController extends HttpServlet {

    public HelloController() {
        System.out.println("===== HelloController构造器方法 =====");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("===== init方法 =====");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===== service方法 =====");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===== doGet =====");
        req.getParameterMap();
        req.setAttribute("param", "iisheng");
        resp.setContentType("text/json; charset=utf-8");
        String id = "1";
        UserDO userDO = new UserService().getById(id);
        String result = new ObjectMapper().writeValueAsString(userDO);
        System.out.println(result);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("===== doPost =====");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("===== destroy =====");
    }
}
