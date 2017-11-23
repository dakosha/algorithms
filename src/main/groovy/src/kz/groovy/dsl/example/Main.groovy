package src.kz.groovy.dsl.example

class Main {

    def static split(string) {
        [on: { sep ->
            [trimming: { trimChar ->
                Splitter.on(sep).trimResults(CharMatcher.is(trimChar as char)).split(string).iterator().toList()
            }]
        }]
    }

    def static show = { println it }
    def static  square_root = { Math.sqrt(it) }

    def static please(action) {
        [the: { what ->
            [of: { n -> action(what(n)) }]
        }]
    }

    static void main(String[] args) {
        // equivalent to: please(show).the(square_root).of(100)
        please show the square_root of 100
        def result = split "_a ,_b_ ,c__" on ',' trimming '_\\'
        println result
        // ==> 10.0
    }

}
