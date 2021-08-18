package com.example.conferences;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command {
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        try {
            userDao.registerUser(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
