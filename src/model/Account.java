package model;

public class Account {

    private String id;
    private String userName;
    private Long balance;

    public Account(String id, String userName, Long balance) {
        this.id = id;
        this.userName = userName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
