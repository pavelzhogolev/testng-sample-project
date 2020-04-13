package ru.volsu.qa;

public class DatabaseDAO
{
    public int saveUser(User user) {
        System.out.println("Save user to database and return user ID");
        //TODO need to be implemented
        return 12345;
    }

    public User findUser(String name) {
        System.out.println(String.format("Find user with '%s'name in database.", name));
        //TODO need to be implemented
        return new User();
    }
}
