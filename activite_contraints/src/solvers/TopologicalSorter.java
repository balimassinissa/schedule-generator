package solvers ;
import constraints.Activity;
import constraints.PrecedenceConstraint;
import java.util.*;
public class TopologicalSorter{
  public TopologicalSorter()
  {

  }
  public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities ,HashSet<PrecedenceConstraint> contraints)
  {
    ArrayList<Activity> res = new ArrayList<Activity>();
    HashSet<Activity> Oc = new HashSet<Activity>(activities);
    boolean continuer ;
    boolean ok ;
    while (!Oc.isEmpty())
    {
      continuer = false ;
      for (Activity o : Oc) {
        ok = true ;
        for (PrecedenceConstraint c : contraints) {
          if ((c.getSecond().equals(o)) && (!(res.contains(c.getFirst())))) {
            ok = false ;
          }
        }
        if (ok) {
          res.add(o);
          Oc.remove(o);
          continuer = true;
          break ;
        }
      }
      if (!continuer) {
        return null ;
      }
    }
    return res ;
  }
  public ArrayList<Activity> linearTimeSort(HashSet<Activity> activities ,HashSet<PrecedenceConstraint> contraints)
  {
    ArrayList<Activity> res = new ArrayList<Activity>();
    HashSet<Activity> Oc = new HashSet<Activity>(activities);
    boolean continuer ;
    boolean ok ;
    while (!Oc.isEmpty())
    {
      continuer = false ;
      for (Activity o : Oc) {
        ok = true ;
        for (PrecedenceConstraint c : contraints) {
          if ((c.getSecond().equals(o)) && (!(res.contains(c.getFirst())))) {
            ok = false ;
          }
        }
        if (ok) {
          res.add(o);
          Oc.remove(o);
          continuer = true;
          break ;
        }
      }
      if (!continuer) {
        return null ;
      }
    }
    return res ;
  }

}
