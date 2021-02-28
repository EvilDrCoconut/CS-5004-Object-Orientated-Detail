/** The interface for sentence structures.
 */
public interface Sentence {

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
  Sentence clone();

  /** Method to merge together two sentence structure.
   * @param merge other sentence structure to be merged.
   * @return a new sentence structure with both sentences.
   */
  Sentence merge(Sentence merge);


}
