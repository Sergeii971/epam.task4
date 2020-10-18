package com.verbovskiy.task4.builder;

public enum TagName {
    GEMS("gems"), ID("id"), PRECIOUS_GEMSTONE("precious-gemstone"),
    SEMIPRECIOUS_GEMSTONE("semiprecious-gemstone"), NAME("name"), VALUE("value"),
    CUT_DATE("cut-date"), COLOR("color"), TRANSPARENCY("transparency"),
    NUMBER_OF_FACES("number-of-faces"), ORIGIN("origin"),ELEMENT_GEMSTONE ("gemstone"),
    PARAMETERS("parameters");

    private String value;

    private TagName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
