What is a Transaction in Spring Data JPA?

A transaction is a mechanism used to ensure that a set of operations either all succeed or all fail, preserving data consistency. In the context of Spring Data JPA, a transaction is a sequence of operations (such as database CRUD operations) that are executed as a single unit of work.
Why are Transactions Important?

    Atomicity: A transaction ensures that all database operations are treated as a single unit. If one operation fails, none of the operations will be committed to the database.
    Consistency: Transactions ensure that the database remains in a consistent state before and after the transaction is executed.
    Isolation: Transactions ensure that concurrent transactions do not interfere with each other.
    Durability: Once a transaction is committed, its effects are permanent.

Spring and Transaction Management

In Spring, transaction management is handled via the Spring Transaction Management API. Spring provides both programmatic and declarative transaction management. Declarative transaction management is commonly used in Spring Data JPA as it is simple and requires minimal code.
Types of Transaction Management in Spring

    Programmatic Transaction Management:
        Transactions are managed using the PlatformTransactionManager API. This requires manual handling of transaction start, commit, and rollback.
    Declarative Transaction Management:
        This is done using annotations (@Transactional) or XML configuration.
        In Spring Data JPA, declarative transactions are much more commonly used, as it allows for cleaner, more readable code.

Using @Transactional in Spring Data JPA

The @Transactional annotation is the primary mechanism for handling transactions declaratively in Spring. You can apply it at the method level or the class level.
1. @Transactional on Methods

Applying @Transactional to a method means that all database operations inside the method will be executed within a single transaction. If an exception occurs, the transaction will be rolled back.

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void updateUserInfo(Long userId, String newName, String newEmail) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(newName);
        user.setEmail(newEmail);
        userRepository.save(user);
    }
}

    @Transactional: Ensures that the updateUserInfo method will run within a single transaction. If an exception occurs, all changes will be rolled back.

2. @Transactional on Classes

You can also apply @Transactional at the class level. This means all methods in that class will participate in transactions.

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUserInfo(Long userId, String newName, String newEmail) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(newName);
        user.setEmail(newEmail);
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}

    @Transactional at the class level: This means that all methods in this class are transactional by default. You can override this behavior on a per-method basis if needed.

Key Attributes of @Transactional

The @Transactional annotation has several important attributes that allow you to configure the transaction behavior.

    propagation:
        Defines how the transaction should behave in the presence of an existing transaction.
        Common values:
            REQUIRED (default): If there’s an existing transaction, the method will join it. If no transaction exists, a new one will be created.
            REQUIRES_NEW: Always starts a new transaction, suspending the current one if necessary.
            SUPPORTS: Executes the method within the current transaction if one exists, or without a transaction if none exists.
            NOT_SUPPORTED: Executes the method without a transaction, suspending any existing transaction.

    Example:

@Transactional(propagation = Propagation.REQUIRES_NEW)
public void someMethod() {
    // Will start a new transaction regardless of whether one exists.
}

isolation:

    Defines the isolation level for the transaction (i.e., how the transaction should behave in the presence of concurrent transactions).
    Common values:
        READ_COMMITTED (default): Only reads committed data.
        READ_UNCOMMITTED: Allows reading uncommitted data.
        REPEATABLE_READ: Prevents non-repeatable reads within the transaction.
        SERIALIZABLE: The strictest isolation level, preventing any concurrent transactions.

Example:

@Transactional(isolation = Isolation.SERIALIZABLE)
public void someMethod() {
    // Ensures the transaction is executed with the strictest isolation level.
}

timeout:

    Specifies the maximum time (in seconds) that a transaction can run before it is automatically rolled back.

Example:

@Transactional(timeout = 5)  // 5 seconds
public void someMethod() {
    // Will be rolled back automatically if execution exceeds 5 seconds.
}

readOnly:

    Specifies whether the transaction is read-only, which can be used for optimization purposes.
    readOnly = true indicates that the method only reads data and does not modify the database.

Example:

@Transactional(readOnly = true)
public List<User> getAllUsers() {
    return userRepository.findAll();
}

rollbackFor:

    Defines which exceptions should cause a rollback of the transaction. By default, Spring only rolls back on unchecked exceptions (RuntimeException) and errors (Error).

Example:

    @Transactional(rollbackFor = Exception.class)
    public void someMethod() throws Exception {
        // Will rollback on checked exceptions as well.
    }

Rollback Behavior

By default, Spring only rolls back the transaction in case of unchecked exceptions (i.e., RuntimeException and Error). If you want to trigger a rollback for checked exceptions as well, you can use the @Transactional annotation's rollbackFor attribute.

Example: Rollback on SQLException (a checked exception)

@Transactional(rollbackFor = SQLException.class)
public void someMethod() throws SQLException {
    // Will rollback if SQLException occurs
}

Transaction Management with Multiple Data Sources

If you have multiple data sources in a Spring Boot application, Spring allows you to manage transactions across multiple databases using @Transactional combined with @Primary annotations for specifying the main data source, or using multiple PlatformTransactionManager beans.
Transaction Propagation Example

Consider a scenario where one method calls another method that is also transactional:

@Service
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public void placeOrder(Order order) {
        // Step 1: Save the order
        orderRepository.save(order);

        // Step 2: Process payment
        paymentService.processPayment(order.getPayment());

        // Step 3: Update stock
        updateStock(order);
    }
}

@Service
public class PaymentService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processPayment(Payment payment) {
        // Start a new transaction, even if one exists in the calling method
        paymentRepository.save(payment);
    }
}

    Propagation.REQUIRES_NEW: Ensures that the processPayment method runs in a new transaction, independent of the placeOrder method's transaction. Even if the outer method fails, the inner method's transaction (payment processing) will be committed or rolled back independently.

Conclusion

Transactions are critical for ensuring that database operations are executed reliably and consistently. In Spring Data JPA, you can manage transactions declaratively using the @Transactional annotation. It simplifies the handling of transactions, ensures data integrity, and helps maintain consistency, even in the presence of errors.

By combining transaction management with repository methods, you can control the boundaries of your data operations while keeping your code clean and easy to maintain.
