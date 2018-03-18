package by.tc.epam.controller;

import by.tc.epam.service.Handler;
import by.tc.epam.service.command.Command;
import by.tc.epam.service.command.СommandDirector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private final String LIST_ATTR_NAME = "foodList";
    private final int RECORDS_PER_PAGE = 3;
    private final int PAGE_DIF = 1;
    private final double DOUBLE_ONE = 1.0;
    private final String NO_OF_PAGE_ATTR_NAME = "noOfPages";
    private final String PAGE_PARAMETER_NAME = "page";
    private final String CURRENT_PAGE_ATTR_NAME = "currentPage";
    private static int noOfRecords;

    public FrontController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String commandName = request.getParameter("command");
        СommandDirector director = СommandDirector.getDirector();
        Command command = director.getCommand(commandName);

        Handler handler = new Handler();
        HttpServletRequest request1 = handler.handle(commandName, request);


        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/view.jsp");
        view.forward(request1, response);


    }


}
