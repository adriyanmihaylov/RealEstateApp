package realEstateApp.repositories;

import org.springframework.stereotype.Repository;
import realEstateApp.models.User;
import realEstateApp.repositories.base.UserRepository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
