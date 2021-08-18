package com.example.conferences;

import com.example.conferences.Command;
import com.example.conferences.CommandPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Implementation of Controller in MVC
 * Implementation of PRG pattern
 * Get request from UI, execute a command on model and send redirect on view element
 */

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processing(request, response);
    }

    private void processing(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException{

        //Getting command parameter from UI
        String commandName = request.getParameter("command");
        //Find a command in Command pool
        Command command = CommandPool.getCommand(commandName);
        //Send execute to command
        String forward = command.execute(request, response);
        //Create response
        response.sendRedirect(request.getContextPath() + forward);
    }
}
