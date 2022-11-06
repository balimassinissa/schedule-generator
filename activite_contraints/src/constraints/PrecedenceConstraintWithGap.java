  package constraints;
  public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
    int minimalD ;
    int maximalD;
    public PrecedenceConstraintWithGap(Activity firstActivity,Activity secondActivity,int minimalD,int maximalD)
    {
      super(firstActivity,secondActivity);
      this.minimalD = minimalD;
      this.maximalD = maximalD;
    }
    public boolean isSatisfied(int date1 ,int date2)
    {
      if (((date1 + firstActivity.getDuration()+maximalD) < date2) |((date1 + firstActivity.getDuration()+minimalD) > date2) )
        return false ;
      else
        return true ;
    }
  }
