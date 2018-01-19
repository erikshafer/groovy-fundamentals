// Available in certain Collections. Can accept a closure as an argument.
// $it (g-string syntax). Refers to the iterator.
// $i -> allows us to override the $it

// (1..3).each({ i ->
//     println "In a closure: $i"
// })


// findAll() can accept a closure as an argument as a predicate, and the
// predicate returns a boolean value. Depending on the result, it determines
// to yield it onto the .each().
(1..10).findAll({ it%2==0 }).each({
    println "In a closure: $it"
})