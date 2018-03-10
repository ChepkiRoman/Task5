package by.tc.epam.controller;

import by.tc.epam.controller.command.Command;
import by.tc.epam.controller.command.СommandDirector;
import by.tc.epam.entity.Food;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        this.doGet(request,response);
    }

    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String commandName = request.getParameter("command");
        СommandDirector director = СommandDirector.getDirector();
        Command command = director.getCommand(commandName);

        try {
            List<Food> foodList = command.getFoodList();
            int page = 1;
            noOfRecords = foodList.size() - RECORDS_PER_PAGE;
            if(request.getParameter(PAGE_PARAMETER_NAME) != null){
                page = Integer.parseInt(request.getParameter(PAGE_PARAMETER_NAME));
            }
            List<Food> responseList = getPartFromFoodList(foodList,(page-PAGE_DIF)*RECORDS_PER_PAGE,RECORDS_PER_PAGE);
            int noOfPages = (int) Math.ceil(noOfRecords * DOUBLE_ONE / RECORDS_PER_PAGE);
            request.setAttribute(LIST_ATTR_NAME,responseList);
            request.setAttribute(NO_OF_PAGE_ATTR_NAME, noOfPages);
            request.setAttribute(CURRENT_PAGE_ATTR_NAME, page);


            RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/view.jsp");
            view.forward(request, response);
            foodList.clear();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }




    }
    public List<Food> getPartFromFoodList(List<Food> list,int start , int count){

        List<Food> foodPart = new ArrayList<>();
        int index = 0;
        for(int i = start; i < (start + count); i++  ){
            foodPart.add(list.get(i));
            index++;
        }
        noOfRecords = list.size() - index;
        return foodPart;
    }



}
