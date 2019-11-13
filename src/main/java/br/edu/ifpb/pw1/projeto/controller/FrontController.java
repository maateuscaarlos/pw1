package br.edu.ifpb.pw1.projeto.controller;

import br.edu.ifpb.pw1.projeto.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("command");
            Command command = (Command) Class.forName("br.edu.ifpb.pw1.projeto.controller." + action).newInstance();
            command.execute(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
