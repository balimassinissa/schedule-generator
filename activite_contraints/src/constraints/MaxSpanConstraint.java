package constraints;
import java.util.*;
public class MaxSpanConstraint implements Constraint {
    HashSet<Activity> activities ;
    int maxDuration ;
    public MaxSpanConstraint(Set<Activity> activities ,int maxDuration)
    {
      this.activities = new HashSet<Activity>(activities);
      this.maxDuration = maxDuration ;
    }
    public Set<Activity> getActivities()
    {
      return this.activities ;
    }
    public boolean isSatisfied(Map<Activity,Integer> dates)
    {
      if (this.activities.isEmpty()) {
        return true ;
      }
      else
      {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (Activity a : this.activities){
          if ((dates.get(a) + a.getDuration()) > maxValue) {
            maxValue = dates.get(a) + a.getDuration() ;
          }
          if (dates.get(a) < minValue) {
            minValue = dates.get(a);
          }
        }
        return (maxValue - minValue) <= this.maxDuration ;
    }
    }
}
