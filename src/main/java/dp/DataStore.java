package dp;

public class DataStore {
    User user;

    public DataStore(User user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }
}
