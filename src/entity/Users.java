package entity;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.12   Hadian
 */
public class Users {
    private String username;
    private String password;
    private String roleName;

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public Users setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }
}
