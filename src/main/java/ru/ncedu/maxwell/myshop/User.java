package ru.ncedu.maxwell.myshop;

/**
 * Created by maxwell on 19.11.2017.
 */
public class User {
    //public static int[] users;
    private static int users = 0;
    int userId;
    private String login;
    private String password;
    UserState state;

    public User(String login, String password) {
        users++;
        userId = users;
        setLogin(login);
        setPassword(password);
        UserState state = new UserState();
    }

    private void setLogin (String login) {
        this.login = login;
    }
    private void setPassword(String password) {
        this.password = password;
    }

    public void banUser() {
        state.setBanned();
    }
    public void blockUser () {
        state.setBlocked();
    }
    public void activateUser() {
        state.setActive();
    }
}
