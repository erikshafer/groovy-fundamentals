def file = new File('../data/fells_loop.gpx')
println file.exists()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

// There is no method called name or desc, but due to the dynamic
// nature of Groovy, at run-time it will try to resolve them. It
// finds the properties and prints them accordingly.
println gpx.name            // XML element, no special syntax
println ''
println gpx.desc            // XML element
println ''
// println gpx.foo // There is no 'foo' in the XML. No error is printed.
println gpx.@version        // @ is 'attribute notation'
println gpx.@creator        // XML attribute

// print out latitude and long, both are XML attributes
// for (point in gpx.rte.rtept) {
//     println point.@lat      
//     println point.@lon      
//     println point.time 
// }

gpx.rte.rtept.each {
    println it.@lat
    println it.@lon
    println it.time 
}