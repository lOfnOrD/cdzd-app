package cdzdapp.domain;

public class Friend {
    private Integer id;
    private final User user;
    private final String firstName;
    private final String lastName;

    public Friend(User user, String firstName, String lastName) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (!firstName.equals(friend.firstName)) return false;
        if (id != null ? !id.equals(friend.id) : friend.id != null) return false;
        if (!lastName.equals(friend.lastName)) return false;
        if (!user.equals(friend.user)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + user.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
