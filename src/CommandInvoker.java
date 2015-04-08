import java.util.List;
import java.util.ArrayList;

/** The Invoker class */
public class CommandInvoker {
   private List<Command> history = new ArrayList<Command>();
 
   public void storeAndExecute(Command cmd) {
      if (cmd==null) return;
      this.history.add(cmd); // optional 
      cmd.execute();
   }
}
