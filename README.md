## LSI-MAX: Streaming Application (Hexagonal Architecture)

<p align="center">
  <img src="/screenshots/home.png" alt="Homepage" width="500"/>
</p>

<p align="center">
  <img src="/screenshots/contentDetail.png" alt="Content Details View" width="500"/>
</p>

### Project Summary

This project is a fullstack application that simulates a Subscription Video On Demand (SVOD) service. It is designed to manage content catalogs, subscriptions, and user access.

It was developed using Hexagonal Architecture (Ports & Adapters) to ensure a strict separation of concerns and high testability. This design keeps the Domain Core entirely independent from infrastructure details (Databases, UI, APIs).


### Technology Stack

| Category | Technology | Version | Purpose / Demonstrated Skill |
| :--- | :--- | :--- | :--- |
| **Language** | **Java** | 11 (LTS) | Industry standard for enterprise applications. |
| **Framework** | **Spring Boot** | 2.7.x | Building robust, modular services. |
| **Architecture** | **Hexagonal (Ports & Adapters)** | N/A | Design for modularity, low coupling, and **Microservice readiness**. |
| **Security** | **Spring Security** | 5.x | Role-based authentication and endpoint protection. |
| **Persistence** | **Spring Data JPA** / H2 | N/A | Relational data management. H2 for *runtime* development and testing. |
| **Mapping** | **MapStruct** | 1.5.5.Final | Efficient object mapping (DTOs to Entities) within the *Adapters* layer. |
| **Frontend** | **Thymeleaf** | N/A | Dynamic presentation layer integrated with Spring Security. |
| **Build Tool** | **Maven** | N/A | Dependency management and application lifecycle. |


### Hexagonal Architecture in LSI-MAX

The project structure faithfully follows the Ports and Adapters pattern to isolate the business core.

This is evident in the main packages:

1.  **`domain`**: Contains the core business rules (Entities, Types) and Use Cases (mainly the typical CRUD operations Interfaces). **Zero** dependencies on infrastructure.
2.  **`application`**: Defines the **Ports** (Service and Repository Interfaces) and contains the **Primary Adapters** (Service implementations coordinating the Use Cases).
      * **`port`:** Defines the Service Interfaces (Primary Ports, exposed to Inbound Adapters) and Repository Interfaces (Secondary Ports, required by the Outbound Adapters).
      * **`service` (Primary Adapters):** Implements the Use Cases by coordinating the business flow between the domain models and the secondary ports.
4.  **`infrastructure`**: Implements the **Adapters** that fulfill the contracts defined by the **Ports**.
      * **`adapter.inbound` (Inbound Adapters):** Handles external inputs. Implemented by **`controller` (REST/APIs)** and **`presenter` (Thymeleaf/UI)**.
      * **`adapter.outbound` (Outbound Adapters):** Handles external outputs. Implemented by **Spring Data JPA** for database communication.

### Running the Project Locally

To run the service on your machine, you must have Java 11 or higher and Maven installed.

1.  **Clone the Repository:**

    ```bash
    git clone https://github.com/Jherna77/spring-hexagonal-streaming.git
    cd spring-hexagonal-streaming
    ```

2.  **Compile and Package:**

    ```bash
    mvn clean install
    ```

3.  **Execute the Application:**

    ```bash
    java -jar target/lsi-max-1.0.jar
    ```

The service will be available at `http://localhost:8080`.

### Access Credentials

The login screen for the application is shown below:

<p align="center">
  <img src="/screenshots/login.png" alt="Login Screen" width="500"/>
</p>

To test the role-based security (Spring Security) and the content access features of the application, you can log in using the following predefined users:

| User Role | Email | Password |
| :--- | :--- | :--- |
| Administrator | admin@lsimax.es | password |
| Employee | employee@lsimax.es | password |
| Member | member@lsimax.es | password |

### Administrator Dashboard Overview

The application features a secure Administrator Dashboard accessible only to users with ADMIN role (enforced by Spring Security).

This dashboard showcases the Analytics and Reporting capabilities of the service, allowing authorized personnel to:

  * Monitor key application usage metrics (Content Valuation, Reproductions).
  * Analyze content consumption trends and user interaction data.
  * Manage the application's content catalog and user roles.

This segregation of duties highlights the project's robust approach to security.

<p align="center">
  <img src="/screenshots/adminDashboard.png" alt="Admin dashboard showing statistics" width="500"/>
</p>

### Testing and Quality

The Hexagonal Architecture design choice is key to ensuring that the application core remains highly testable. A layered testing strategy is employed to verify the integrity of all architectural boundaries.

  * **Tools:** **JUnit 5** and **Spring Security Test** are used for functional and security verification.
  * **Run Tests:**
    ```bash
    mvn test
    ```
