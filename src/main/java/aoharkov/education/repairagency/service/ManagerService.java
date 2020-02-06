package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;

public interface ManagerService extends UserService {

    Page<Request> findAllRequests(int page, int itemsPerPage);

    Order acceptRequest(Integer requestId);

    Refusal declineRequest(Integer requestId);

    Page<Feedback> findAllFeedback(int page, int itemsPerPage);
}
