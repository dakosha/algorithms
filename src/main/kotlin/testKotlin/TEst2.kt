package testKotlin


/**
 * @author Dauren Mussa
 * @since 6/9/18
 */

fun main(args: Array<String>) {
    val name = "dauren mussa is the common antagonist"
    println(name.getLength())
    println(name.toCamelCase())

    val lazyProp: String by lazy {
        name.toCamelCase()
    }

    println(name)

    println(lazyProp)

    println(Daka)

    val array = arrayOf(1, 2, 3, 4, 5)
    for ((index, value) in array.withIndex()) {
        println(index)
        println(value)
    }

    val derived = Derived("daka", "mussa")

}

fun String.toCamelCase(): String {

    var result = StringBuilder()
    for (index in this.indices) {
        if (this[index] != ' ') {
            if (index in 1..this.length - 1 && this[index - 1] == ' ') {
                result.append(this[index].toUpperCase())
            } else {
                result.append(this[index])
            }
        }
    }

    return result.toString()
}

fun String.getLength(): Int {
    return this.length
}

object Daka {
    val name = "Dauren"
    val lastName = "Mussa"

    override fun toString(): String {
        return "[" + name + " " + lastName + "]"
    }
}

open class Base(val name: String) {

    init {
        println("Initializing Base")
    }

    open val size: Int =
            name.length.also { println("Initializing size in Base: $it") }
}

class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init {
        println("Initializing Derived")
    }

    override val size: Int =
            (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}