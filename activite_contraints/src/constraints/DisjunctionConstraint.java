package constraints;
import java.util.*;
public  class DisjunctionConstraint implements Constraint {
  private Constraint constraint1 ;
  private Constraint constraint2 ;
  public DisjunctionConstraint(Constraint c1 ,Constraint c2)
  {
    this.constraint1 = c1 ;
    this.constraint2 = c2 ;
  }
  public Set<Activity> getActivities()
  {
    Set<Activity> activities = this.constraint1.getActivities();
    activities.addAll(this.constraint2.getActivities()) ;
    return activities;
  }
  public boolean isSatisfied(Map<Activity,Integer> activities)
  {
    return this.constraint1.isSatisfied(activities) || this.constraint2.isSatisfied(activities);
  }
}
