package com.blak.model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Login {

    @NotNull
    private String email;
    @NotNull
    private String password;

    public Boolean rememberMe;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(email, login.email) &&
                Objects.equals(password, login.password) &&
                Objects.equals(rememberMe, login.rememberMe);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email, password, rememberMe);
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
    }

    public Login email(String email) {
        this.email = email;
        return this;
    }

    public Login password(String password) {
        this.password = password;
        return this;
    }

    public Login rememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
        return this;
    }
}
