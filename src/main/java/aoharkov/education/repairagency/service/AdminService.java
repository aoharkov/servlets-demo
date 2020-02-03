package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;

public interface AdminService extends RegisteredUserService {

    Page<User> listAllUsers(int page, int itemsPerPage);

    boolean promoteUser(Integer id, Role role);
}
