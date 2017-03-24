import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @After
 public void tearDown() {
   Team.clear();
 }

  @Test
  public void TeamClass_InstantiatesTrue() {
    Team myTeam = new Team("Falcon");
    assertEquals(true, myTeam instanceof Team);
  }

  @Test
  public void test_TeamGetters() {
    Team myTeam = new Team("Falcon");
    assertEquals("Falcon", myTeam.getTeamName());
    assertEquals(1, myTeam.getId());
  }

  @Test
  public void newTeam_addsMembertoTeam_true() {
    Team myTeam = new Team("Falcon");
  Member myMember = new Member("Saul", "Java", "beginner");
  myTeam.addMember(myMember);
  assertTrue(myTeam.getMember().contains(myMember));
  }

  @Test
  public void myTeam_addsTwoMembersToCollectionandSizeisTwo_True(){
    Team myTeam = new Team("Falcon");
    Member firstMember = new Member("Word", "Java", "novice");
    Member secondMember = new Member("Sword", "Ruby", "Master");
    myTeam.addMember(firstMember);
    myTeam.addMember(secondMember);
    assertEquals(2, myTeam.getMember().size());
  }

  @Test
  public void myTeam_addsTwoMembersToCollection_true() {
    Team myTeam = new Team("Falcon");
    Team myTeam2 = new Team("Phoenix");
    Member firstMember = new Member("Word", "Java", "novice");
    Member secondMember = new Member("Sword", "Ruby", "Master");
    myTeam.addMember(firstMember);
    myTeam2.addMember(secondMember);
    assertTrue(myTeam.getMember().contains(firstMember));
    assertTrue(myTeam2.getMember().contains(secondMember));

  }
}
