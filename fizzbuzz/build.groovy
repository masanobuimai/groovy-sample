def ant = new AntBuilder()
(1..100).each {
   ant.echo(it % 3 ? (it % 5 ? "FizzBuzz" : "Fizz")
               : it % 5 ? "Buzz" : it)
}
