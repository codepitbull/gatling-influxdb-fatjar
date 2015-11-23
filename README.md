#Gatling, InfluxDB and FatJars
## Preparing the Project
There are a few things to remember when creating a Gatling FatJar:
* Use _props.dataDirectory("jar")_ to enable loading of resources from the classpath
* There needs to be an empty class in _src/test/scala_ because Gatling is doing a hardcoded check against the existence 
of _target/test-classes_ when run from the IDE.

## Building the FatJar
I use the maven-shade-plugin to create the FatJar. The version included in this project strips the META-INF-contents to 
avoid problems with signed JARs.

##Instructions to get InfluxDB running on Mac OS X
_brew install influxdb_

After that open _/usr/local/etc/influxdb.conf_ and check that the Graphite section looks like this:

```
[[graphite]]
   enabled = true
   bind-address = ":2003"
   database = "gatling"
   protocol = "tcp"
```

Fire up InfluxDB:
_influxd -config /usr/local/etc/influxdb.conf_

Connect to it:
_influx_

And then use the followoing command sequence:
* use gatling
* show series
* select * from "gatling.basicsimulation.request_1_Redirect_1.ok.percentiles99-0";

