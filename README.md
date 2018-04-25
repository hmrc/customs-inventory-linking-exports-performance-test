# customs-inventory-linking-exports-performance-test

Performance tests for the `customs-inventory-linking-exports` service.

To run tests locally: 

    sbt -Djava.io.tmpdir=${WORKSPACE}/tmp -DrunLocal=true test 

To run a smoke test locally: 

    sbt -Dperftest.runSmokeTest=true -Djava.io.tmpdir=${WORKSPACE}/tmp -DrunLocal=true test

To run against deployed applications in a managed environment (e.g. staging etc) replace `-DrunLocal=true` with `-DrunLocal=false` in above examples.  

[For more details about configuring or running](https://github.com/hmrc/performance-test-runner)

# seeding api-subscription-fields data

You will have to make sure when running locally that you have seeded data for clientId `6372609a-f550-11e7-8c3f-9a214cf093ae`
This can be done with the following command:

    curl -v -X PUT "http://localhost:9650/field/application/6372609a-f550-11e7-8c3f-9a214cf093ae/context/customs%2Finventory-linking%2Fexports/version/1.0" -H "Cache-Control: no-cache" -H "Content-Type: application/json" -d '{ "fields" : { "callbackUrl" : "https://postman-echo.com/post", "securityToken" : "securityToken" } }'
