package constraints;
import java.util.* ;
public interface Constraint {
  public Set<Activity> getActivities() ;
  public boolean isSatisfied(Map<Activity,Integer> activities) ;
}
