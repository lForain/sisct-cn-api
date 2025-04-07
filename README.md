# sisct-cn-api

## Running the Project on VS Code

1. **Install Prerequisites**:
    - Ensure you have [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) installed.
    - Install [Visual Studio Code](https://code.visualstudio.com/).
    - Install the recommended VS Code extensions for Java development (e.g., [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)).

2. **Clone the Repository**:
    ```bash
    git clone https://github.com/your-username/sisct-cn-api.git
    cd sisct-cn-api
    ```

3. **Set Up Environment Variables**:
    - Create a `.env` file in the root directory if required.
    - Add the necessary environment variables as specified in the project documentation.

4. **Build the Project**:
    - Use the following command to build the project:
      ```bash
      ./gradlew build
      ```
    - Alternatively, if using Maven:
      ```bash
      mvn clean install
      ```

5. **Run the Project**:
    - Start the application:
      ```bash
      ./gradlew bootRun
      ```
    - Alternatively, if using Maven:
      ```bash
      mvn spring-boot:run
      ```

6. **Debugging in VS Code**:
    - Open the project in VS Code:
      ```bash
      code .
      ```
    - Use the built-in debugger by configuring a `launch.json` file in the `.vscode` folder if not already present.

7. **Testing**:
    - Run tests using:
      ```bash
      ./gradlew test
      ```
    - Alternatively, if using Maven:
      ```bash
      mvn test
      ```

8. **Additional Notes**:
    - Refer to the project's documentation for more details on configuration and usage.
    - Ensure your `JAVA_HOME` environment variable is correctly set to the Java 21 installation path.