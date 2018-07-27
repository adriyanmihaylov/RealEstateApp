package realEstateApp.repositories.base;

import realEstateApp.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User edit(User user);

    void deleteById(Long id);
}
