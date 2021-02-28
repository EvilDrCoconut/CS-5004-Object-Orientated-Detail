import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** The JUnit test for Chesspiece and all subclasses.
 */
public class ChessPieceTest {

  private Knight knight;
  private Queen queen;
  private Pawn pawn1;
  private Pawn pawn2;
  private Bishop bishop;
  private Rook rook;

  @Before
  public void setUp() {
    knight = new Knight(0, 2, Color.WHITE);
    queen = new Queen(7, 3, Color.BLACK);
    pawn1 = new Pawn(1, 2, Color.WHITE);
    pawn2 = new Pawn(6, 0, Color.BLACK);
    bishop = new Bishop(0, 6, Color.WHITE);
    rook = new Rook(7, 7, Color.BLACK);

  }

  @Test
  public void testFirst() {
    Pawn pawn = new Pawn(7, 3, Color.BLACK);
    Queen queen = new Queen(1, 4, Color.WHITE);
    Rook rook = new Rook(7, 7, Color.BLACK);
    Bishop bishop = new Bishop(1, 7, Color.WHITE);
    Knight knight = new Knight(6, 2, Color.BLACK);
    assertEquals(7, pawn.getRow());
    assertEquals(3, pawn.getColumn());
    assertEquals(1, queen.getRow());
    assertEquals(4, queen.getColumn());
    assertEquals(7, rook.getRow());
    assertEquals(7, rook.getColumn());
    assertEquals(1, bishop.getRow());
    assertEquals(7, bishop.getColumn());
    assertEquals(6, knight.getRow());
    assertEquals(2, knight.getColumn());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSecond() {
    Pawn pawn = new Pawn(0, -1, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testThird() {
    Pawn pawn = new Pawn(-1, -1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFourth() {
    Knight knight = new Knight(-1, -1, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFifth() {
    Rook rook = new Rook(-1, -1, Color.BLACK);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSixth() {
    Bishop bishop = new Bishop(-1, -1, Color.WHITE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSeventh() {
    Queen queen = new Queen(-1, -1, Color.WHITE);
  }

  @Test
  public void testEighth() {
    assertEquals(0, knight.getRow());
    assertEquals(7, queen.getRow());
    assertEquals(1, pawn1.getRow());
    assertEquals(6, pawn2.getRow());
    assertEquals(0, bishop.getRow());
    assertEquals(7, rook.getRow());
  }

  @Test
  public void testNinth() {
    assertEquals(2, knight.getColumn());
    assertEquals(3, queen.getColumn());
    assertEquals(2, pawn1.getColumn());
    assertEquals(0, pawn2.getColumn());
    assertEquals(6, bishop.getColumn());
    assertEquals(7, rook.getColumn());
  }

  @Test
  public void testTenth() {
    assertEquals(false, pawn1.canMove(3, 4));
    assertEquals(true, pawn2.canMove(5, 0));
    assertEquals(false, pawn2.canMove(5, 1));
    assertEquals(true, rook.canMove(7, 0));
    assertEquals(true, rook.canMove(0, 7));
    assertEquals(false, rook.canMove(3, 6));
    assertEquals(false, rook.canMove(1, 3));
    assertEquals(true, knight.canMove(2, 3));
    assertEquals(true, knight.canMove(1, 4));
    assertEquals(false, knight.canMove(7, 7));
    assertEquals(false, knight.canMove(4, 2));
    assertEquals(true, queen.canMove(3, 3));
    assertEquals(true, queen.canMove(7, 7));
    assertEquals(true, queen.canMove(4, 0));
    assertEquals(false, queen.canMove(7, 3));
    assertEquals(false, queen.canMove(0, 0));

    assertEquals(true, bishop.canMove(6, 0));
    assertEquals(true, bishop.canMove(3, 3));
  }

  @Test
  public void testEleventh() {
    assertEquals(false, bishop.canMove(0, 6));
    assertEquals(false, queen.canMove(7, 3));
    assertEquals(false, knight.canMove(0, 2));
    assertEquals(false, rook.canMove(7, 7));
    assertEquals(false, pawn1.canMove(1, 2));
  }

  @Test
  public void testTwelve() {
    Rook rook2 = new Rook(0, 7, Color.WHITE);
    Rook rook3 = new Rook(7, 0, Color.BLACK);
    Queen queen2 = new Queen(0, 4, Color.WHITE);
    Pawn pawn3 = new Pawn(2,1, Color.BLACK);
    Bishop bishop2 = new Bishop(6, 0, Color.WHITE);
    Knight knight2 = new Knight(2, 1, Color.BLACK);
    assertEquals(false, queen2.canKill(knight));
    assertEquals(true, knight.canKill(pawn3));
    assertEquals(false, pawn2.canKill(pawn1));
    assertEquals(false, pawn2.canKill(pawn2));
    assertEquals(true, bishop.canKill(pawn2));
    assertEquals(true, rook.canKill(rook2));
    assertEquals(true, queen2.canKill(rook));
    assertEquals(true, rook3.canKill(bishop2));
    assertEquals(true, pawn1.canKill(knight2));

  }
}
