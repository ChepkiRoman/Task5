package by.tc.epam.service.command.impl;

import by.tc.epam.service.command.Command;
import by.tc.epam.entity.Food;
import by.tc.epam.service.ServiceFactory;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

public class StaxParserCommand implements Command {
    private static final String FOODLIST = "foodList";

    @Override
    public List<Food> getFoodList() throws FileNotFoundException, XMLStreamException {
        ServiceFactory factory = ServiceFactory.getInstance();
        List<Food> foodList = factory.getParsingService().parseViaStax();
        return foodList;
    }
}
