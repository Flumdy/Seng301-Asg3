package uc.seng301.asg3.order;

import uc.seng301.asg3.egg.ChocolateEggFactory;
import uc.seng301.asg3.egg.ChocolateType;
import uc.seng301.asg3.ingredient.Filling;
import uc.seng301.asg3.packaging.PackagingType;

import java.util.List;

public class StrategyContext {

    private final int quantity;
    private final ChocolateEggFactory hollowFactory;
    private final ChocolateEggFactory stuffedFactory;
    private StrategyBase strategy;

    public StrategyContext(StrategyBase strategy, int quantity, ChocolateEggFactory hollowFactory, ChocolateEggFactory stuffedFactory) {
        this.strategy = strategy;
        this.quantity = quantity;
        this.hollowFactory = hollowFactory;
        this.stuffedFactory = stuffedFactory;
    }

    public ChocolateEggFactory getValidFactory(boolean stuffed) {
        return strategy.getValidFactory(stuffed, quantity, hollowFactory, stuffedFactory);
    }

    public ChocolateType isValidChocolate(ChocolateType type) {
        return strategy.isValidChocolate(type, quantity);
    }

    public Filling getFilling (List<Filling> fillings, boolean containsAlcohol) {
        return strategy.getFilling(fillings, containsAlcohol);
    }
}
