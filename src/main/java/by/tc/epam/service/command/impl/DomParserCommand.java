package by.tc.epam.service.command.impl;

import by.tc.epam.service.command.Command;
import by.tc.epam.entity.Food;
import by.tc.epam.service.ServiceFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class DomParserCommand implements Command {
    private static final String FOODLIST = "foodList";
    @Override
    public List<Food> getFoodList() throws IOException, SAXException {
        ServiceFactory factory = ServiceFactory.getInstance();
        List<Food> foodList = factory.getParsingService().parseViaDom();
        return foodList;
    }
}