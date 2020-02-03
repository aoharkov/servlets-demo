package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Pageable;
import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.Refusal;
import aoharkov.education.repairagency.entity.Request;

public interface ClientService extends RegisteredUserService {

    Request makeRequest(Request request);

    Pageable<Request> listOwnRequests(int page, int itemsPerPage);

    Order showOrder(Integer requestId);

    Refusal showRefusal(Integer requestId);

    Feedback leaveFeedback(Integer requestId);
}
