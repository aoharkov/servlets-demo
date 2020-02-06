package aoharkov.education.repairagency.entity;

import aoharkov.education.repairagency.domain.Role;

import java.util.Objects;

public class UserEntity {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Role role;

    private UserEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity)) return false;
        UserEntity userEntity = (UserEntity) o;
        return id.equals(userEntity.id) &&
                name.equals(userEntity.name) &&
                Objects.equals(surname, userEntity.surname) &&
                email.equals(userEntity.email) &&
                password.equals(userEntity.password) &&
                role == userEntity.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private Role role;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withRole(Role role) {
            this.role = role;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(this);
        }
    }
}
