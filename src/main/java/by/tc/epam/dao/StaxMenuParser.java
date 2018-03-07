package by.tc.epam.dao;

import by.tc.epam.entity.Food;
import by.tc.epam.entity.MenuTagName;
import by.tc.epam.entity.XMLStreamConstants;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StaxMenuParser {
    private static XMLInputFactory inputFactory = XMLInputFactory.newInstance();

    public static List<Food> parse(String path) throws XMLStreamException, FileNotFoundException {
          InputStream input = new FileInputStream(path);
         XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

         List<Food> foodList = new ArrayList<>();
         Food food = null;
        MenuTagName elementName = null;

        while(reader.hasNext()){
            int type = reader.next();

            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                    switch (elementName){
                        case FOOD:
                            food = new Food();
                            Integer id = Integer.parseInt(reader.getAttributeValue(null,"id"));
                            food.setId(id);
                            break;
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String text = reader.getText().trim();
                    if (text.isEmpty()) { break;
                    }
                    switch (elementName) { case NAME:
                        food.setName(text);
                        break; case PRICE:
                        food.setPrice(text);
                        break; case DESCRIPTION:
                        food.setDescription(text);
                        break; case CALORIES:
                        Integer calories = Integer.parseInt(text); food.setCalories(calories);
                        break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    elementName = MenuTagName.getElementTagName(reader.getLocalName());
                switch (elementName){
                    case FOOD:
                        foodList.add(food);
                }

            }

        }


        return foodList;
    }
}
