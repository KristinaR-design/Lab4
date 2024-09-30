package org.example.lab4;

import java.util.Optional;

public interface ProfileRepository {
    Optional<Student> getProfileById(int id);
}
