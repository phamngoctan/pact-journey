# pact-journey
My pact testing framework journey

## Run the Example

* Run `mvn integration-test` in the `consumer` subdirectory.
* Note that JSON Pact files were created in `consumer/target/PACTS`
* Copy json file in folder `/consumer/target/PACTS` to folder `/provider/src/test/resources/pacts` if you change contract of consumer. For example, change the path or change the property name.
* Run `mvn integration-test` in the `provider` subdirecty.
* Note that this test uses the JSON Pact files in `pact-example/provider/src/test/resources/pacts`.

So to change the contract the consumer team would change the tests in `consumer/src/test`. This would result in different Pact files. The consumer team would provide them to the provider team. That way the Pact file would be integrated in the `provider` project. The provider team needs to assure that the tests pass.

## How to configure pact-broker

## Publish pact files to pact-broker:
* Run `mvn pact:publish` in the `consumer` subdirectory.

## Verify the provider directly from the consumer
* Run `mvn pact:verify` in the `consumer` subdirectory.


## References:
https://docs.pact.io/faq/convinceme.html

https://github.com/pact-foundation/pact-specification

https://github.com/pact-foundation/pact-ruby/wiki/FAQ

https://github.com/DiUS/pact_broker-docker/blob/master/POSTGRESQL.md

https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-maven#publishing-pact-files-to-a-pact-broker-version-320