package constraints;
import java.util.*;
public class Demo {
public static void main(String[] args) {
  ///creation des activités

  Activity a1 = new Activity("cour poo",1);
  Activity a2 = new Activity("tp poo",2);
  Activity a3 = new Activity("cour algo",2);
  Activity a4 = new Activity("td algo",1);
  Activity a5 = new Activity("tp algo",2);
  Activity a6 = new Activity("cour reseaux",1);
  Activity a7 = new Activity("td reseaux",1);
  HashSet<Activity> hset = new HashSet<Activity>();
  hset.add(a2);
  hset.add(a3);

  //création des contraintes
  PrecedenceConstraint constraint1 = new PrecedenceConstraint(a1,a2);
  PrecedenceConstraint constraint2 = new PrecedenceConstraint(a3,a4);
  MeetConstraint constraint3 = new MeetConstraint(a4,a5);
  PrecedenceConstraintWithGap constraint4 = new PrecedenceConstraintWithGap(a6,a7,1,2);
  MaxSpanConstraint constraint5 = new MaxSpanConstraint(hset,7);

  //négations des contraintes
  NegationConstraint constraint6 = new NegationConstraint(constraint1);
  NegationConstraint constraint7 = new NegationConstraint(constraint2);
  NegationConstraint constraint8 = new NegationConstraint(constraint3);
  NegationConstraint constraint9 = new NegationConstraint(constraint4);
  NegationConstraint constraint10 = new NegationConstraint(constraint5);

  //disjonctions des constraintstests
  DisjunctionConstraint constraint11 = new DisjunctionConstraint(constraint1,constraint2);

  // création d'un enmploi du temps
  Map<Activity,Integer> map = new HashMap<Activity,Integer>();
  map.put(a1,7);
  map.put(a2,10);
  map.put(a3,14);
  map.put(a4,15);
  map.put(a5,16);
  map.put(a6,15);
  map.put(a7,18);

  // tests des claces
  boolean ok = true ;                                                                                                                                                                                                                                                                                                                               
  ok = ok && constraint1.isSatisfied(map) && !constraint6.isSatisfied(map) ;
  ok = ok && !constraint2.isSatisfied(map) && constraint7.isSatisfied(map) ;
  ok = ok && constraint3.isSatisfied(map) && !constraint8.isSatisfied(map) ;
  ok = ok && constraint4.isSatisfied(map) && !constraint9.isSatisfied(map) ;
  ok = ok && constraint5.isSatisfied(map) && !constraint10.isSatisfied(map) ;
  ok = ok && constraint11.isSatisfied(map) && (constraint1.isSatisfied(map) || constraint2.isSatisfied(map));
  System.out.println(ok ? "All tests passed" : " At least one test failed");
}
}
