/** Class for Punctuation node.
 */
public class PunctuationNode implements Sentence {

  private String word;
  private Sentence next;

  /** Constructor for punctuation node.
   * @param punctuation string of punctuation chosen to insert into the function.
   * @param next        a pointer to the next node in the sentence.
   */
  public PunctuationNode(String punctuation, Sentence next) {
    this.word = punctuation;
    this.next = next;
  }

  /** Method to count number of words.
   * @return itself with no addition to count for itself.
   */
  @Override
  public int numberOfWords() {
    return this.next.numberOfWords();
  }

  /** Method for finding and returning the longest word.
   * @return itself, being ignored as it isn't a word.
   */
  @Override
  public String longestWord() {
    return next.longestWord();
  }

  /** Method to convert the whole sentence to a string.
   * @return itself plus the next node's content.
   */
  @Override
  public String toString() {
    if (next instanceof PunctuationNode) {
      return word + next.toString();
    } else if (next instanceof WordNode) {
      return word + " " + next.toString();
    } else {
      return word + next.toString();
    }
  }

  /** Method to clone a sentence's node into a new sentence structure.
   * @return itself and the next node's content as a new copy.
   */
  @Override
  public Sentence clone() {
    return new PunctuationNode(this.word, this.next.clone());
  }

  /** Method to merge two sentence structures together.
   * @param merge other sentence structure to be merged with.
   * @return A new sentence structure with both added sentence structures.
   */
  @Override
  public Sentence merge(Sentence merge) {
    Sentence newSentence = new PunctuationNode(this.word, this.next.merge(merge));
    return newSentence;
  }
}
