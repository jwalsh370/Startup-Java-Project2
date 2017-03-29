import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MemberTest {

  @Before
   public void tearDown() {
     Member.clear();
   }

  s@Test
  public void MemberClass_Instantiates_True() {
    Member myMember = new Member("Moe", "Java", "beginner");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
   public void Member_instantiatesWithName_String() {
     Member myMember = new Member("Moe", "Java", "beginner");
     assertEquals("Moe", myMember.getName());
   }


   @Test
   public void all_returnsAllInstancesOfMember_true() {
     Member firstMember = new Member("Moe", "Java", "beginner");
     Member secondMember = new Member("Jonny", "Ruby", "Advanced");
     assertEquals(true, Member.all().contains(firstMember));
     assertEquals(true, Member.all().contains(secondMember));
   }

   @Test
   public void clear_emptiesAllMembersFromArrayList_0() {
     Member myMember = new Member("Moe", "Java", "beginner");
     Member.clear();
     assertEquals(Member.all().size(), 0);
   }

   @Test
   public void getId_tasksInstantiateWithAnID_1() {
     Member myMember = new Member("Moe", "Java", "beginner");
     assertEquals(1, myMember.getId());
   }

   @Test
   public void find_returnsMemberWithSameId_secondMember() {
     Member firstMember = new Member("Moe", "Java", "beginner");
     Member secondMember = new Member("Jonny", "Ruby", "Advanced");
     assertEquals(Member.find(secondMember.getId()), secondMember);
   }




}
