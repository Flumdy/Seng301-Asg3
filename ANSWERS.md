# SENG301 Assignment 1 (2020) - student answers


## Task 1 - Identify the patterns

### Pattern 1 -  ??

- What pattern is it? 

    Abstract Factory
    
- What is its goal in the code?

    'PreparingOrder.java' imports the factories and the 'ChocolateEgg' super class.
    The factories produce the chocolate eggs based on the information about the eggs provided.
    This means the classes of the factories or the eggs never need to be concretely specified.
     
- Name of UML Class diagram attached:

    abstract_factory_UML.jpeg
- Mapping to GoF pattern elements:

| GoF element           | Code element          |
|-----------------------|-----------------------|
|  AbstractCreator |  ChocolateEggFactory|
|  ConcreteCreator | StuffedEggFactory  |
|  ConcreteCreator | HolloweEggFactory  |
|  AbstractProduct | ChocolateEgg |
| ConcreteProduct  | StuffedChocolateEgg |
| ConcreteProduct  | HollowChocolateEgg |
|FactoryMethod |  createChocolateEgg(ChocolateEgg, Boolean) |    
### Pattern 2 -  ??

- What pattern is it? 
    
    Command
- What is its goal in the code?
    
    The app has a counter object that stores orders in a queue.
    The counter passes the orders to Chocolatier which can execute them
    through PreparingOrder.
- Name of UML Class diagram attached:

    command_uml.jpeg
- Mapping to GoF pattern elements:

| GoF element           | Code element          |
|-----------------------|-----------------------|
| ConcreteCommand | Counter |
| Reciever |  Chocolatier |
| Invoker  | App  |

[note: There is no 'Command' GoF element as their is only one ConcreteCommand
present (Counter), so it can be hard coded in without an interface. There is also no Client, but that could be justified 
as the user interacting through the app.]

### Pattern 3 - ??

- What pattern is it? 

    Facade
- What is its goal in the code?

    The app is designed as a wrapper for the rest of the programs
    functionality to maximise abstraction. This means the full complexity
    of the code can be hidden away in related packages
    but its functionality remains completely readable through the app.
    
- Name of UML Class diagram attached:

    facade_uml.jpeg
- Mapping to GoF pattern elements:

| GoF element           | Code element          |
|-----------------------|-----------------------|
| Facade  |  App    |
| Package |  egg|
| Package  |  ingredient|
| Package   | order  |
| Package   | packaging |

[note: the Classes GoF elements are not specified as there are heaps,
but they are listed in respect to their packages in the UML diagram]

## Task 2 - Full UML Class diagram

- Name of file of full UML Class diagram attached:
    full_uml_class_diagram.jpeg
- More explanation (if needed):
    
## Task 3 - Implement new features

### Task 3.1 - balanced packaging 

- What pattern fulfils the need for the feature?

    Strategy
- What is its goal and why is it needed here?

    The strategy allows the PrepareOrder to function in a uniform manor
    while passing off the variation in functionality to each respective strategy.
    This allows for the complexity of the restraints implemented by each feature
    to be hidden away and increases abstraction.
    Further, if any change needs to be made to a packaging type it can be done 
    solely from the strategy used to implement it
- Name of UML Class diagram attached: 

    strategy_uml.jpeg
- Mapping to GoF pattern elements:

| GoF element           | Code element          |
|-----------------------|-----------------------|
| Client   |  PrepareOrder |
| Context |  StrategyContext |
| StrategyBase |  StrategyBase| 
| ConcreteStrategy| MixedBoxStrategy |
| ConcreteStrategy| RegularBoxStrategy|
| ConcreteStrategy| MixedHollowEggStrategy |
| ConcreteStrategy| RegularHollowEggStrategy |

### Task 3.2 - fill in the packages with eggs

- What pattern fulfils the need for the feature?

- What is its goal and why is it needed here?
- Name of UML Class diagram attached: 
- Mapping to GoF pattern elements:

| GoF element           | Code element          |
|-----------------------|-----------------------|
|                       |                       |
|                       |                       |

I did not complete this task, however I would like to not it could be 
done with a singleton object which has the function of sorting an eggs list,
or by removing the multi-threading functionality as the fillings iterator would
produce a unique egg on every call anyway. 
