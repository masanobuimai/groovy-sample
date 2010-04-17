"ls -l ..".execute()

println "ls -l ..".execute().text


list = []
"ls -l ..".execute().text.splitEachLine(/ +/) { split ->
  if (split.size() == 9) {
    result = [:]
    result.owner = split[2]
    result.filename = split[8]
    list << result
  }
}

list.each {
  println "${it.filename} - ${it.owner}"
}

