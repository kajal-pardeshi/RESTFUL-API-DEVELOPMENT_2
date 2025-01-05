import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class RestApiExample {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, User> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(RestApiExample.class, args);
    }

    // GET all users
    @GetMapping("/users")
    public Collection<User> getAllUsers() {
        return userDatabase.values();
    }

    // GET a user by ID
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id) {
        return userDatabase.get(id);
    }

    // POST create a new user
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        long id = counter.incrementAndGet();
        user.setId(id);
        userDatabase.put(id, user);
        return user;
    }

    // PUT update an existing user
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User updatedUser) {
        if (userDatabase.containsKey(id)) {
            updatedUser.setId(id);
            userDatabase.put(id, updatedUser);
            return updatedUser;
        }
        return null;
    }

    // DELETE a user by ID
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        if (userDatabase.remove(id) != null) {
            return "User with ID " + id + " deleted.";
        }
        return "User with ID " + id + " not found.";
    }

    // Sample User class
    static class User {
        private long id;
        private String name;
        private String email;

        public User() { }

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
