package ru.ncedu.maxwell.myshop;

/**
 * Created by maxwell on 20.11.2017.
 */
public class UserState {
    private String state;
    private String message;

    public UserState () {

        this.setNew();
    }
    public void setNew() {
        this.state ="New";
    }
    public void setNew(String message) {
        this.state ="New";
        this.message = message;
    }
    public void setBlocked() {
        this.state = "Blocked";
    }
    public void setBanned() {
        this.state = "Banned";
    }
    public void setActive() {
        this.state = "Active";
    }
    public void setCustom(String state) {
        this.state = state;
    }
}
