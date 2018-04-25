# customs-inventory-linking-exports-performance-test

Performance tests for the `customs-inventory-linking-exports` service.

To run tests: sbt -Djava.io.tmpdir=${WORKSPACE}/tmp test

To run a smoke test: sbt -Dperftest.runSmokeTest=true -Djava.io.tmpdir=${WORKSPACE}/tmp test

For more details about configuring or running:  https://github.com/hmrc/performance-test-runner