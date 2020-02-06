package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;

public interface ClientService extends UserService {

    void saveRequest(Request request);

    Page<Request> findOwnRequests(int page, int itemsPerPage);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);
}
