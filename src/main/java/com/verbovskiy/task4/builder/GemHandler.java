package com.verbovskiy.task4.builder;

import com.verbovskiy.task4.entity.Gem;
import com.verbovskiy.task4.entity.GemType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GemHandler extends DefaultHandler {
    private List<Gem> gems;
    private Gem gem;
    private TagName currentTag;
    private EnumSet<TagName> withText;
    private static final String REGEX = "-";
    private static final String REPLACEMENT = "_";

    public GemHandler() {
        gems = new ArrayList<>();
        withText = EnumSet.range(TagName.NAME, TagName.NUMBER_OF_FACES);
    }

    public List<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (qName.contains(TagName.ELEMENT_GEMSTONE.getValue())) {
            gem = new Gem();
            if (TagName.PRECIOUS_GEMSTONE.getValue().equals(qName)) {
                gem.setPreciousness(GemType.PRECIOUS);
            } else {
                gem.setPreciousness(GemType.SEMIPRECIOUS);
            }
            String id = attrs.getValue(0);
            gem.setId(id);
            String origin = attrs.getValue(1);
            gem.setOrigin(origin);
        } else {
            qName = qName.replaceAll(REGEX, REPLACEMENT);
            TagName temp = TagName.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.contains(TagName.ELEMENT_GEMSTONE.getValue())) {
            gems.add(gem);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).replaceAll("\\s", "");
        if (currentTag != null) {
            switch (currentTag) {
                case NAME:
                    gem.setName(data);
                    break;
                case VALUE:
                    gem.setValue(Integer.parseInt(data));
                    break;
                case CUT_DATE:
                    gem.setCutDate(LocalDateTime.parse(data));
                    break;
                case COLOR:
                    gem.setColor(data);
                    break;
                case TRANSPARENCY:
                    gem.setTransparency(Integer.parseInt(data));
                    break;
                case NUMBER_OF_FACES:
                    gem.setFaceNumber(Integer.parseInt(data));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
            }
        }
        currentTag = null;
    }
}
