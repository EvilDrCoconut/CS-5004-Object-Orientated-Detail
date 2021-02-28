import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/** The SentenceImpl class that has methods for the linked lists.
 */
public class SentenceImpl implements Sentence {

  private List<SentenceNodesADT> myList;

  /** Constructor to set up a new linked list of SentenceNodesADT.
   */
  public SentenceImpl() {
    myList = new LinkedList<SentenceNodesADT>();
  }

  /** Method to add a new WordNode.
   * @param string string to be put in the WordNode as its data.
   */
  @Override
  public void addWordNode(String string) {
    myList.add(new WordNode(string));
  }

  /** Method to add a new PunctuationNode.
   * @param string string to be put into the PunctuationNode as its data.
   */
  @Override
  public void addPunctuationNode(String string) {
    myList.add(new PunctuationNode(string));
  }

  /** Method for finding the number of words in a sentence structure.
   * @return itself and the next node's content in a sentence structure.
   */
  @Override
  public int numberOfWords() {
    return (int) myList.stream().filter(se -> se.isWord()).count();
  }

  /** Method for finding the longest word.
   * @return the longest word in a sentence structure.
   */
  @Override
  public String longestWord() {
    return myList.stream().filter(se -> se.isWord()).map(n -> n.getContent()).
            reduce("", (s1, s2) -> s1.length() > s2.length() ? s1 : s2);
  }

  /** Method to turn all nodes in a sentence structure into a single string.
   * @return a string of all nodes' content put together.
   */
  @Override
  public String toString() {
    List<String> m = myList.stream().map(n -> n.getContent()).collect(Collectors.toList());
    return String.join(" ", m);
  }

  /** Method to clone all nodes in a sentence structure
   *     and return a new sentence structure with said nodes.
   * @return a new SentenceImpl of the current SentenceImpl.
   */
  @Override
  public SentenceImpl clone() {
    SentenceImpl clone = new SentenceImpl();
    for (int i = 0; i < myList.size(); i++) {
      if (myList.get(i).isWord()) {
        clone.addWordNode(myList.get(i).getContent());
      } else {
        clone.addPunctuationNode(myList.get(i).getContent());
      }
    }
    return clone;
  }

  /** Method to merge together two SentenceImpl structure.
   * @param merge other sentence structure to be merged.
   * @return a new sentence structure with both sentences.
   */
  @Override
  public SentenceImpl merge(SentenceImpl merge) {

    for (int i = 0; i < (merge.countTotalPunctuation() + merge.numberOfWords()); i++) {
      if (merge.myList.get(i).isWord()) {
        this.addWordNode(merge.myList.get(i).getContent());
      } else {
        this.addPunctuationNode(merge.myList.get(i).getContent());
      }
    }
    return this;
  }

  /** Method to count totL number of PunctuationNodes.
   * @return the number of PunctuationNodes in a list.
   */
  @Override
  public int countTotalPunctuation() {
    return myList.stream().filter(se -> !se.isWord()).collect(Collectors.toList()).size();

  }

  /** Method to count the number of WordNodes with a z in their data.
   * @return number of WordNodes with z in their data.
   */
  @Override
  public int countTotalWord() {
    return (int) myList.stream().filter(se -> se.getContent().contains("z")
            || se.getContent().contains("Z")).count();
  }

  /** Helper method to make sure strings are returned.
   * @return a sentence that is actually in string format.
   */
  public String sentenceToString() {
    StringBuffer str = new StringBuffer();
    for (SentenceNodesADT node : this.myList) {
      if (node.isWord()) {
        str.append(" " + node.getContent());
      } else {
        str.append(node.getContent());
      }
    }
    String sent = str.substring(1);
    return sent;
  }

  /** Method to convert a list's node's data into pig latin and given as a sentence.
   * @return string of converted list's data.
   */
  @Override
  public String convertToPigLatin() {
    SentenceImpl pigLatin = new SentenceImpl();
    myList.stream().collect(Collectors.toList());
    for (int i = 0; i < myList.size(); i++) {
      if (myList.get(i).checkVowel() && myList.get(i).isWord()) {
        pigLatin.addWordNode(myList.get(i).getContent() + "WAY");
      } else if (!myList.get(i).checkVowel() && myList.get(i).isWord()) {
        String word = myList.get(i).getContent().substring(1)
                + myList.get(i).getContent().substring(0, 1) + "AY";
        pigLatin.addWordNode(word);
      } else {
        pigLatin.addPunctuationNode(myList.get(i).getContent());
      }
    }
    return pigLatin.sentenceToString();
  }
}
