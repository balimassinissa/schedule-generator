package solvers;
import java.util.*;
import constraints.Constraint;
import constraints.Activity;
import constraints.BinaryConstraint;
public class RandomScheduler {
  Random random ;
  public RandomScheduler(Random r )
  {
    random = r ;
  }
  public Map<Activity, Integer> generateOneSchedule(Set<Activity> activities , int minDate , int maxDate)
  {
    Map<Activity, Integer> result = new HashMap<Activity, Integer>();
    for (Activity a : activities )
    {
      result.put(a,minDate + this.random.nextInt(maxDate-minDate+1)) ;
    }
    return result;
  }
  public Map<Activity , Integer> generateSchedule(Set<Activity> activities ,Set<Constraint> constraints ,int minDate ,int maxDate , int numberOfsheduler)
  {
    int minUnsatisfaction = Integer.MAX_VALUE ;
    Verifier v = new Verifier(constraints);
    Map<Activity , Integer> result = new HashMap<Activity , Integer>();
    Map<Activity, Integer> tmp = new HashMap<Activity , Integer>();
    for(int i = 0;i < numberOfsheduler ; i ++)
    {
      tmp = this.generateOneSchedule(activities ,minDate , maxDate);
      if(v.unsatisfied(tmp).size() < minUnsatisfaction)
      {
        minUnsatisfaction = v.unsatisfied(tmp).size();
        result = tmp ;
      }
    }
    return result ;
  }
}
