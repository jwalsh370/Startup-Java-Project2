import java.util.ArrayList;
import java.util.List;

public class Member {

  private String mName;
  private String mLanguage;
  private String mSkill;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String name, String language, String skill) {

    mName = name;
    mLanguage = language;
    mSkill = skill;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public String getLanguage() {
    return mLanguage;
  }

  public String getSkill() {
    return mSkill;
  }

  public static List<Member> all() {
   return instances;
 }

 public static void clear() {
    instances.clear();
  }

 public int getId() {
   return mId;
 }

 public static Member find(int id) {
  return instances.get(id - 1);
 }

}
