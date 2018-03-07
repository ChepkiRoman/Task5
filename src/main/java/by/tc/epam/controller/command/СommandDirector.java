package by.tc.epam.controller.command;

import by.tc.epam.controller.command.impl.DomParserCommand;
import by.tc.epam.controller.command.impl.SaxParserCommand;
import by.tc.epam.controller.command.impl.StaxParserCommand;

import java.util.HashMap;
import java.util.Map;

public class СommandDirector {
    private static Map<СommandEnumName, Command> commands;
    private static СommandDirector director = new СommandDirector();

    public static СommandDirector getDirector() {
        return director;
    }

    private СommandDirector() {
        commands = new HashMap<СommandEnumName, Command>();
        commands.put(СommandEnumName.DOM, new DomParserCommand());
        commands.put(СommandEnumName.STAX, new StaxParserCommand());
        commands.put(СommandEnumName.SAX, new SaxParserCommand());
    }
    public Command getCommand(String key){
        return commands.get(СommandEnumName.valueOf(key.toUpperCase()));
    }


}
