import groovy.xml.MarkupBuilder

def csv = """1,aaaa,100
2,bbbb,200
3,cccc,500
"""

def xml = new MarkupBuilder(new PrintWriter(System.out))
xml.someData {
  csv.splitEachLine(",") { line ->
    entry {
      id(line[0])
      title(line[1])
      value(line[2])
    }
  }
}




