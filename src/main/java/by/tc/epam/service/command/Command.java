package by.tc.epam.service.command;

import by.tc.epam.entity.Food;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

public interface Command {
    List<Food> getFoodList() throws IOException, XMLStreamException, SAXException;
}
