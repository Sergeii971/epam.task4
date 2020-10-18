package com.verbovskiy.task4.builder;

import com.sun.rowset.internal.XmlErrorHandler;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class GemSaxBuilder extends AbstractGemBuilder {
    private final Logger logger = LogManager.getLogger(GemSaxBuilder.class);
    private GemHandler handler = new GemHandler();
    private XMLReader reader;

    public GemSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
        } catch (SAXException | ParserConfigurationException e) {
            logger.log(Level.ERROR, "Error while parsing", e);
        }
        reader.setErrorHandler(new XmlErrorHandler());
        reader.setContentHandler(handler);
    }

    @Override
    public void buildListGems(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException | IOException e) {
            logger.log(Level.ERROR, "Error while parsing", e);
        }
        gems = handler.getGems();
    }
}
