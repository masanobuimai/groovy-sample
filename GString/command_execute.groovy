"ls -l ..".execute()

println "ls -l ..".execute().text


list = []
"ls -l ..".execute().text.eachLine { line, no ->
  if (no > 1) {
    result = [:]
    s = line.split()
    result.owner = s[2]
    result.filename = s[8]
    list << result
  }
}

list.each {
  println "${it.filename} - ${it.owner}"
}

