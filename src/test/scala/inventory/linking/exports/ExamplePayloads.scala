package inventory.linking.exports

object ExamplePayloads {
  val validMovement =  <inv:inventoryLinkingMovementRequest xmlns:inv="http://gov.uk/customs/inventoryLinking/v1">
    <inv:messageCode>EAL</inv:messageCode>
    <inv:agentDetails>
      <inv:EORI>EORI</inv:EORI>
      <inv:agentLocation>location</inv:agentLocation>
      <inv:agentRole>AGR</inv:agentRole>
    </inv:agentDetails>
    <inv:ucrBlock>
      <inv:ucr>GB/AAAA-00000</inv:ucr>
      <inv:ucrType>M</inv:ucrType>
    </inv:ucrBlock>
    <inv:goodsLocation>goodsLocation</inv:goodsLocation>
    <inv:goodsArrivalDateTime>2001-12-31T12:00:00</inv:goodsArrivalDateTime>
    <inv:goodsDepartureDateTime>2001-12-31T12:00:00</inv:goodsDepartureDateTime>
    <inv:shedOPID>PID</inv:shedOPID>
    <inv:masterUCR>GB/MAAM-01010</inv:masterUCR>
    <inv:masterOpt>A</inv:masterOpt>
    <inv:movementReference>movementReference</inv:movementReference>
    <inv:transportDetails>
      <inv:transportID>transportID</inv:transportID>
      <inv:transportMode>M</inv:transportMode>
      <inv:transportNationality>ZZ</inv:transportNationality>
    </inv:transportDetails>
  </inv:inventoryLinkingMovementRequest>

  val validConsolidation =  <inv:inventoryLinkingConsolidationRequest xmlns:inv="http://gov.uk/customs/inventoryLinking/v1">
    <inv:messageCode>CST</inv:messageCode>
    <inv:masterUCR>GB/MMMM-00000</inv:masterUCR>
    <inv:ucrBlock>
      <inv:ucr>GB/AAAA-12345</inv:ucr>
      <inv:ucrType>D</inv:ucrType>
    </inv:ucrBlock>
  </inv:inventoryLinkingConsolidationRequest>


  val validQuery = <inv:inventoryLinkingQueryRequest xmlns:inv="http://gov.uk/customs/inventoryLinking/v1">
    <inv:queryUCR>
      <inv:ucr>GB/AAAA-00000</inv:ucr>
      <inv:ucrType>D</inv:ucrType>
    </inv:queryUCR>
    <inv:agentDetails>
      <inv:EORI>EORI</inv:EORI>
      <inv:agentLocation>location</inv:agentLocation>
      <inv:agentRole>AGR</inv:agentRole>
    </inv:agentDetails>
  </inv:inventoryLinkingQueryRequest>

}
