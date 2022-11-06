package constraints;
import java.util.*;
public abstract class BinaryConstraint implements Constraint{
  protected Activity firstActivity;
  protected Activity secondActivity;
  public BinaryConstraint(Activity firstActivity,Activity secondActivity)
  {
    this.firstActivity = firstActivity;
    this.secondActivity = secondActivity;
  }
  public abstract boolean isSatisfied(int date1 ,int date2);
  public Activity getFirst()
  {
    return firstActivity ;
  }
  public Activity getSecond()
  {
    return secondActivity ;
  }
  public Set<Activity> getActivities()
  {
    Set<Activity> activities = new HashSet<Activity>();
    activities.add(this.firstActivity);
    activities.add(this.secondActivity);
    return activities;
  }
  public boolean isSatisfied(Map<Activity,Integer> dates)
  {
    int date1 = dates.get(this.firstActivity);
    int date2 = dates.get(this.secondActivity);
    return isSatisfied(date1,date2) ;
  }
}
