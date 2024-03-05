package servlets;

import dto.builders.CreateSqlBuilder;
import entity.mapper.UserInstructions;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositoty.CreateTable;

import java.io.IOException;
import java.io.PrintWriter;

public class Create extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserInstructions userInstructions = new UserInstructions(req);
        CreateSqlBuilder sql = new CreateSqlBuilder(userInstructions);
        CreateTable.createNewTable(sql, userInstructions);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Hello there");
    }
}
