import java.util.ArrayList;
import java.util.List;

public class Member {

  private String mName;
  private String mLanguage;
  private String mSkill;
  private static List<Member> instances = new ArrayList<Member>();

  public Member(String name, String language, String skill) {

    mName = name;
    mLanguage = language;
    mSkill = skill;
    instances.add(this);
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

}
