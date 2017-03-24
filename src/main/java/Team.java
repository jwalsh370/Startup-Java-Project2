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

  public String getTeamName() {
    return mTeamName;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Team find(int id) {
    return instances.get(id - 1);
  }

  public static List<Member> getMember() {
   return mMember;
 }

 public static void addMember(Member member) {
   mMember.add(member);
 }

 public static List<Team> getAllTeams() {
   return instances;
 }

}
