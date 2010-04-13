import groovy.sql.Sql

new File('./sample.db').delete()
def sqlite = Sql.newInstance("jdbc:sqlite:sample.db", "org.sqlite.JDBC")
sqlite.execute """
create table table_info (
  pkey integer primary key,
  name text,
  comments text
)"""
