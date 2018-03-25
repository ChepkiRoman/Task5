package by.tc.epam.controller;

import by.tc.epam.entity.FoodView;
import by.tc.epam.service.Handler;
import by.tc.epam.service.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FrontController.class);
    private static final String ERROR_PAGE_404 = "/WEB-INF/jsp/error_page.jsp";
    private static final String PAGE_PARAMETER_NAME = "page";
    private static final String NO_OF_PAGE_ATTR_NAME = "noOfPages";
    private static final String LIST_ATTR_NAME = "foodList";
    private static final String CURRENT_PAGE_ATTR_NAME = "currentPage";
    private static final String PARSED_VIEW = "WEB-INF/jsp/view.jsp";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            String commandName = request.getParameter("command");
            String pageName = request.getParameter(PAGE_PARAMETER_NAME);


            Handler handler = new Handler();
            FoodView foodView = handler.handle(commandName,pageName);
            request.setAttribute(LIST_ATTR_NAME, foodView.getResponseList());
            request.setAttribute(NO_OF_PAGE_ATTR_NAME, foodView.getNoOfPage());
            request.setAttribute(CURRENT_PAGE_ATTR_NAME, foodView.getCurrentPage());


            RequestDispatcher view = request.getRequestDispatcher(PARSED_VIEW);
            view.forward(request, response);
        }catch (ServiceException e){
            LOGGER.error("Exception was occurred in controller class ");
            RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_PAGE_404);
            dispatcher.forward(request, response);
        }



    }


}
