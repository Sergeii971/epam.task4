package com.verbovskiy.task4.builder;

import com.verbovskiy.task4.entity.Gem;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGemBuilder {
    protected List<Gem> gems;

    public AbstractGemBuilder() {
        gems = new ArrayList<>();
    }

    public List<Gem> getGems() {
        return gems;
    }

    public abstract void buildListGems(String fileName);
}
