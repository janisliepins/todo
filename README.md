### Run development environment

From root dir: `docker compose -f dev.yml up -d`
Inside rest service container: `mvn clean spring-boot:run -Duser.home=/app`
Inside client service conteiner: `npm run dev`

### Run test environment

TO DO
