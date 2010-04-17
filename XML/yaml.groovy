import org.jvyaml.YAML

def yaml = """
- title: なんとかのテストをする
  node:
  - title: ほげほげ
    node:
    - title: なんとかがなんとかでなんとかする
      cond: これこれ，こうゆう条件だ。
      expect: こうなってくれ。
    - title: あれがこれでこうなる
      cond: こうゆう条件だ。
      expect: こうなるに違いない

  - title: Foo Bar Boo
    node:
    - title: なんとかがなんとかでなんとかする
      cond: これこれ，こうゆう条件だ。
      expect: こうなってくれ。

- title: これもテストしないと
"""

YAML.load(yaml).eachWithIndex {
  it, index ->
  println "$index : $it.title"
  it.node.eachWithIndex { n1, idx1 ->
    println "$index-$idx1 : $n1.title"
    n1.node.eachWithIndex { n2, idx2 ->
      println "$index-$idx1-$idx2 : $n2.title"
      println "$n2.cond"
      println "$n2.expect"
      println "----"
    }
  }
}