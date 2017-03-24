import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  @Test
  public void TeamClass_InstantiatesTrue() {
    Team myTeam = new Team("Falcon");
    assertEquals(true, myTeam instanceof Team);
  }

}
