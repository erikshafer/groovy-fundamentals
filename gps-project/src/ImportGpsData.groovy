def file = new File('../data/fells_loop.gpx')
println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

// There is no method called name or desc, but due to the dynamic
// nature of Groovy, at run-time it will try to resolve them. It
// finds the properties and prints them accordingly.
println gpx.name
println ''
println gpx.desc
println gpx.foo // There is no 'foo' in the XML. No error is printed.