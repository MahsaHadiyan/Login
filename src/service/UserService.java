package service;

import entity.Users;
import repository.UserDA;

/**
 * Revision History:
 * Date            Author           Task ID                         Notes
 * ==========   =================   ==============  ===============================================
 * 2023.03.12   Mahsa.h
 */
public class UserService {

    private static final UserService USER_SERVICE = new UserService();

    public static UserService getInstance() {
        return USER_SERVICE;
    }

    public Users login(Users users) throws Exception {
        try (UserDA userDA = new UserDA();) {
            return userDA.selectUserByUserNameAndPassword(users);
        }
    }

}
