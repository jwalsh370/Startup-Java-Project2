import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @After
 public void tearDown() {
   Team.clear();
 }

 @Test
 public void team_instantiatesCorrectly_true() {
   Team testTeam = new Team("Falcon");
   assertEquals(true, testTeam instanceof Team);
 }

 @Test
 public void getName_teamInstantiatesWithName_Falcon() {
   Team testTeam = new Team("Falcon");
   assertEquals("Falcon", testTeam.getName());
 }

 @Test
 public void all_returnsAllInstancesOfTeam_true() {
   Team firstTeam = new Team("Falcon");
   Team secondTeam = new Team("Quasar");
   assertEquals(true, Team.all().contains(firstTeam));
   assertEquals(true, Team.all().contains(secondTeam));
 }

 @Test
public void clear_emptiesAllCategoriesFromList_0() {
  Team testTeam = new Team("Falcon");
  Team.clear();
  assertEquals(Team.all().size(), 0);
}

@Test
public void getId_categoriesInstantiateWithAnId_1() {
  Team testTeam = new Team("Falcon");
  assertEquals(1, testTeam.getId());
}

@Test
public void find_returnsTeamWithSameId_secondTeam() {
  Team.clear();
  Team firstTeam = new Team("Falcon");
  Team secondTeam = new Team("Quasar");
  assertEquals(Team.find(secondTeam.getId()), secondTeam);
}

 @Test
 public void getMembers_initiallyReturnsEmptyList_ArrayList() {
   Team.clear();
   Team testTeam = new Team("Falcon");
   assertEquals(0, testTeam.getMembers().size());
 }

 @Test
 public void addMember_addsMemberToList_true() {
   Team testTeam = new Team("Falcon");
   Member testMember = new Member("Jonny", "Ruby", "Advanced");
   testTeam.addMember(testMember);
   assertTrue(testTeam.getMembers().contains(testMember));
  }
}
