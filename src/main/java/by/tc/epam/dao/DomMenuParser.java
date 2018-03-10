package by.tc.epam.dao;

import by.tc.epam.entity.Food;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public   class DomMenuParser {
    public static List<Food> parse(String path) throws SAXException, IOException{
        DOMParser parser = new DOMParser();
        parser.parse(path);
        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        List<Food> foodList = new ArrayList<Food>();
            NodeList foodNodes = root.getElementsByTagName("food");
            Food food = null;
        for (int i = 0; i < foodNodes.getLength() ; i++) {
            food = new Food();
            Element foodElement = (Element)foodNodes.item(i);
            food.setId(Integer.parseInt(foodElement.getAttribute("id")));
            food.setName(getSingleChild(foodElement,"name").getTextContent().trim());
            food.setDescription(getSingleChild(foodElement,"description").getTextContent().trim());
            food.setPrice(getSingleChild(foodElement,"price").getTextContent().trim());
            food.setCalories(Integer.valueOf(getSingleChild(foodElement,"calories").getTextContent().trim()));
            foodList.add(food);

        }
        return foodList;
    }

    private static Element getSingleChild(Element element, String childElemnt) {
        NodeList nodeList = element.getElementsByTagName(childElemnt);
        Element child = (Element)nodeList.item(0);
        return child;
    }

}
