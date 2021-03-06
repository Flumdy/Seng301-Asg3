package uc.seng301.asg3.order;

import uc.seng301.asg3.Context;
import uc.seng301.asg3.egg.ChocolateEggFactory;
import uc.seng301.asg3.egg.ChocolateType;
import uc.seng301.asg3.egg.HollowEggFactory;
import uc.seng301.asg3.egg.StuffedEggFactory;
import uc.seng301.asg3.ingredient.Filling;
import uc.seng301.asg3.packaging.PackagingType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Implements the methods to make sure the mixed box
 * of eggs uses balanced ratios.
 */
public class MixedBoxStrategy implements StrategyBase {

    private int stuffedEggs = 0;
    private int hollowEggs = 0;
    private Map<ChocolateType, Integer> typeCount = new LinkedHashMap<>();
    private int currentCrunchy = 0;
    private int fillingsCount = 0;

    @Override
    public ChocolateEggFactory getValidFactory(boolean stuffed, int quantity, ChocolateEggFactory hollowFactory, ChocolateEggFactory stuffedFactory) {
        int ratio = (quantity / 2) + 1;
        ChocolateEggFactory nextFactory = hollowFactory;
        int randomValue = ThreadLocalRandom.current().nextInt() % 2;
        if (stuffed && (stuffedEggs < ratio) && ((hollowEggs > ratio) || (randomValue == 0))){
            nextFactory = stuffedFactory;
        }
        if (nextFactory == stuffedFactory) {
            stuffedEggs += 1;
        } else {
            hollowEggs += 1;
        }
        return nextFactory;
    }

    @Override
    public ChocolateType isValidChocolate(ChocolateType type, int quantity) {
        double maxCrunchy = (quantity) < 10? 0: 1;
        double ratio = (quantity / ChocolateType.values().length) < 1 ? 1: (ChocolateType.values().length) + 1;
        boolean valid = false;

        while (!valid){
            valid = true;
            type = ChocolateType.values()[ThreadLocalRandom.current().nextInt(ChocolateType.values().length)];
            if (type.equals(ChocolateType.CRUNCHY)) {
                if (currentCrunchy >= maxCrunchy) {
                    valid = false;
                } else {
                    currentCrunchy += 1;
                }
            }
            if (!typeCount.containsValue(type)) {
                typeCount.put(type, 1);
            } else if (typeCount.get(type) >= ratio) {
                valid = false;
            } else {
                typeCount.put(type, typeCount.get(type) + 1);
            }
        }
        return type;
    }

    @Override
    public Filling getFilling(List<Filling> fillings, boolean containsAlcohol) {
        fillingsCount += 1;
        Filling filling = fillings.get(fillingsCount % fillings.size());
        while (filling.containsAlcohol() != containsAlcohol) {
            fillingsCount += 1;
            filling = fillings.get(fillingsCount % fillings.size());
        }
        return filling;
    }
}
