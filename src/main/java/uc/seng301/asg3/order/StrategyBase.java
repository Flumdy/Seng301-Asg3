package uc.seng301.asg3.order;

import uc.seng301.asg3.egg.ChocolateEggFactory;
import uc.seng301.asg3.egg.ChocolateType;
import uc.seng301.asg3.ingredient.Filling;
import uc.seng301.asg3.packaging.PackagingType;

import java.util.List;

/**
 * Defines the abstract methods for the strategies required for
 * output type.
 */
public interface StrategyBase {


    /**
     * Abstract method for determining if a egg with packaging type
     * is still allowed in order to maintain ratios
     */
    public ChocolateEggFactory getValidFactory(boolean stuffed, int quantity, ChocolateEggFactory hollowFactory, ChocolateEggFactory stuffedFactory);

    /**
     * Abstract method for determining if an eggs chocolate type is
     * still allowed in order to maintain ratios
     */
    public abstract ChocolateType isValidChocolate(ChocolateType type, int quantity);

    /**
     * Decides what filling to put in an egg if the factory is stuffed,
     * otherwise it shouldnt be called
     * @return Filling to be used in stuffed egg if valid
     */
    public abstract Filling getFilling(List<Filling> fillings, boolean containsAlcohol);

}
