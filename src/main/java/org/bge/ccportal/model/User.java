package org.bge.ccportal.model;

public class User {

	private String username;
	private String password;
	private boolean enabled;

        public User(){}
        public User(String username, String password, boolean enabled){
            this.username = username;
            this.password = password;
            this.enabled = enabled;
        }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String describe(){
        StringBuilder sb = new StringBuilder();
        sb.append("User: ")
                .append(this.username)
                .append(", Password: ")
                .append(this.password)
                .append(", Enabled: ")
                .append(this.enabled);
        return sb.toString();
    }

}
