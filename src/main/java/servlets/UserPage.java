package servlets;

import dto.builders.CreateSqlBuilder;
import dto.builders.DeleteSqlBuilder;
import dto.builders.ReadSqlBuilder;
import dto.builders.UpdateSqlBuilder;
import entity.mapper.UserInstructions;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositoty.CreateTable;
import repositoty.DeleteTable;
import repositoty.ReadTable;
import repositoty.UpdateTable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class UserPage extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        UserInstructions userInstructions = new UserInstructions(req);
        ReadSqlBuilder sql = new ReadSqlBuilder(userInstructions);
        PrintWriter printWriter = resp.getWriter();
        Map<String, String> preparedResp = ReadTable.readTable(sql, userInstructions);
        for (String key : preparedResp.keySet()){
            printWriter.println(key + " = " + preparedResp.get(key));
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserInstructions userInstructions = new UserInstructions(req);
        CreateSqlBuilder sql = new CreateSqlBuilder(userInstructions);
        CreateTable.createNewTable(sql, userInstructions);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Hello there");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        UserInstructions userInstructions = new UserInstructions(req);
        UpdateSqlBuilder sql = new UpdateSqlBuilder(userInstructions);
        UpdateTable.updateTable(sql, userInstructions);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Hello there");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        UserInstructions userInstructions = new UserInstructions(req);
        DeleteSqlBuilder sql = new DeleteSqlBuilder(userInstructions);
        DeleteTable.deleteTable(sql, userInstructions);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("Hello there");
    }

}