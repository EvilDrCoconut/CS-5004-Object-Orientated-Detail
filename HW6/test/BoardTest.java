import org.junit.Before;
import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit tests for MarbleSolitaireModelImpl class.
 */
public class BoardTest {

  private MarbleSolitaireModel board1;
  private MarbleSolitaireModel board2;
  private MarbleSolitaireModel board3;
  private MarbleSolitaireModel board4;

  /**
   * Set up for a couple of boards to test.
   */
  @Before
  public void setUp() {
    board1 = new MarbleSolitaireModelImpl();
    board2 = new MarbleSolitaireModelImpl(3, 6);
    board3 = new MarbleSolitaireModelImpl(5);
    board4 = new MarbleSolitaireModelImpl(5, 6, 4);
  }


  /**
   * Test to show all boards initialize without issue.
   */
  @Test
  public void testFirst() {
    MarbleSolitaireModel board = new MarbleSolitaireModelImpl();
    MarbleSolitaireModel board2 = new MarbleSolitaireModelImpl(4, 5);
    MarbleSolitaireModel board3 = new MarbleSolitaireModelImpl(5);
    MarbleSolitaireModel board4 = new MarbleSolitaireModelImpl(5, 4, 5);

    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O O O O O\n"
            + "O O O O O _ O\n"
            + "    O O O\n"
            + "    O O O", board2.getGameState());

  }

  /**
   * Test to show that improper starting point is rejected.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSecond() {
    MarbleSolitaireModel board = new MarbleSolitaireModelImpl(1, 1);
  }

  /**
   * Test to show even arm thickness is rejected.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testThird() {
    MarbleSolitaireModel board = new MarbleSolitaireModelImpl(4);
  }

  /**
   * Test to show negative arm thickness is rejected.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testFourth() {
    MarbleSolitaireModel board = new MarbleSolitaireModelImpl(-1);
  }

  /**
   * Test to show we can retrieve game state.
   */
  @Test
  public void testFifth() {
    String newBoard = board1.getGameState();
    System.out.print(newBoard);
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", board1.getGameState());
    System.out.print("\n \n");
    String newBoard2 = board2.getGameState();
    System.out.print(newBoard2);
    System.out.print("\n \n");
    String newBoard3 = board3.getGameState();
    System.out.print(newBoard3);
    System.out.print("\n \n");
    String newBoard4 = board4.getGameState();
    System.out.print(newBoard4);
  }

  /**
   * Quick test to show each board can have moves on it.
   */
  @Test
  public void testSixth() {
    MarbleSolitaireModel newBoard1 = board1;
    MarbleSolitaireModel newBoard2 = board2;
    MarbleSolitaireModel newBoard3 = board3;
    MarbleSolitaireModel newBoard4 = board4;

    newBoard1.move(3, 1, 3, 3);
    newBoard2.move(3, 4, 3, 6);
    newBoard3.move(6, 4, 6, 6);
    newBoard4.move(4, 4, 6, 4);

    assertEquals(31, newBoard1.getScore(), 0);
    assertEquals(31, newBoard2.getScore(), 0);
    assertEquals(103, newBoard3.getScore(), 0);
    assertEquals(103, newBoard4.getScore(), 0);
  }

  /**
   * Quick test to show that isGameOver works as intended.
   */
  @Test
  public void testSeventh() {
    assertFalse(board1.isGameOver());
    assertFalse(board2.isGameOver());
    assertFalse(board3.isGameOver());
    assertFalse(board4.isGameOver());
  }

  /**
   * Quick test to show accurate score counts.
   */
  @Test
  public void testEighth() {
    assertEquals(32, board1.getScore(), 0.00);
    assertEquals(32, board2.getScore(), 0.00);
    assertEquals(104, board3.getScore(), 0.00);
    assertEquals(104, board4.getScore(), 0.00);
  }

  /**
   * Test of a standard, winning game with 1 peg left.
   */
  @Test
  public void testNinth() {
    System.out.println(board1.getGameState() + "\n");
    board1.move(1, 3, 3, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(2, 1, 2, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(0, 2, 2, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(0, 4, 0, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(2, 3, 2, 1); ///
    System.out.println(board1.getGameState() + "\n");

    board1.move(2, 0, 2, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(2, 4, 0, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(2, 6, 2, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 2, 1, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(0, 2, 2, 2); ///
    System.out.println(board1.getGameState() + "\n");

    board1.move(3, 0, 3, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 2, 1, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 4, 1, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(0, 4, 2, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 6, 3, 4); ///
    System.out.println(board1.getGameState() + "\n");

    board1.move(3, 4, 1, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(5, 2, 3, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 0, 4, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 2, 2, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(1, 2, 3, 2); ///
    System.out.println(board1.getGameState() + "\n");

    board1.move(3, 2, 3, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 4, 2, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(1, 4, 3, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 6, 4, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 3, 4, 5); ///
    System.out.println(board1.getGameState() + "\n");

    board1.move(6, 4, 4, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 4, 5, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(6, 2, 6, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(6, 4, 4, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 5, 4, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(5, 3, 3, 3); ///
    System.out.println(board1.getGameState() + "\n");

    assertTrue(board1.isGameOver());
    assertEquals(1, board1.getScore(), 0.00);
    board1 = new MarbleSolitaireModelImpl();
  }

  /**
   * Test of standard game with the worst possible losing score. This is according to
   * http://www.durangobill.com/Peg33.html.
   */
  @Test
  public void testTenth() {
    System.out.println(board1.getGameState() + "\n");
    board1.move(1, 3, 3, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(4, 3, 2, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 1, 3, 3);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 4, 3, 2);
    System.out.println(board1.getGameState() + "\n");
    board1.move(3, 6, 3, 4);
    System.out.println(board1.getGameState() + "\n");
    board1.move(6, 3, 4, 3);
    System.out.println(board1.getGameState() + "\n");

    assertTrue(board1.isGameOver());
    assertEquals(26, board1.getScore(), 0.00);
    board1 = new MarbleSolitaireModelImpl();
  }

  /**
   * Test of board where player picks starting position, and game is not completed.
   */
  @Test
  public void testEleventh() {
    System.out.println(board2.getGameState() + "\n");
    board2.move(3, 4, 3, 6);
    System.out.println(board2.getGameState() + "\n");
    board2.move(1, 4, 3, 4);
    System.out.println(board2.getGameState() + "\n");
    board2.move(2, 6, 2, 4);
    System.out.println(board2.getGameState() + "\n");
    board2.move(4, 6, 2, 6);
    System.out.println(board2.getGameState() + "\n");
    board2.move(2, 3, 2, 5);
    System.out.println(board2.getGameState() + "\n");
    board2.move(4, 3, 2, 3);
    System.out.println(board2.getGameState() + "\n");
    board2.move(4, 5, 4, 3);
    System.out.println(board2.getGameState() + "\n");
    board2.move(5, 3, 3, 3);
    System.out.println(board2.getGameState() + "\n");
    board2.move(2, 3, 4, 3);
    System.out.println(board2.getGameState() + "\n");
    board2.move(2, 1, 2, 3);
    System.out.println(board2.getGameState() + "\n");
    board2.move(4, 1, 2, 1);

    assertFalse(board2.isGameOver());
    assertEquals(21, board2.getScore());
    board2 = new MarbleSolitaireModelImpl(3, 6);
  }

  /**
   * Quick test to ensure players stay with the board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTwelfth() {
    board1.move(2, 2, -1, -2);
  }
}