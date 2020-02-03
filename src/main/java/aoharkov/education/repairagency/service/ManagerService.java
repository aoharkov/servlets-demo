package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.Refusal;
import aoharkov.education.repairagency.entity.Request;

public interface ManagerService extends AdminService {

    Page<Request> listAllRequests(int page, int itemsPerPage);

    Page<Request> listUncheckedRequests(int page, int itemsPerPage);

    Order acceptRequest(Integer requestId);

    Refusal declineRequest(Integer requestId);

    Feedback reviewFeedback(Integer requestId);
}
