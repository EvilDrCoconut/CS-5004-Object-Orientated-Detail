/** Class for Word node.
 */
public class WordNode extends SentenceNodesADT {

  /** Constructor for word node.
   * @param word string of the word chosen to insert into the function.
   */
  public WordNode(String word) {
    super(word);
  }

  /** Method to return content.
   * @return string that is the data held.
   */
  public String getContent() {
    return super.getContent();
  }

  /** Method to see if this is a WordNode.
   * @return boolean if the node is a WordNode.
   */
  public boolean isWord() {
    return super.isWord();
  }
}