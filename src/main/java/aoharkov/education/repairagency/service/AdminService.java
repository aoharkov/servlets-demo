package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Pageable;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;

public interface AdminService extends RegisteredUserService {

    Pageable<User> listAllUsers(int page, int itemsPerPage);

    boolean promoteUser(Integer id, Role role);
}
