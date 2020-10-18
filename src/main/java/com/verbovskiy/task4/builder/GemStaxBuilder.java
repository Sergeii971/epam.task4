package com.verbovskiy.task4.builder;

import com.verbovskiy.task4.entity.Gem;
import com.verbovskiy.task4.entity.GemType;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class GemStaxBuilder extends AbstractGemBuilder {
    private static final Logger logger = LogManager.getLogger(GemStaxBuilder.class);
    private XMLInputFactory inputFactory;
    private static final String REGEX = "-";
    private static final String REPLACEMENT = "_";

    public GemStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildListGems(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(fileName))) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String name = reader.getLocalName();
                    if (name.contains(TagName.ELEMENT_GEMSTONE.getValue())) {
                        Gem gem = buildGem(reader);
                        if (name.equals(TagName.PRECIOUS_GEMSTONE.getValue())) {
                            gem.setPreciousness(GemType.PRECIOUS);
                        } else  {
                            gem.setPreciousness(GemType.SEMIPRECIOUS);
                        }
                        gems.add(gem);
                    }
                }
            }
        } catch (XMLStreamException e) {
            logger.log(Level.ERROR, "Error stax parsing", e);
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File {} not found "+ e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Error while closing file {}" + e);
        }
    }

    private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
        Gem gem = new Gem();
        String namespaceUri = "";
        gem.setId(reader.getAttributeValue(namespaceUri, TagName.ID.getValue()));
        String origin = reader.getAttributeValue(namespaceUri, TagName.ORIGIN.getValue());
        gem.setOrigin(origin);

       CYCLE: while (reader.hasNext()) {
           int type = reader.next();
           switch (type) {
               case XMLStreamConstants.START_ELEMENT:
                   String elementName = reader.getLocalName().replaceAll(REGEX, REPLACEMENT).toUpperCase();
                   if (TagName.valueOf(elementName) != TagName.PARAMETERS) {
                       switch (TagName.valueOf(elementName)) {
                           case NAME:
                               gem.setName(getXMLText(reader));
                               break;
                           case VALUE:
                               gem.setValue(Integer.parseInt(getXMLText(reader)));
                               break;
                           case CUT_DATE:
                               gem.setCutDate(LocalDateTime.parse(getXMLText(reader)));
                               break;
                               case COLOR:
                           gem.setColor(getXMLText(reader));
                           break;
                           case TRANSPARENCY:
                           gem.setTransparency(Integer.valueOf(getXMLText(reader)));
                           break;
                           case NUMBER_OF_FACES:
                           gem.setFaceNumber(Integer.valueOf(getXMLText(reader)));
                           break;
                           default:
                               throw new XMLStreamException("Unknown element in tag Gem");
                       }
                   }
                   break;
               case XMLStreamConstants.END_ELEMENT:
                   if (reader.getLocalName().contains(TagName.ELEMENT_GEMSTONE.getValue())) {
                       break CYCLE;
                   }
                   break;
           }
       }
        return gem;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
