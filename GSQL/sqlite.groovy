import groovy.sql.Sql
import groovy.io.FileType

new File('../sample.db').delete()
def sqlite = Sql.newInstance("jdbc:sqlite:../sample.db", "org.sqlite.JDBC")
sqlite.execute """
create table file_info (
  pkey integer primary key,
  filename text,
  filesize integer
)"""

def idx = 1
new File("../").eachFileRecurse(FileType.FILES) { File f ->
  sqlite.execute """
    insert into file_info (pkey, filename, filesize)
    values (${idx++}, ${f.name}, ${f.size()})
"""
}

sqlite.rows("select * from file_info").each { row ->
  println "${row.pkey} : ${row.filename} : ${row.filesize}"
} 
