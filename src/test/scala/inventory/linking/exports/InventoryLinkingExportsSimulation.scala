package inventory.linking.exports

import inventory.linking.exports.ILERequests._
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner

class InventoryLinkingExportsSimulation extends PerformanceTestRunner {

  setup("submit-Csp-1-exports-movement", "Send CSP 1.0 exports movement") withRequests submitCspVersion1ExportMovement

  setup("submit-Csp-1-exports-consolidation", "Send CSP 1.0 exports consolidation") withRequests submitCspVersion1ExportConsolidation

  setup("submit-Csp-1-exports-query", "Send CSP 1.0 exports query") withRequests submitCspVersion1ExportQuery

  setup("submit-NonCsp-1-exports-movement", "Send NonCSP 1.0 exports movement") withRequests submitNonCspVersion1ExportMovement

  setup("submit-NonCsp-1-exports-consolidation", "Send NonCSP 1.0 exports consolidation") withRequests submitNonCspVersion1ExportConsolidation

  setup("submit-NonCsp-1-exports-query", "Send NonCSP 1.0 exports query") withRequests submitNonCspVersion1ExportQuery

  runSimulation()
}
