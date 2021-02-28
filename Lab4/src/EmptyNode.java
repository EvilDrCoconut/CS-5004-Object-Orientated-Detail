/** Class for Empty node.
 */
public class EmptyNode implements Sentence {

  /** Constructor for word node, no parameters as this is base case and ends recursion.
   */
  public EmptyNode() {
    String space = " ";
    Sentence next = null;
  }


  /** Method to count number of words.
   * @return itself to end method.
   */
  @Override
  public int numberOfWords() {
    return 0;
  }

  /** Method for finding and returning the longest word.
   * @return itself and ends the method.
   */
  @Override
  public String longestWord() {
    return "";
  }

  /** Method to convert the whole sentence to a string.
   * @return itself and ends the toString method.
   */
  @Override
  public String toString() {
    return "";
  }

  /** Method to clone a sentence's node into a new sentence structure.
   * @return itself and end's the cloning process.
   */
  @Override
  public Sentence clone() {
    return new EmptyNode();
  }

  /** Method to merge two sentence structures together.
   * @param merge other sentence structure to be merged with.
   * @return A new sentence structure with both added sentence structures.
   */
  @Override
  public Sentence merge(Sentence merge) {
    Sentence newSentence = merge;
    return newSentence;
  }
}
