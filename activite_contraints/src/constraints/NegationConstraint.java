package constraints;
import java.util.*;
public  class NegationConstraint implements Constraint {
  private Constraint negation ;
  public NegationConstraint(Constraint c)
  {
    this.negation = c ;
  }
  public Set<Activity> getActivities()
  {
    return this.negation.getActivities();
  }
  public boolean isSatisfied(Map<Activity,Integer> activities)
  {
    return !this.negation.isSatisfied(activities);
  }
}
