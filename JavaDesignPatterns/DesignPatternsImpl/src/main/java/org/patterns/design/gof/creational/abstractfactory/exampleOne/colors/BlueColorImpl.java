package org.patterns.design.gof.creational.abstractfactory.exampleOne.colors;

import org.patterns.design.gof.creational.abstractfactory.exampleOne.enums.Color;

public class BlueColorImpl implements ColorFactory {
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
