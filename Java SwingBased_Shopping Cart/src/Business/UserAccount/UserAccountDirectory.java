/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.UserAccount;

import java.util.ArrayList;

/**
 *
 * @author Praneeth Reddy
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountDirectory;
    
    public UserAccountDirectory(){
        userAccountDirectory = new ArrayList<UserAccount>();
    }

    /**
     * @return the userAccountDirectory
     */
    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    /**
     * @param userAccountDirectory the userAccountDirectory to set
     */
    public void setUserAccountDirectory(ArrayList<UserAccount> userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public UserAccount addAccount(){
        UserAccount account = new UserAccount();
        userAccountDirectory.add(account);
    return account;    
    }
    
    public UserAccount authenticateUser(String uName, String password){
            for(UserAccount userAccount: userAccountDirectory){
                if(userAccount.getUserName().equals(uName) && userAccount.getPassword().equals(password)){
                    return userAccount;
                }
            }
        return null;
    }
}
