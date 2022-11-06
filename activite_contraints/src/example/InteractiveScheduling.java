// Cette classe est une classe de demo qui fait une petite simulation du travaille
package example;
import java.util.*;
import constraints.*;
import solvers.*;
public class InteractiveScheduling
{
  public static void main(String[] args) {
    String choiceDescription;
    int duration;
    int date;
    Activity a ;
    Activity a2 ;
    Map<Activity,Integer> map = new HashMap<Activity,Integer>();
    Set<Constraint> constraints = new HashSet<Constraint>();
    Set<Activity> activitiesA = new HashSet<Activity>();
    int exit = 0;
    int choice ;
    while(exit != 1)
    {
      Scanner console = new Scanner(System.in);
      System.out.println("Taper le libel de l'activité :");
      String description = console.nextLine();
      System.out.println("Taper la durée de l'activité :");
      try{//en cas ou l'utilisateur saisie une valeur non entier
          duration = console.nextInt();
        }
      catch (InputMismatchException e) {
        System.out.println("Durée incorrecte : la durée devrait etre un entier positif, Retapez :");//meme si l'utilisateur n'a pas saisie une valeur entierre on lui donne une deuxiemme chance pour re-saisir la valeur qui convient
        Scanner console1 = new Scanner(System.in);
        duration = console1.nextInt();
      }
      System.out.println("Taper l'heure de l'activité souhaitée :");
      try{//en cas ou l'utilisateur saisie une valeur non entier
         Scanner console3 = new Scanner(System.in);
          date = console3.nextInt();
        }
      catch (InputMismatchException e) {
        System.out.println("Date incorrecte : la date devrait etre un entier positif, Retapez :");//meme si l'utilisateur n'a pas saisie une valeur entierre on lui donne une deuxiemme chance pour re-saisir la valeur qui convient
        Scanner console4 = new Scanner(System.in);
        date = console4.nextInt();
      }
      Activity aa= new Activity(description,duration);//creation d'une activité a pour description et durée ce aui a saisie l'utulisateur
      activitiesA.add(aa);//ajout de l'activité cree dans une liste
      map.put(aa,date);// ajout de l'activité et de la date dans une map
      System.out.println("Si vous avez terminé la saisie des activités et vous voulez passer à la saisie des contraintes tapez 1 sinon tapez 0:");
      try{
          exit= console.nextInt();
        }
      catch (InputMismatchException e) {
        System.out.println("Choix incorrecte : le choix devrait etre 1 ou 0, Retapez :");//meme si l'utilisateur n'a pas saisie une valeur entierre on lui donne une deuxiemme chance pour re-saisir la valeur qui convient
        Scanner console5 = new Scanner(System.in);
        exit = console5.nextInt();
      }
    }
    exit = 0 ;
    while(exit !=1)
    {
      System.out.println("Catalogue des contraintes:");
      System.out.println("1----->Pour une contrainte de precedence tapez 1 ,ensuite le libel de la premièrre activité puis le libel de la deuxiemme activité.");
      System.out.println("2----->Pour une contrainte de precedence avec délais tapez 2, ensuite le libel de la premièrre activité, le libel de la deuxiemme activité, le délai minimum et enfin le délai maximum.");
      System.out.println("3----->Pour une contrainte d'arité quelconque tapez 3 ,puis les libels des activités enfin le délai souhaité.");
      System.out.println("0----->Pour arreter la saisie des contraintes tapez 0");
      System.out.println("Veulliez choisir le numero de la contrainte puis lordre des activités comme mentionné sur le catalogue:");
      Scanner console = new Scanner(System.in);
      choice =  console.nextInt();
      switch(choice)
      {
        case 1:
          System.out.println("tapez le libel de la premièrre activité :");
          choiceDescription = console.nextLine();
          a = null ;
          while(a == null)
          {//recherche si l'activitéexiste dans ka liste des activités saisie precedement
            for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
              Activity key = entry.getKey();
              if(key.getDescription().compareTo(choiceDescription) == 0)
              {
                a = key ; ;
              }
            }
            if(a == null)
            {
              System.out.println("activité non existente retapez le libel:");
              choiceDescription = console.nextLine();
            }
          }
          System.out.println("tapez le libel de la deuxiemme activité :");
          choiceDescription = console.nextLine();
          a2 = null ;
          while(a2 == null)
          {//recherche si l'activitéexiste dans ka liste des activités saisie precedement
            for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
              Activity key = entry.getKey();
              if(key.getDescription().compareTo(choiceDescription) == 0)
              {
                a2 =key ;
              }
            }
            if(a2 == null)
            {
              System.out.println("activité non existente retapez le libel:");
              choiceDescription = console.nextLine();
            }
          }
          constraints.add(new PrecedenceConstraint(a,a2));
          break ;
          case 2:
            System.out.println("tapez le libel de la premièrre activité :");
            choiceDescription = console.nextLine();
            a = null ;
            while(a == null)
            {//recherche si l'activitéexiste dans ka liste des activités saisie precedement
              for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
                Activity key = entry.getKey();
                if(key.getDescription().compareTo(choiceDescription) == 0)
                {
                  a = key ; ;
                }
              }
              if(a == null)
              {
                System.out.println("activité non existente retapez le libel:");
                choiceDescription = console.nextLine();
              }
            }
            System.out.println("tapez le libel de la deuxiemme activité :");
            choiceDescription = console.nextLine();
            a2 = null ;
            while(a2 == null)
            {//recherche si l'activitéexiste dans ka liste des activités saisie precedement
              for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
                Activity key = entry.getKey();
                if(key.getDescription().compareTo(choiceDescription) == 0)
                {
                  a2 =key ;
                }
              }
              if(a2 == null)
              {
                System.out.println("activité non existente retapez le libel:");
                choiceDescription = console.nextLine();
              }
            }
            int minD = -1;
            while(minD< 0)
            {
              System.out.println("tapez le délai minimal entre les deux activités: ");
              try{
                  minD = console.nextInt();
                }
              catch (InputMismatchException e) {
                System.out.println("Délai incorrecte : le délai devrait etre un entier positif, Retapez :");
                Scanner console1 = new Scanner(System.in);
                minD = console1.nextInt();
              }
              if(minD<0 )
              {
                System.out.println("Délai invalide Veulliez retapez le délai : Délai doit etre positif.");
              }
            }
            int maxD = -1 ;
            while(maxD < 0 || maxD < minD )
            {
              System.out.println("tapez le délai maximal entre les deux activités: ");
              try{
                  maxD = console.nextInt();
                }
              catch (InputMismatchException e) {
                System.out.println("Délai incorrecte : le délai devrait etre un entier positif, Retapez :");
                Scanner console1 = new Scanner(System.in);
                maxD = console1.nextInt();
              }
              if(maxD < minD)
              {
                if(maxD<0)
                {
                  System.out.println("Délai invalide Veulliez retapez le délai : Délai doit etre positif et supérieur au délai minimal.");
                }
                else
                {
                  System.out.println("Délai invalide Veulliez retapez le délai : Délai maximal doit etre supérieur au délai minimal.");
                }
              }
            }
            constraints.add(new PrecedenceConstraintWithGap(a,a2,minD,maxD));
            break ;
            case 3:
              HashSet<Activity> activities = new HashSet<Activity>();
              int finish = 0 ;
              int  i = 1 ;
              while(finish == 0)
              {//saisiede la liste des activités contenant dans la contrainte
                a = null ;
                System.out.println("tapez le libel de l'activité numéro"+i+":");
                choiceDescription = console.nextLine();
                while(a == null)
                {//recherche si l'activitéexiste dans ka liste des activités saisie precedement
                  for (Map.Entry<Activity, Integer> entry : map.entrySet()) {
                    Activity key = entry.getKey();
                    if(key.getDescription().compareTo(choiceDescription) == 0)
                    {
                      a = key ;
                    }
                  }
                  if(a == null)
                  {
                    System.out.println("activité non existente retapez le libel:");
                    choiceDescription = console.nextLine();
                  }
                }
                activities.add(a);
                System.out.println("activité ajoutée avec succès !");
                System.out.println("Si vous avez fini la saisie des activités tapez 1 sinon 0 :");
                try{
                    finish = console.nextInt();
                  }
                catch (InputMismatchException e) {
                  System.out.println("Choix incorrecte : le Choix devrait 1 ou 0, Retapez :");
                  Scanner console1 = new Scanner(System.in);
                  finish = console1.nextInt();
                }
                i += 1 ;
              }
              int maxDuration = -1;
              while(maxDuration< 0)
              {
                System.out.println("tapez la durée maximale des activités: ");
                try{
                    maxDuration = console.nextInt();
                  }
                catch (InputMismatchException e) {
                  System.out.println("Délai incorrecte : le délai devrait etre un entier positif, Retapez :");
                  Scanner console1 = new Scanner(System.in);
                  maxDuration = console1.nextInt();
                }
                if(maxDuration<0 )
                {
                  System.out.println("Délai invalide Veulliez retapez le délai : Délai doit etre positif.");
                }
              }
              constraints.add(new MaxSpanConstraint(activities,maxDuration));
              break ;
      }
      System.out.println("Si vous avez terminé la saisie des contraintes et vous voulez passer à la vérification des contraintes tapez 1 sinon tapez 0 :");
      try{
          exit = console.nextInt();
        }
      catch (InputMismatchException e) {
        System.out.println("Choix incorrecte : le Choix devrait 1 ou 0, Retapez :");
        Scanner console1 = new Scanner(System.in);
        exit = console1.nextInt();
      }
    }
    Verifier v = new Verifier(constraints);
    System.out.println("La liste des contraintes non satisfaites :");
    if(v.unsatisfied(map).isEmpty())
    {
      System.out.println("Toutes les contraintes sont satisfaites.");
    }
    else
    {
      System.out.println("La liste des contraintes non satisfaites :");
      for(Constraint c : v.unsatisfied(map))
      {
        System.out.println("-->La contrainte qui contient :");
        for(Activity acti : c.getActivities())
        {
          System.out.println("----->"+acti.getDescription());
        }
      }
    }
    System.out.println("Si vous voulez avoir une proposition d'un emploi du temps qui satisfait le maximum de contraintes tapez 1 sinon 0:");
    Scanner console1 = new Scanner(System.in);
    exit = console1.nextInt();
    if(exit == 1)
    {
      RandomScheduler r = new RandomScheduler(new Random());
      int minValue = Integer.MAX_VALUE;
      int maxValue = Integer.MIN_VALUE;
      for (Activity at : activitiesA){
        if ((map.get(at) + at.getDuration()) > maxValue) {
          maxValue = map.get(at) + at.getDuration() ;
        }
        if (map.get(at) < minValue) {
          minValue = map.get(at);
        }
      }
      for (Map.Entry<Activity, Integer> entry : r.generateSchedule(activitiesA,constraints,minValue,maxValue,5).entrySet()) {
        Activity key = entry.getKey();
        System.out.println("L'activité "+key.getDescription()+" durera à :"+entry.getValue());
      }
    }


  }
}
