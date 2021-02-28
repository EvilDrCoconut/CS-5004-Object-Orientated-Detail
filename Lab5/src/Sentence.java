/** The interface for sentence structures.
 */
public interface Sentence {

  /** Method to add a new WordNode.
   * @param string string to be put in the WordNode as its data.
   */
  void addWordNode(String string);

  /** Method to add a new PunctuationNode.
   * @param string string to be put into the PunctuationNode as its data.
   */
  void addPunctuationNode(String string);

  /** Method for finding the number of words in a sentence structure.
   * @return itself and the next node's content in a sentence structure.
   */
  int numberOfWords();

  /** Method for finding the longest word.
   * @return the longest word in a sentence structure.
   */
  String longestWord();

  /** Method to turn all nodes in a sentence structure into a single string.
   * @return a string of all nodes' content put together.
   */
  String toString();

  /** Method to clone all nodes in a sentence structure
   *     and return a new sentence structure with said nodes.
   * @return
   */
  SentenceImpl clone();

  /** Method to merge together two sentence structure.
   * @param merge other sentence structure to be merged.
   * @return a new sentence structure with both sentences.
   */
  SentenceImpl merge(SentenceImpl merge);

  /** Method to count total number of PunctuationNodes.
   * @return the number of PunctuationNodes in a list.
   */
  int countTotalPunctuation();

  /** Method to count the number of WordNodes with a z in their data.
   * @return number of WordNodes with z in their data.
   */
  int countTotalWord();

  /** Method to convert a list's node's data into piglatin and given as a sentence.
   * @return string of converted list's data.
   */
  String convertToPigLatin();
}
