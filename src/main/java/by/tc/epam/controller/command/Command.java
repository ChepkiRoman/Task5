package by.tc.epam.controller.command;

import by.tc.epam.entity.Food;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SAXException, XMLStreamException;
    List<Food> getFoodList() throws IOException, XMLStreamException, SAXException;
}
