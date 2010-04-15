import groovy.io.FileType

new File("../").eachFileRecurse(FileType.FILES) { file ->
  if (file.name.endsWith(".groovy")) println file
}


