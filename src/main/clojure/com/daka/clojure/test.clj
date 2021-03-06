(defn print-something
  [arguments]
  (println (str "super data! " arguments)))

(defn factorial
  [number]
  (if (= number 1)
    number
    (* number (factorial (- number 1)))))

(defn fibo-recursive
  [n]
  (if (or (= n 0) (= n 1))
    n
    (+ (fibo-recursive (- n 1)) (fibo-recursive (- n 2)))))

(defn fibo-recur [iteration]
  (let [fibo (fn [one two n]
               (if (= iteration n)
                 one
                 (recur two (+ one two) (inc n))))]
    ;; 0N 1N are bigint literals. See Bigint section
    ;; We need to use bigint to avoid StackOverflow to do the addition of big Fibonacci numbers
    ;; demonstrated below.
    (fibo 0N 1N 0)))

(print-something (factorial 5))
(print-something (fibo-recur 40))

(defn memoize [f]
  (let [mem (atom {})]
    (fn [& args]
      (if-let [e (find @mem args)]
        (val e)
        (let [ret (apply f args)]
          (swap! mem assoc args ret)
          ret)))))

(defn fib [n]
  (if (<= n 1)
    n
    (+ (fib (dec n)) (fib (- n 2)))))

(time (fib 35))

(def fib (memoize fib))

(time (fib 35))