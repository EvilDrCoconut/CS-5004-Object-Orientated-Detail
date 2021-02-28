/** Class for Punctuation node.
 */
public class PunctuationNode extends SentenceNodesADT {

  /** Constructor for punctuation node.
   * @param punctuation string of punctuation chosen to insert into the function.
   */
  public PunctuationNode(String punctuation) {
    super(punctuation);
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
