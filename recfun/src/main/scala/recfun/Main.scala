package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c >= r) {
        1
      } else {
        pascal(c - 1, r - 1) + pascal(c, r - 1)
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def _balance(chars: List[Char], expectedPars: List[Char]): Boolean = {
        val parentheses: String = "()"

        def isPair(a: Char, b: Char): Boolean = {
          a == '(' && b == ')'
        }

        if (chars.isEmpty) {
          expectedPars.isEmpty
        } else {
          if (expectedPars.isEmpty) {
            _balance(chars.tail, if (parentheses.contains(chars.head)) List(chars.head) else expectedPars)
          } else {
            if (parentheses.contains(chars.head)) {
              if (isPair(expectedPars.last, chars.head)) {
                _balance(chars.tail, expectedPars.tail)
              } else {
                _balance(chars.tail, List(chars.head) ++ expectedPars)
              }
            } else {
              _balance(chars.tail, expectedPars)
            }
          }
        }
      }

      _balance(chars, List[Char]())
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def _countChange(money: Int, coins: List[Int]): Int = {
        if (money == 0) {
          1
        } else if (money < 0 || coins.isEmpty){
          0
        } else {
          _countChange(money, coins.tail) + _countChange(money - coins.head, coins)
        }
      }

      _countChange(money, coins)
    }
  }
