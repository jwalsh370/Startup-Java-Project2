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
}
