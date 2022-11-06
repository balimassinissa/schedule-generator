package constraints ;
public  class Activity{
  private String description ;
  private int duration;
  public  Activity(String description , int duration)
  {
    this.description = description ;
    this.duration = duration ;
  }

  public  String getDescription()
  {
    return description ;
  }
  public int getDuration()
  {
    return duration ;
  }

}
