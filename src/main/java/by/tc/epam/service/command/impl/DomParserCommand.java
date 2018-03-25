package by.tc.epam.service.command.impl;

import by.tc.epam.dao.DomMenuParser;
import by.tc.epam.dao.exception.ParsingDAOException;
import by.tc.epam.entity.Food;
import by.tc.epam.service.command.Command;

import java.util.List;

public class DomParserCommand implements Command {

    @Override
    public List<Food> getFoodList() throws ParsingDAOException {
        List<Food> foodList = DomMenuParser.parse("menu.xml");
        return foodList;
    }
}
