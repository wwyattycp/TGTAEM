import java.util.*;
 class Wall
 {
  int ID;
  String description;
  boolean door;
  ArrayList items = new ArrayList();
  ArrayList npcs = new ArrayList();
  ArrayList availableActions = new ArrayList();
  ArrayList possibleActions = new ArrayList();

  private Wall(int ID, String description)
  {
    this.ID = ID;
    this.description = description;
  }

  private void setDoor(boolean door, boolean locked)
  {
    this.door = door;
    if(door)
    {
      description += " There is a door.";
      if(locked)
      {
        description += " It is locked.";
      }
      else
      {
        description += " It is not locked.";
      }
    }
  }

  private void addActions(ArrayList actions)
  {
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

  private void checkActions()
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

  private void addItems(ArrayList items[])
  {
    
  }
}
