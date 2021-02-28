import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** JUnit test for Sentence classes.
 */
public class SentenceTest {

  private SentenceImpl sentence1;
  private SentenceImpl sentence2;

  @Before
  public void setUp() {
    sentence1 = new SentenceImpl();
    sentence1.addWordNode("My");
    sentence1.addWordNode("cat");
    sentence1.addWordNode("ate");
    sentence1.addWordNode("a");
    sentence1.addWordNode("bug");
    sentence1.addPunctuationNode("!");

    sentence2 = new SentenceImpl();
    sentence2.addWordNode("My");
    sentence2.addWordNode("favorite");
    sentence2.addWordNode("cats");
    sentence2.addWordNode("are");
    sentence2.addWordNode("Hi-5");
    sentence2.addPunctuationNode(",");
    sentence2.addWordNode("Mia");
    sentence2.addPunctuationNode(",");
    sentence2.addWordNode("and");
    sentence2.addWordNode("Peeps");
    sentence2.addPunctuationNode(".");
  }

  @Test
  public void testFirst() {
    SentenceImpl tester = new SentenceImpl();
    tester.addWordNode("The");
    tester.addWordNode("monster");
    tester.addWordNode("under");
    tester.addPunctuationNode("%");
    tester.addWordNode("the");
    tester.addPunctuationNode("&");
    tester.addWordNode("carrot");
    tester.addPunctuationNode("#");
    tester.addWordNode("trees");
    tester.addPunctuationNode("?");

    assertEquals("The monster under % the & carrot # trees ?", tester.toString());
  }


  @Test
  public void testSecond() {

    assertEquals(5, sentence1.numberOfWords(), 0);
    assertEquals(8, sentence2.numberOfWords(), 0);
  }

  @Test
  public void testThree() {

    assertEquals("bug", sentence1.longestWord());
    assertEquals("favorite", sentence2.longestWord());
  }

  @Test
  public void testFourth() {

    assertEquals("My cat ate a bug !", sentence1.toString());
    assertEquals("My favorite cats are Hi-5 , Mia , and Peeps .", sentence2.toString());
  }

  @Test
  public void testFifth() {
    SentenceImpl clone = sentence1.clone();
    SentenceImpl clone2 = sentence2.clone();

    assertEquals("My cat ate a bug !", clone.toString());
    assertEquals("My favorite cats are Hi-5 , Mia , and Peeps .", clone2.toString());
  }

  @Test
  public void testSixth() {
    sentence1 = sentence1.merge(sentence2);
    SentenceImpl sent = new SentenceImpl();
    sent.addWordNode("No");
    sent.addWordNode("thank");
    sent.addWordNode("you");
    sent.addPunctuationNode(".");

    sentence2.merge(sent);

    assertEquals("My cat ate a bug ! My favorite cats are Hi-5 , Mia , and Peeps .",
            sentence1.toString());
    assertEquals("My favorite cats are Hi-5 , Mia , and Peeps . No thank you .",
            sentence2.toString());
  }

  @Test
  public void testSeventh() {
    SentenceImpl test = new SentenceImpl();
    test.addWordNode("Hi");

    assertEquals(1, sentence1.countTotalPunctuation(), 0);
    assertEquals(3, sentence2.countTotalPunctuation(), 0);
    assertEquals(0, test.countTotalPunctuation(), 0);
  }

  @Test
  public void testEighth() {
    SentenceImpl test = new SentenceImpl();
    test.addWordNode("Zebra");
    test.addWordNode("tasty");
    test.addWordNode("zesty");
    test.addWordNode("pizza");

    assertEquals(0, sentence1.countTotalWord(), 0);
    assertEquals(0, sentence2.countTotalWord(), 0);
    assertEquals(3, test.countTotalWord(), 0);
  }


  @Test
  public void testNinth() {
    //System.out.println(sentence1.toString());
    assertEquals("yMAY atcAY ateWAY aWAY ugbAY!", sentence1.convertToPigLatin());
  }


}

