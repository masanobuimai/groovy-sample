def cli = new CliBuilder(usage:"cli [-hvx] filename ...")
cli.with {
  h(longOpt:'help', 'show help')
  v(longOpt:'verbose', 'be more verbose')
  x(longOpt:'xml', 'xml file', args: 1)
}

def opt = cli.parse(args)
cli.usage()

if (opt.h) {
  cli.usage()
}

if (opt.v) {

}

if (opt.x) {
  println opt.x
}


