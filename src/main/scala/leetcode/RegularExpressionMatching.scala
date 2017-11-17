package leetcode

/**
  * @author Dauren Mussa
  * @since 11/12/17
  */
object RegularExpressionMatching {

  def main(args: Array[String]): Unit = {
    println(isMatch("ad", "ab*c*d"))
  }

  def isMatch(text: String, regex: String): Boolean = {
    if (regex.length == 0 && text.length > 0) {
      return false;
    } else if (regex.length == 1 && text.length == 1 && (text.charAt(0).equals(regex.charAt(0)) || regex.charAt(0) == '.')) {
      return true;
    } else if (regex.length > 1 && text.length > 0) {
      val symbol = regex.charAt(0)
      val specSymbol = regex.charAt(1)
      if (specSymbol == '*') {
        var index = 0
        while (index < text.length && (text.charAt(index) == symbol || symbol == '.')) {
          index += 1
        }
        if (index == text.length && regex.substring(2).length == 0) {
          return true
        }
        while (index > -1 && !isMatch(text.substring(index), regex.substring(2))) {
          index -= 1
        }
        if (index == -1) {
          return isMatch(text.substring(index + 1), regex.substring(2))
        } else {
          return isMatch(text.substring(index), regex.substring(2))
        }
      } else {
        return ((symbol == text.charAt(0) || symbol == '.')) && isMatch(text.tail, regex.tail)
      }
    } else if (text.length == 0 && regex.length > 1) {
      val symbol = regex.charAt(0)
      val specSymbol = regex.charAt(1)
      if (specSymbol == '*') {
        return isMatch(text, regex.substring(2))
      } else {
        return false
      }
    } else if (text.length == 0 && regex.length == 0) {
      return true
    } else {
      return false
    }
  }

}
