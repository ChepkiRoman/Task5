package by.tc.epam.service;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ParserService parsingService = new ParserService();

    private ServiceFactory(){

    }

    public ParserService getParsingService() {
        return parsingService;
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
}
