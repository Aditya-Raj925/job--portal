
# Job Portal - Spring Boot + HTML/CSS (Runnable)

## Run
1) Open this folder in IntelliJ or VS Code as a Maven project.
2) Run: `mvn spring-boot:run`  (or run `com.example.jobportal.JobPortalApplication`).
3) Try in browser:
   - `http://localhost:8080/index.html`
   - `http://localhost:8080/register.html`
   - `http://localhost:8080/apply.html`
   - `http://localhost:8080/jobs.html`
   - `http://localhost:8080/post-job.html`
4) H2 console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:jobdb`).
Uploaded resumes are saved to an `uploads/` folder in the working directory.
