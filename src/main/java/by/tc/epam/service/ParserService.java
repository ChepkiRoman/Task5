package by.tc.epam.service;

import by.tc.epam.dao.DomMenuParser;
import by.tc.epam.dao.SaxMenuParser;
import by.tc.epam.dao.StaxMenuParser;
import by.tc.epam.entity.Food;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ParserService {
    private List<Food> result;
    public List<Food> parseViaDom() throws IOException, SAXException {
        result = DomMenuParser.parse("/Users/RomanChepki/Documents/Programming/untitled3/src/main/resources/menu.xml");
        return result;
    }

    public List<Food> parseViaStax() throws FileNotFoundException, XMLStreamException {
        result = StaxMenuParser.parse("/Users/RomanChepki/Documents/Programming/untitled3/src/main/resources/menu.xml");
        return  result;
    }
    public List<Food> parseViaSax() throws IOException, SAXException {
        result = SaxMenuParser.parse("/Users/RomanChepki/Documents/Programming/untitled3/src/main/resources/menu.xml");
        return result;
    }
}
