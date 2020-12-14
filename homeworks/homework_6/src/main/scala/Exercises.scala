object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = for (i <- seq.length until 0 by -1) yield seq(i-1)

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = (math.pow((math.sqrt(5) + 1) / 2, idx) / math.sqrt(5) + 0.5).toInt
  //вывод https://en.wikipedia.org/wiki/Fibonacci_number#Closed-form_expression

  def fibonacci(idx: Int): Seq[Int] = for (i <- 0 to idx) yield fibonacci4Index(i)

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  /* Если неизмененные символы - все же тоже коды, то:
  def morse(text: String): String = text
      .toUpperCase()
      .split("")
      .map(c => MORSE.getOrElse(c, c))
      .mkString(" ")
  */

  def morse(text: String): String = text
    .toUpperCase()
    .split("")
    .map(c =>
      if(MORSE.contains(c)) " " + MORSE(c)
      else if(c == " ") "  "
      else c)
    .mkString("")
    .substring(1)

  def wordReverse(text: String): String = text
    .split("(?=[^a-zA-Zа-яёА-ЯЁ])|(?<=[ ])")
    .map(word =>
      if (word.head.isUpper) {
        word.toLowerCase.reverse.capitalize
      } else word.reverse)
    .mkString("")
}
