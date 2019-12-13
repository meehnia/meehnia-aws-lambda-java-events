# Unsupported AWS Lambda Java Events


### Event Models Supported Through This Library

The following event models do not require any SDK dependencies
* ApplicationLoadBalancerRequestEvent
* ApplicationLoadBalancerResponseEvent

so the dependencies section in the pom.xml file would like this

```xml
<dependencies>
    ...
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-lambda-java-core</artifactId>
        <version>1.1.0</version>
    </dependency>
    <dependency>
        <groupId>com.meehnia</groupId>
        <artifactId>meehnia-aws-lambda-java-events</artifactId>
        <version>1.0.0</version>
    </dependency>
    ...
</dependencies>
```