import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {



  @Test
  public void MemberClass_Instantiates_True() {
    Member myMember = new Member("True That");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void MemberClass_Test_Getters() {
    Member myMember = new Member("Saul");
    assertEquals("Saul", myMember.getName());
  }

}
