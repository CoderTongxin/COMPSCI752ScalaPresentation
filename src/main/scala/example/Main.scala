
object Main extends App {

  val point1 = new Point(2, 3)
  point1.x
  println(point1)

  //Primary constructor parameters with val and var
  class Point (var x: Int, var y: Int) {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }

    override def toString: String =
      s"($x, $y)"
  }


  //Parameters without val or var are private values, visible only within the class.
  class helloMyFriend(x: Int, y: Int)

  //  Closures

  def encodeWithSeed(num: Int, seed: Int): Long = {
    def encode(x: Int, func: (Int) => Int): Long = {
      val y = x + 1000
      func(y)
    }
    val result = encode(num, (n: Int) => (n * seed))
    result
  }

  //case
  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

}