package edu.tcu.cs.hogwartsartifactsonline.hogwartsuser;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id) {
        super("Could not find user with Id " + id + " :(");
    }
} 