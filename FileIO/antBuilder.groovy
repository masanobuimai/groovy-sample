ant = new AntBuilder()
new File('antBuilder.bak').delete()


ant.copy(file:'antBuilder.groovy', tofile:'antBuilder.bak')


ant.copy(todir:'../backup') {
  fileset(dir:'../FileIO')
  if (false) fileset(dir:'../fizzbuzz')
}

ant.zip(destfile:'../backup.zip') {
  fileset(dir:'../backup')
}