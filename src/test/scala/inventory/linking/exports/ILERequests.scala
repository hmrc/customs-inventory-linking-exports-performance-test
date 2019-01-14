package inventory.linking.exports

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object ILERequests extends ServicesConfiguration {

  val authBaseUrl = baseUrlFor("auth")
  val apiBaseUrl = baseUrlFor("inventory-linking-exports")

  val SuccessfulSubmissionStatusCode = 202
  val Movement = StringBody(ExamplePayloads.validMovement.toString())
  val Consolidation = StringBody(ExamplePayloads.validConsolidation.toString())
  val Query = StringBody(ExamplePayloads.validQuery.toString())

  val SubmissionStatus = "SubmissionStatus"
  val SubmissionId = "SubmissionId"

  private def headers(user: User): Map[String, String] = Map(
    "Accept" -> s"application/vnd.hmrc.${user.version}+xml",
    "Content-Type" -> "application/xml; charset=UTF-8",
    "Authorization" -> s"Bearer ${user.token}",
    "X-Client-ID" -> "6372609a-f550-11e7-8c3f-9a214cf093ae",
    "X-Badge-Identifier" -> "PHL123",
    "X-Submitter-Identifier" -> "GB9988776655"
  )

  private def submitMovement(user: User): HttpRequestBuilder = http("Submit Movement")
    .post(apiBaseUrl + "/": String)
    .headers(headers(user))
    .body(Movement)
    .check(status.is(SuccessfulSubmissionStatusCode))

  private def submitConsolidation(user: User): HttpRequestBuilder = http("Submit Consolidation")
    .post(apiBaseUrl + "/": String)
    .headers(headers(user))
    .body(Consolidation)
    .check(status.is(SuccessfulSubmissionStatusCode))

  private def submitQuery(user: User): HttpRequestBuilder = http("Submit Query")
    .post(apiBaseUrl + "/": String)
    .headers(headers(user))
    .body(Query)
    .check(status.is(SuccessfulSubmissionStatusCode))

  def submitCspVersion1ExportMovement = submitMovement(Csp("1.0"))
  def submitCspVersion1ExportConsolidation = submitConsolidation(Csp("1.0"))
  def submitCspVersion1ExportQuery = submitQuery(Csp("1.0"))
  def submitNonCspVersion1ExportMovement = submitMovement(NonCsp("1.0"))
  def submitNonCspVersion1ExportConsolidation = submitConsolidation(NonCsp("1.0"))
  def submitNonCspVersion1ExportQuery = submitQuery(NonCsp("1.0"))
}

sealed abstract class User(val token: String, val version: String){
  require(Seq("CSP", "Non CSP").contains(token))
  require(Seq("1.0", "1.0").contains(version))
}

sealed case class Csp(override val version: String) extends User("CSP", version)
sealed case class NonCsp(override val version: String) extends User("Non CSP", version)
