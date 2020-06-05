package uc.seng301.asg3.order;

import uc.seng301.asg3.egg.ChocolateEggFactory;
import uc.seng301.asg3.egg.ChocolateType;
import uc.seng301.asg3.ingredient.Filling;
import uc.seng301.asg3.packaging.PackagingType;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



/**
 * Implements the methods to make sure the regular hollow egg
 * uses balanced ratios.
 */
public class RegularHollowEggStrategy implements StrategyBase {

    private int hollowEggs = 0;
    private boolean isInternalEgg = false;
    private int fillingsCount = 0;

    @Override
    public ChocolateEggFactory getValidFactory(boolean stuffed, int quantity, ChocolateEggFactory hollowFactory, ChocolateEggFactory stuffedFactory) {
        ChocolateEggFactory nextFactory = stuffedFactory;
        double ratio = (quantity * 0.3) < 1 ? 1 : (quantity * 0.3);
        if (hollowEggs < ratio){
            nextFactory = hollowFactory;
        }
        if (nextFactory == hollowFactory) {
            hollowEggs += 1;
        }

        return nextFactory;
    }

    @Override
    public ChocolateType isValidChocolate(ChocolateType type, int quantity) {

        if ((!isInternalEgg) && (type.equals(ChocolateType.CRUNCHY))) {
            type = ChocolateType.WHITE;
        }
        isInternalEgg = true;
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
