package by.tc.epam.dao;

import by.tc.epam.entity.Food;
import by.tc.epam.entity.MenuTagName;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxMenuParser extends DefaultHandler{
    private List<Food> foodList = new ArrayList<Food>();
    private Food food;
    private StringBuilder text;

    public List<Food> getFoodList() {
        return foodList;
    }

    public static List<Food> parse(String path) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxMenuParser handler = new SaxMenuParser();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(path));
        List<Food> foodList = handler.getFoodList();
        return foodList;

    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (qName.equals("food")) {
            food = new Food();
            food.setId((Integer.parseInt(attributes.getValue("id"))));
        }
    }

    public void characters(char[] buffer, int start, int length) {
        text.append(buffer, start, length);
    }


    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tagName = MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case NAME:
                food.setName(text.toString());
                break;
            case PRICE:
                food.setPrice(text.toString());
                break;
            case DESCRIPTION:
                food.setDescription(text.toString());
                break;
            case CALORIES:
                food.setCalories(Integer.parseInt(text.toString()));
                break;
            case FOOD:
                foodList.add(food);
                food = null;
                break;
        }
    }
}
