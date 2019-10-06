package crypto

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class CryptoBasicSimulation extends Simulation {

  val httpProtocol = http
      .baseUrl("http://localhost:8080") // Here is the root for all relative URLs
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")


  val usersDef = scala.util.Properties.envOrElse("numberOfUsers", "5")
  val durationDef = scala.util.Properties.envOrElse("durationInSeconds", "30")
  val users = System.getProperty("users", usersDef).toInt
  val duration = System.getProperty("durationInSecs", durationDef).toInt



     object LookupDecide {

      val lookupDecide = tryMax(2) { // let's try at max 2 times
        exec(
          http("Lookup Decide")
            .get("/decide")
          .check(status.is(200))
          .check(bodyString.in("BTC","ETH"))) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
          .pause(2)
      }.exitHereIfFailed // if the chain didn't finally succeed, have the user exit the whole scenario
    }


 val lookupDecide = scenario("Lookup Decide").exec(LookupDecide.lookupDecide)

 setUp(
    lookupDecide.inject(rampUsers(users) during(duration))
  ).protocols(httpProtocol)



}

