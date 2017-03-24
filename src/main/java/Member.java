public class Member {

  private String mName;
  private String mLanguage;
  private String mSkill;

  public Member(String name, String language, String skill) {

    mName = name;
    mLanguage = language;
    mSkill = skill;
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

}
