import java.util.ArrayList;
import java.util.List;

public class Team {
  private String mName;
  private static ArrayList<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mMembers;


  public Team(String teamName) {
    mName = teamName;
    instances.add(this);
    mId = instances.size();
    mMembers = new ArrayList<Member>();
  }

  public String getName() {
    return mName;
  }

  public static ArrayList<Team> all() {
  return instances;
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

  public List<Member> getMembers() {
   return mMembers;
 }

 public void addMember(Member member) {
   mMembers.add(member);
 }

 // public static List<Team> getAllTeams() {
 //   return instances;
 // }

}
