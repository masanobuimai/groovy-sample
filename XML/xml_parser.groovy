xml = """
<person id="100">
  <firstname>Jane</firstname>
  <lastname>Doe</lastname>
  <address type="home">
    <street>123 Main St</street>
    <city>Denver</city>
    <state>CO</state>
    <zip>80020</zip>
  </address>
</person>
"""

person = new XmlSlurper().parseText(xml)
println person.firstname
println person.address.city
println person.@id
