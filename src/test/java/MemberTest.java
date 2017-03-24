import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {



  @Test
  public void MemberClass_Instantiates_True() {
    Member myMember = new Member("True That", "Java", "beginner");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void MemberClass_Test_Getters() {
    Member myMember = new Member("Saul", "Java", "beginner");
    assertEquals("Saul", myMember.getName());
    assertEquals("Java", myMember.getLanguage());
    assertEquals("beginner", myMember.getSkill());
  }

  @Test
  public void returns_allInstancesOfMember_true() {
    Member firstMember = new Member("Word", "Java", "novice");
    Member secondMember = new Member("Sword", "Ruby", "Master");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }



}
