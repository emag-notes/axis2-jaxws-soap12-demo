# axis2-jaxws-soap12-demo

## Environment

* Axis2: 1.7.3
* Tomcat: 8.0.35
* OpenJDK: java-1.8.0-openjdk-debuginfo-1.8.0.91-6.b14.fc23.x86_64

## Usage

### Add tools.jar to CLASSPATH

``` sh
$ cp setenv.sh <YOUR_CATALINA_HOME>/bin
```

please change JAVA_HOME to your environment.

### Create server app and deploy to Tomcat

``` sh
$ ./mvnw clean package -pl server
$ cp server/target/axis2-jaxws-soap12-demo-server.war <YOUR_CATALINA_HOME>/webapps
```

And run tomcat with 8080 port.

### Access to service

#### SOAP 1.1

``` sh
$ ./mvnw clean test -pl client -Dtest=axis2.jaxws.soap12.client.ClientTest#testSoap11
```

it should works fine.

#### SOAP 1.2

``` sh
$ ./mvnw clean test -pl client -Dtest=axis2.jaxws.soap12.client.ClientTest#testSoap12
```

you should get a below error log in catalina.out.

### Error log

``` sh
wsgen can not generate WSDL for SOAP 1.2 binding: http://www.w3.org/2003/05/soap/bindings/HTTP/ on class: axis2.jaxws.soap12.server.HelloWorldSoap12.



Usage: WSGEN [options] <SEI>

where [options] include:
  -classpath <path>          specify where to find input class files and wsgen extensions
  -cp <path>                 specify where to find input class files and wsgen extensions
  -d <directory>             specify where to place generated output files
  -encoding <encoding>       specify character encoding used by source files
  -extension                 allow vendor extensions - functionality not specified
                             by the specification.  Use of extensions may
                             result in applications that are not portable or
                             may not interoperate with other implementations
  -help                      display help
  -J<javacOption>            pass this option to javac
  -keep                      keep generated files
  -r <directory>             resource destination directory, specify where to
                             place resouce files such as WSDLs
  -s <directory>             specify where to place generated source files
  -verbose                   output messages about what the compiler is doing
  -version                   print version information
  -fullversion               print full version information
  -wsdl[:protocol]           generate a WSDL file. The protocol is optional.
                             Valid protocols are [soap1.1, Xsoap1.2],
                             the default is soap1.1.
                             The non standard protocols [Xsoap1.2]
                             can only be used in conjunction with the
                             -extension option.
  -inlineSchemas             inline schemas in the generated wsdl. Must be
                             used in conjunction with the -wsdl option.
  -servicename <name>        specify the Service name to use in the generated WSDL
                             Used in conjunction with the -wsdl option.
  -portname <name>           specify the Port name to use in the generated WSDL
                             Used in conjunction with the -wsdl option.
  -x <file>                  specify External Web Service Metadata xml descriptor

Extensions:
  -Xnocompile                do not compile generated Java files

Examples:
  wsgen -cp . example.Stock
  wsgen -cp . example.Stock -wsdl -servicename {http://mynamespace}MyService

17-Jun-2016 14:06:48.252 SEVERE [http-nio-8080-exec-1] org.apache.axis2.jaxws.description.builder.JAXWSRIWSDLGenerator.generateWsdl Error occurred generating WSDL file for Web service implementation class {axis2.jaxws.soap12.server.HelloWorldSoap12}
 java.lang.Exception: A WSDL Definition could not be generated for the implementation class: axis2.jaxws.soap12.server.HelloWorldSoap12
	at org.apache.axis2.jaxws.description.builder.JAXWSRIWSDLGenerator.generateWsdl(JAXWSRIWSDLGenerator.java:188)
	at org.apache.axis2.jaxws.description.builder.JAXWSRIWSDLGenerator.initialize(JAXWSRIWSDLGenerator.java:389)
	at org.apache.axis2.jaxws.description.builder.JAXWSRIWSDLGenerator.getWSDL(JAXWSRIWSDLGenerator.java:382)
	at org.apache.axis2.jaxws.description.builder.JAXWSRIWSDLGenerator.getWSDL(JAXWSRIWSDLGenerator.java:86)
	at org.apache.axis2.description.AxisService.printWSDL(AxisService.java:1474)
	at org.apache.axis2.transport.http.ListingAgent.handleWSDLRequest(ListingAgent.java:331)
	at org.apache.axis2.transport.http.ListingAgent.processListService(ListingAgent.java:187)
	at org.apache.axis2.transport.http.AxisServlet.doGet(AxisServlet.java:277)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:622)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:292)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:212)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:106)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:502)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:141)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79)
	at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:616)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:528)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1099)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:672)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1520)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.run(NioEndpoint.java:1476)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
```