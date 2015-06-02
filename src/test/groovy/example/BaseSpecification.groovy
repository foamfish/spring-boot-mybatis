package example

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import wslite.rest.RESTClient

@WebIntegrationTest("server.port:7777")
@ContextConfiguration(classes = [Application], loader = SpringApplicationContextLoader.class)
// @ActiveProfilesでtest/resources/application-integration.ymlの差分をapplication.ymlの値に上書きして稼働する
@ActiveProfiles("integration")
abstract class BaseSpecification extends Specification {
    def getRestClient() {
        return new RESTClient("http://localhost:7777")
    }
}
