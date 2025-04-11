import java.util.HashMap;
import java.util.Map;

// 自定义异常类：邮箱已存在
class EmailExistException extends Exception {
    public EmailExistException() {
        super();
    }
    public EmailExistException(String msg) {
        super(msg);
    }
}

// 自定义异常类：密码太短
class Pwd2ShortException extends Exception {
    public Pwd2ShortException() {
        super();
    }
    public Pwd2ShortException(String msg) {
        super(msg);
    }
}

// 自定义异常类：用户未找到
class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super();
    }
    public UserNotFoundException(String msg) {
        super(msg);
    }
}

// 自定义异常类：密码错误
class PasswordException extends Exception {
    public PasswordException() {
        super();
    }
    public PasswordException(String msg) {
        super(msg);
    }
}

// 用户类
class User {
    private int id;
    private String email;
    private String password;

    public User() {
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

// 用户数据访问对象接口
interface UserDao {
    User addUser(User user) throws EmailExistException, Pwd2ShortException;
    User getUser(String email, String password) throws UserNotFoundException, PasswordException;
}

// 用户数据访问对象实现类（使用Map存储数据）
class UserDaoForMap implements UserDao {
    private Map<String, User> users;
    private int nextId = 1; // 用于生成用户ID

    public UserDaoForMap() {
        this.users = new HashMap<>();
    }

    @Override
    public User addUser(User user) throws EmailExistException, Pwd2ShortException {
        if (users.containsKey(user.getEmail())) {
            throw new EmailExistException("该邮箱已被注册");
        }
        if (user.getPassword().length() < 6) {
            throw new Pwd2ShortException("密码长度不能少于6位");
        }
        user = new User(nextId++, user.getEmail(), user.getPassword());
        users.put(user.getEmail(), user);
        System.out.println("用户注册成功: " + user);
        return user;
    }

    @Override
    public User getUser(String email, String password) throws UserNotFoundException, PasswordException {
        if (!users.containsKey(email)) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = users.get(email);
        if (!user.getPassword().equals(password)) {
            throw new PasswordException("密码错误");
        }
        System.out.println("登录成功: " + user);
        return user;
    }
}

// 应用程序类
class Application {
    private UserDao dao;
    private int idCounter = 1; // 用于模拟ID生成

    public Application(UserDao dao) {
        this.dao = dao;
    }

    public void register(String email, String password) {
        User newUser = new User(idCounter++, email, password);
        try {
            dao.addUser(newUser);
        } catch (EmailExistException e) {
            System.out.println("注册失败: " + e.getMessage());
        } catch (Pwd2ShortException e) {
            System.out.println("注册失败: " + e.getMessage());
        }
    }

    public void login(String email, String password) {
        try {
            dao.getUser(email, password);
        } catch (UserNotFoundException e) {
            System.out.println("登录失败: " + e.getMessage());
        } catch (PasswordException e) {
            System.out.println("登录失败: " + e.getMessage());
        }
    }
}

// 测试类
public class Test {
    public static void main(String[] args) {
        UserDaoForMap userDao = new UserDaoForMap();
        Application app = new Application(userDao);

        // 注册用户
        app.register("test@example.com", "123456");
        app.register("another@example.com", "short");
        app.register("test@example.com", "abcdef"); // 邮箱已存在

        // 登录用户
        app.login("test@example.com", "123456");
        app.login("test@example.com", "wrongpassword");
        app.login("nonexistent@example.com", "any");
    }
}