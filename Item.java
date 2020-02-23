import java.util.*;

public class Item
{
  String name;
  String description;
  ArrayList availableActions = new ArrayList();
  ArrayList possibleActions = new ArrayList();

  public Item(String name, String description, ArrayList actions)
  {
    this.name = name;
    this.description = description;
    int x = 0;
    boolean canDo = false;
    while(x < actions.size())
    {
      canDo = Action.checkCondition(actions.get(x));
      if(canDo)
      {
        availableActions.add(actions.get(x));
      }
      else
      {
        possibleActions.add(actions.get(x));
      }
      x+=1;
    }
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public void checkActions()
  {
    int x = 0;
    boolean canDo = false;
    while(x < possibleActions.size())
    {
      canDo = Action.checkCondition(possibleActions.get(x));
      if(canDo)
      {
        availableActions.add(possibleActions.get(x));
      }
      x+=1;
    }

    x = 0;
    while(x < availableActions.size())
    {
      canDo = Action.checkCondition(availableActions.get(x));
      if(!canDo)
      {
        possibleActions.add(availableActions.get(x));
      }
      x+=1;
    }
  }
}
