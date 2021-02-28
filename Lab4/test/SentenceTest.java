import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** JUnit test for Sentence classes.
 */
public class SentenceTest {

  private WordNode sentence1;
  private WordNode sentence2;

  @Before
  public void setUp() {

    sentence1 = new WordNode("My",
            new WordNode("name",
                    new WordNode("is",
                            new WordNode("Lucas",
                                    new PunctuationNode("!",
                                            new EmptyNode())))));

    sentence2 = new WordNode("My", new WordNode("favorite",
                    new WordNode("foods", new WordNode("are",
                            new WordNode("sandwiches", new PunctuationNode(",",
                                    new WordNode("chicken", new PunctuationNode(",",
                                            new WordNode("and", new WordNode("tacos",
                                                    new PunctuationNode("?",
                                                            new EmptyNode())))))))))));
  }

  @Test
  public void testFirst() {
    assertEquals(4, sentence1.numberOfWords());
    assertEquals(8, sentence2.numberOfWords());
  }

  @Test
  public void testSecond() {
    assertEquals("Lucas", sentence1.longestWord());
    assertEquals("sandwiches", sentence2.longestWord());
  }

  @Test
  public void testThird() {
    assertEquals("My name is Lucas!", sentence1.toString());
    assertEquals("My favorite foods are sandwiches, chicken, and tacos?", sentence2.toString());

  }

  @Test
  public void testFourth() {
    Sentence newSentence = sentence1.clone();
    Sentence newSentence2 = sentence2.clone();
    assertEquals(sentence1.toString(), newSentence.toString());
    assertEquals(sentence2.toString(), newSentence2.toString());
  }

  @Test
  public void testFifth() {
    Sentence newSentence = sentence1.merge(sentence2);
    assertEquals("My name is Lucas! My favorite foods are sandwiches, chicken, and tacos?",
            newSentence.toString());
  }

}
