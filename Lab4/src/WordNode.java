/** Class for Word node.
 */
public class WordNode implements Sentence {
  private String word;
  private Sentence next;

  /** Constructor for word node.
   * @param word string of the word chosen to insert into the function.
   * @param next a pointer to the next node in the sentence.
   */
  public WordNode(String word, Sentence next) {
    this.word = word;
    this.next = next;
  }

  /** Method to count number of words.
   * @return itself + 1 to count for each word.
   */
  @Override
  public int numberOfWords() {
    return next.numberOfWords() + 1;
  }

  /** Method for finding and returning the longest word.
   * @return what the longest word is.
   */
  @Override
  public String longestWord() {
    if (this.word.length() < this.next.longestWord().length()) {
      return this.next.longestWord();
    }
    return this.word;
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
    return new WordNode(this.word, this.next.clone());
  }

  /** Method to merge two sentence structures together.
   * @param merge other sentence structure to be merged with.
   * @return A new sentence structure with both added sentence structures.
   */
  @Override
  public Sentence merge(Sentence merge) {
    Sentence newSentence = new WordNode(this.word, this.next.merge(merge));
    return newSentence;
  }
}
