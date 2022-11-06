package constraints ;
public  class PrecedenceConstraint extends BinaryConstraint{

  public PrecedenceConstraint(Activity firstActivity ,Activity secondActivity)
  {
    super(firstActivity,secondActivity);
    
  }
  public boolean isSatisfied(int date1 ,int date2)
  {
    if ((date1 + this.firstActivity.getDuration()) > date2)
      return false ;
    else
      return true ;
  }
}
