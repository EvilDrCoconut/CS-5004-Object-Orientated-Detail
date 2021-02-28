/** The SentenceNodesADT abstract class.
 */
public abstract class SentenceNodesADT {

  private String data;

  /** Constructor for node types extended from SentenceNodesADT.
   * @param string string that is the data for the node.
   */
  public SentenceNodesADT(String string) {
    this.data = string;
  }

  /** Method to return content.
   * @return string that is the data held.
   */
  public String getContent() {
    return data;
  }

  /** Method to see if this is a WordNode.
   * @return boolean if the node is a WordNode.
   */
  public boolean isWord() {
    return !(this instanceof WordNode);
  }

  /** Helper method to check if a word starts with a vowel.
   * @return boolean if word starts with a vowel.
   */
  public boolean checkVowel() {

    return this.data.startsWith("A") || this.data.startsWith("a") || this.data.startsWith("E")
            || this.data.startsWith("e") || this.data.startsWith("I")
            || this.data.startsWith("i") || this.data.startsWith("O")
            || this.data.startsWith("o") || this.data.startsWith("U")
            || this.data.startsWith("u");
  }
}
