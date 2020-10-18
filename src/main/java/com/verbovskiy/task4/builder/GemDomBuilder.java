package com.verbovskiy.task4.builder;

import com.verbovskiy.task4.entity.Gem;

import com.verbovskiy.task4.entity.GemType;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GemDomBuilder extends AbstractGemBuilder {
    private DocumentBuilder documentBuilder;
    private final Logger logger = LogManager.getLogger(GemDomBuilder.class);

    public GemDomBuilder() {
        this.gems = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "Error in parser configuration", e);
        }
    }

    @Override
    public void buildListGems(String fileName) {
        Document document;
        try {
            document = documentBuilder.parse(fileName);
            Element root = document.getDocumentElement();
            NodeList preciousGemsList = root.getElementsByTagName(TagName.PRECIOUS_GEMSTONE.getValue());

            for (int i = 0; i < preciousGemsList.getLength(); i++) {
                Element gemElement = (Element) preciousGemsList.item(i);
                Gem gem = buildGem(gemElement);
                gem.setPreciousness(GemType.PRECIOUS);
                gems.add(gem);
            }
            NodeList semipreciousGemsList = root.getElementsByTagName(TagName.SEMIPRECIOUS_GEMSTONE.getValue());

            for (int i = 0; i < semipreciousGemsList.getLength(); i++) {
                Element gemElement = (Element) semipreciousGemsList.item(i);
                Gem gem = buildGem(gemElement);
                gem.setPreciousness(GemType.SEMIPRECIOUS);
                gems.add(gem);
            }
        } catch (SAXException | IOException e) {
            logger.log(Level.ERROR, "Error while parsing", e);
        }
    }

    private Gem buildGem(Element gemElement) {
        Gem gem = new Gem();
        gem.setId(gemElement.getAttribute(TagName.ID.getValue()));
        gem.setOrigin(gemElement.getAttribute(TagName.ORIGIN.getValue()));
        gem.setName(getElementByTagName(gemElement, TagName.NAME.getValue()));
        gem.setValue(Integer.parseInt(getElementByTagName(gemElement, TagName.VALUE.getValue())));
        gem.setCutDate(LocalDateTime.parse(getElementByTagName(gemElement,TagName.CUT_DATE.getValue())));
        Element parametersElement = (Element) gemElement.getElementsByTagName(TagName.PARAMETERS.getValue())
                .item(0);
        gem.setColor(getElementByTagName(parametersElement, TagName.COLOR.getValue()));
        gem.setTransparency(Integer.parseInt(getElementByTagName(parametersElement, TagName.TRANSPARENCY.getValue())));
        gem.setFaceNumber(Integer.parseInt(getElementByTagName(parametersElement, TagName.NUMBER_OF_FACES.getValue())));
        return gem;
    }

    private static String getElementByTagName(Element element, String tag) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);

        return node.getTextContent();
    }
}
