package solvers;
import java.util.*;
import constraints.Constraint;
import constraints.Activity;
import constraints.BinaryConstraint;
public  class Verifier {
  Set<Constraint> constraints ;
  public Verifier(Set<Constraint> constraints)
  {
    this.constraints = new HashSet<Constraint>(constraints);
  }
  public Set<Constraint> unsatisfied(Map<Activity, Integer> dates)
  {
    Set<Constraint> result = new HashSet<Constraint>();
    for( Constraint c : this.constraints )
    {
      if(!c.isSatisfied(dates))
      {
        result.add(c);
      }
    }
    return result ;
  }
}
