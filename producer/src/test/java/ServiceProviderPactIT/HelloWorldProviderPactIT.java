package ServiceProviderPactIT;

import au.com.dius.pact.provider.junit.*;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.*;
import org.junit.runner.RunWith;

@RunWith(PactRunner.class)
@Provider("My Spring Boot Provider")
@PactFolder("pacts")
public class HelloWorldProviderPactIT {

    @TestTarget
    public final Target target = new HttpTarget(8080);
}
