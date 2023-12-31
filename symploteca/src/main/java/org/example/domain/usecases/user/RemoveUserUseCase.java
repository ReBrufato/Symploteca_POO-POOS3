package org.example.domain.usecases.user;

import org.example.domain.entities.user.User;
import org.example.domain.usecases.utils.EntityNotFoundException;

public class RemoveUserUseCase {

    private UserDAO userDAO;

    public RemoveUserUseCase(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean remove(String id){
        if(id == null || userDAO.findOne(id).isEmpty()) throw new EntityNotFoundException("User not found");

        return userDAO.deleteByKey(id);
    }
    public boolean remove(User user){
        if(user == null || userDAO.findOne(user.getInstitutionalId()).isEmpty()) throw new EntityNotFoundException("User not found");

        return userDAO.delete(user);
    }

}
