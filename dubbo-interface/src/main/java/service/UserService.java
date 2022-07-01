package service;

import pojo.Consumer;

public interface UserService {
    Consumer getUser(int id);

    String countUser(String username,String password);
}
