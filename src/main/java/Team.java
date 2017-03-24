import java.util.ArrayList;
import java.util.List;

public class Team {
  private String mTeamName;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private static List<Member> mMember;


  public Team(String teamName) {
    mTeamName = teamName;
    instances.add(this);
    mId = instances.size();
    mMember = new ArrayList<Member>();
  }


}
