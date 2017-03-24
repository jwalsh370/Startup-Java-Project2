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



}
