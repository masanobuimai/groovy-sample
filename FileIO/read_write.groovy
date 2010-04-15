new File("sample.txt").withPrintWriter { pw ->
  (1..20).each {
    pw.println "${it} : ------------"
  }
}

new File("sample.txt").eachLine {
  println it
}
