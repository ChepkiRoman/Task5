package by.tc.epam.controller.command.impl;

import by.tc.epam.controller.command.Command;
import by.tc.epam.entity.Food;
import by.tc.epam.service.ServiceFactory;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SaxParserCommand implements Command {
    private static final String FOODLIST = "foodList";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SAXException, XMLStreamException {
        ServiceFactory factory = ServiceFactory.getInstance();
        List<Food> foodList = factory.getParsingService().parseViaSax();
        request.setAttribute(FOODLIST,foodList);
    }

    @Override
    public List<Food> getFoodList() throws FileNotFoundException, XMLStreamException {
        return null;
    }
}
