def inFile = new File('../data/fells_loop.gpx')
def slurper = new XmlSlurper()
def gpx = slurper.parse(inFile)

// Instantiating a new Markup Builder, using streaming mechanics.
def markupBuilder = new groovy.xml.StreamingMarkupBuilder()

// The MarkupBuilder has a bind method that accepts a closure.
// Adds a comment with the name of the gpx document's name (gpx.name):
//      <!--Middlesex Fells Bike Loop-->
// Adds the timestamp attribute, looks like this:
//      <routepoint timestamp='2001-06-02T00:18:15Z'>
def xml = markupBuilder.bind{
    route {
        mkp.comment(gpx.name)
        gpx.rte.rtept.each { point ->
            routepoint(timestamp: point.time.toString()) {
                latitude(point.@lat)
                longitude(point.@lon)
            }
        }
    }
}

// Producing a more concise, truncated version of the data for our needs.
def outFile = new File('../data/fells_loop_truncated.xml')

// Note that closures in Groovy exhibit lazy evaluation. THat means that
// the closure contained in the bind method will NOT be executed until we 
// call it below (write()).
outFile.write(xml.toString())