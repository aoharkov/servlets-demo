package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;

import java.util.List;

public interface ManagerService extends UserService {

    List<Request> findAllRequests(int page, int itemsPerPage);

    boolean acceptRequest(Order order);

    boolean declineRequest(Refusal refusal);

    List<Feedback> findAllFeedback(int page, int itemsPerPage);
}
