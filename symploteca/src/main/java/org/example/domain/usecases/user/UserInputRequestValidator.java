package org.example.domain.usecases.user;

import org.example.domain.entities.book.Book;
import org.example.domain.entities.user.User;
import org.example.domain.usecases.utils.Notification;
import org.example.domain.usecases.utils.Validator;

public class UserInputRequestValidator extends Validator<User> {

    @Override
    public Notification validate(User user) {
        Notification notification = new Notification();

        if (user == null){
            notification.addError("User is null");
            return notification;
        }

        if(nullOrEmpty(user.getName())) notification.addError("Name is null or empty");
        if(nullOrEmpty(user.getEmail())) notification.addError("Email is null or empty");
        if(nullOrEmpty(user.getPhone())) notification.addError("Phone is null or empty");

        return notification;
    }
}
