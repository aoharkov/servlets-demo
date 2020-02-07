package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.RepairStage;
import aoharkov.education.repairagency.domain.Request;

import java.util.List;

public interface ClientService extends UserService {

    void saveRequest(Request request);

    List<Request> findOwnRequests(int page, int itemsPerPage, Integer id);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);

    RepairStage findRepairStage(Integer requestId);
}
