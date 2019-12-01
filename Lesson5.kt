import java.util.*

class Books(val title: String, val author: String, val year: Int, var pages: Int) {
    fun getTitleAndAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getAll(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun collectionPractice() {
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("ShakeSpeare" to allBooks)
    println(library.any { it.value.contains("Hamlet") })
    println("Library: $library")

    val moreBooks = mutableMapOf<String, String>("wilhelm Tell" to "Schiller")
    moreBooks.getOrPut("Jungle book") { "Kipling" }
    moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println(moreBooks)
}

const val maxBooks = 2

fun main() {
    extensionFunctionCode()

    //collectionPractice()

    //*******************
    /*val book1 = Books("title 1", "author 1", 1998)
    val book2 = Books("title 2", "author 2", 1978)

    val bookTitleAuthor = book1.getTitleAndAuthor()
    println ("First book with title: ${bookTitleAuthor.first} and author is: ${bookTitleAuthor.second} ")

    val bookdata = book2.getAll()
    println("Second book with title: ${bookdata.first}, written by ${bookdata.second} in ${bookdata.third}")*/
}


// Extension functions:
fun String.hasSpaces() = find { it == ' ' } != null

fun Books.weight() = pages*1.5

fun Books.torePages(tore: Int) = if (pages >= tore) pages -= tore else pages = 0

class Puppy() {
    fun playWithBook(book: Books) {
        book.torePages(Random().nextInt(12))
    }
}

fun extensionFunctionCode() {
    val puppy = Puppy()
    val book = Books("Oliver Twist", "Charles Dickens", 1837, 540)

    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}. ")
}

