package by.tc.epam.service;

import by.tc.epam.dao.exception.ParsingDAOException;
import by.tc.epam.entity.Food;
import by.tc.epam.entity.FoodView;
import by.tc.epam.service.command.Command;
import by.tc.epam.service.command.СommandDirector;
import by.tc.epam.service.exception.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private static final int RECORDS_PER_PAGE = 3;
    private static final int PAGE_DIF = 1;
    private static final double DOUBLE_ONE = 1.0;
    private static int noOfRecords;

    public  FoodView handle(String commandName, String pageName) throws  ServiceException {
        FoodView foodView = new FoodView();
        try {


            СommandDirector director = СommandDirector.getDirector();
            Command command = director.getCommand(commandName);

            List<Food> foodList = command.getFoodList();
            int page = 1;
            noOfRecords = foodList.size() - RECORDS_PER_PAGE;
            if (pageName != null) {
                page = Integer.parseInt(pageName);
            }
            List<Food> responseList = getPartFromFoodList(foodList, (page - PAGE_DIF) * RECORDS_PER_PAGE, RECORDS_PER_PAGE);
            int noOfPages = (int) Math.ceil(noOfRecords * DOUBLE_ONE / RECORDS_PER_PAGE);


            foodView.setResponseList(responseList);
            foodView.setNoOfPage(noOfPages);
            foodView.setCurrentPage(page);


            foodList.clear();



        } catch ( IOException | SAXException | XMLStreamException | ParsingDAOException e) {
            throw new ServiceException();

        }
        return foodView;

    }


    private  List<Food> getPartFromFoodList(List<Food> list, int start, int count) {

        List<Food> foodPart = new ArrayList<>();
        int index = 0;
        for (int i = start; i < (start + count); i++) {
            foodPart.add(list.get(i));
            index++;
        }
        noOfRecords = list.size() - index;
        return foodPart;
    }
}
