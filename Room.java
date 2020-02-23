import java.util.*;

public class Room
{
 int ID;
 String description;
 ArrayList connections = new ArrayList();
 ArrayList items = new ArrayList();
 ArrayList npcs = new ArrayList();
 ArrayList availableActions = new ArrayList();
 ArrayList possibleActions = new ArrayList();

 Room(int ID, String description, ArrayList connections)
 {
   this.ID = ID;
   this.description = description;
   this.connections = connections;
 }

 void addActions(ArrayList actions)
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

 void checkActions()
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

 void addItems(ArrayList items)
 {
   this.items = items;
   ArrayList actions = item.getAllActions();
   addActions(actions);
 }

 //TODO add NPC based methods
}
