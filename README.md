# pact-journey
My pact testing framework journey

## Run the Example

* Run `mvn integration-test` in the `consumer` subdirectory.
* Note that JSON Pact files were created in `consumer/target/PACTS`
* Copy json file in folder `/consumer/target/PACTS` to folder `/provider/src/test/resources/pacts` if you change contract of consumer. For example, change the path or change the property name.
* Run `mvn integration-test` in the `provider` subdirecty.
* Note that this test uses the JSON Pact files in `pact-example/provider/src/test/resources/pacts`.

So to change the contract the consumer team would change the tests in `consumer/src/test`. This would result in different Pact files. The consumer team would provide them to the provider team. That way the Pact file would be integrated in the `provider` project. The provider team needs to assure that the tests pass.

## How to configure pact-broker:
Start the PostgreSQL container via:
docker run --name pactbroker-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e PGDATA=/var/lib/postgresql/data/pgdata -v /var/lib/postgresql/data:/var/lib/postgresql/data -d postgres
docker ps

Connect to the container and execute psql via:
docker run -it --link pactbroker-db:postgres --rm postgres sh -c 'exec psql -h "$POSTGRES_PORT_5432_TCP_ADDR" -p "$POSTGRES_PORT_5432_TCP_PORT" -U postgres'

Run the follow SQL configuration scripts:
CREATE USER pactbrokeruser WITH PASSWORD 'pactbrokerpassword';
CREATE DATABASE pactbroker WITH OWNER pactbrokeruser;
GRANT ALL PRIVILEGES ON DATABASE pactbroker TO pactbrokeruser;


Start the PactBroker container via:
docker run --name pactbroker --link pactbroker-db:postgres -e PACT_BROKER_DATABASE_USERNAME=pactbrokeruser -e PACT_BROKER_DATABASE_PASSWORD=pactbrokerpassword -e PACT_BROKER_DATABASE_HOST=postgres -e PACT_BROKER_DATABASE_NAME=pactbroker -d -p 80:80 dius/pact-broker


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