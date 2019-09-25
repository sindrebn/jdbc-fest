# JDBC-FEST 2019

Dette prosjektet er et utgangspunkt for å lage et forbedret API på toppen av Springs [JDBC Template](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html).

Med på lasset følger en in-memory-database (HSQLDB) som starter og stopper sammen applikasjonen.

Databasen blir populert med et veldig enkelt skjema ved oppstart:
 
1. Tabellen `FAGGRUPPE` inneholder en `id` og et `navn`
1. Tabellen `ANSATT` inneholder en `id`, et `fornavn` og `faggruppe_id` som er en fremmednøkkel til `FAGGRUPPE`-tabellen.

En håndfull rader blir også automatisk lagt inn, se `schema.sql`.

For å gjøre spørringer mot databasen kan du for eksempel bruke `main`-metoden i `App`-klassen eller skrive enhetstester.

Så lenge test-klassen din arver fra `DBTest` vil databasen starte og stoppe for hver test, som betyr at hver `@Test`-metode starter med en prepopulert database som spesifiert i `schema.sql`. 
