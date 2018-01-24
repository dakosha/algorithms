package scalaz


/**
  * @author Dauren Mussa
  * @since 12/10/17
  */
object MainTest {

  def main(args: Array[String]): Unit = {

    // A type class to provide textual representation
    trait Show[A] {
      def show(f: A): String
    }

    // A polymorphic function that works only when there is an implicit
    // instance of Show[A] available
    def log[A](a: A)(implicit s: Show[A]) = println(s.show(a))


    implicit val stringShow = new Show[String] {
      override def show(s: String) = s
    }

    implicit val intShow = new Show[Int] {
      override def show(f: Int): String = (5 + f).toString
    }


    log("a string")
    log(5)


  }

}
