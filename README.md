# Java API Service Starter

This is a minimal Java API service starter based on [Google Cloud Run Quickstart](https://cloud.google.com/run/docs/quickstarts/build-and-deploy/deploy-java-service).

## Getting Started

Server should run automatically when starting a workspace. To run manually, run:
```sh
mvn spring-boot:run
```

## PostgreSQL

### Initialize and Run PostgreSQL
```sh
initdb -D /tmp/postgres
pg_ctl -D /tmp/postgres start
```

### Create and Connect to estaciona_uai DB
```sh
createdb -h /tmp/postgres estaciona_uai
psql -h /tmp/postgres estaciona_uai
```

### Create user
```sql
CREATE USER postgres WITH PASSWORD 'Password';
GRANT ALL PRIVILEGES ON SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
```