package com.shucai.servlet;

import com.shucai.factory.ProxyFactory;
import com.shucai.pojo.Result;
import com.shucai.service.TransferService;
import com.shucai.utils.JsonUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "transferServlet", urlPatterns = "/transferServlet")
public class TransferServlet extends HttpServlet {
    private TransferService transferService = null;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ProxyFactory proxyFactory = (ProxyFactory) context.getBean("proxyFactory");
        transferService = (TransferService) proxyFactory.getJdkProxy(context.getBean("transferService"));
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String fromCardNo = req.getParameter("fromCardNo");
        String toCardNo = req.getParameter("toCardNo");
        String moneyStr = req.getParameter("money");

        int money = Integer.parseInt(moneyStr);

        Result result = new Result();

        try {
            transferService.transfer(fromCardNo, toCardNo, money);
            result.setStatus("200");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("201");
            result.setMessage(e.toString());
        }

        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(JsonUtils.object2Json(result));
    }
}
