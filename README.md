# patient-management-api

# Prerequisite

- Java v11
- postgresql v14.3

# Instructions

1. Clone both patient-management-api, patient-management-ui in to same directory
   `git clone https://github.com/mnibras/patient-management-ui.git`
   `git clone https://github.com/mnibras/patient-management-api.git`
   
2. Create a postgres database called `patient-db`
3. Run the provided jar file as `java -jar patient-management-0.0.1-SNAPSHOT.jar`

    Note: To build new jar file, Run `mvn clean install` from patient-management-api root directory.
4. Once application started visit http://localhost:9090