package constraints;
public class MeetConstraint extends PrecedenceConstraint  {
  public MeetConstraint(Activity firstActivity,Activity secondActivity)
  {
    super(firstActivity,secondActivity);
  }
  public boolean isSatisfied(int date1 ,int date2)
  {
    if ((date1 + this.firstActivity.getDuration()) == date2)
      return true ;
    else
      return false;
  }

}
