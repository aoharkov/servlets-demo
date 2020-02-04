package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.Refusal;
import aoharkov.education.repairagency.entity.Request;

public interface ClientService extends UserService {

    void saveRequest(Request request);

    Page<Request> findOwnRequests(int page, int itemsPerPage);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);
}
