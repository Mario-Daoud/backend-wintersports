# eindopdracht2023-Mario-Daoud
Wintersport API

## Database 

#### Country
Deze tabel bevat alle landen. Een land kan meerdere locaties hebben.
#### Location
Deze tabel bevat alle locaties waar er gesport kan worden. Een locatie is altijd verbonden aan 1 land. 
#### Sport
Deze tabel bevat alle sporten.
#### LocationSport
Deze tabel linkt locaties en sporten. Locaties kunnen namelijk meerdere sporten hebben en sporten kunnen in meerdere locaties gedaan worden.
#### Review
Deze tabel bevat alle reviews. Een review is altijd verbonden aan 1 user en aan 1 locatie.
#### User
Deze tabel bevat alle gebruikers.

## Docker compose file
PostgreSQL (:5432) + pgAdmin (:5050)
```yaml
version: "3.8"
services:
  db:
    container_name: postgres
    image: postgres
    restart: always
    environment:
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: root
      POSTGRES_DB: wintersport_db
    ports:
      - "5432:5432"
  pgadmin:
    container_name: pgadmin
    image: dpage/pgadmin4
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: root
    ports:
      - "5050:80"
```
