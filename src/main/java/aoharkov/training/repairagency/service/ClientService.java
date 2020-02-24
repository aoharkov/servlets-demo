package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;

public interface ClientService {

    void saveRequest(Request request);

    Page<Request> findOwnRequests(int page, int itemsPerPage, Integer id);

    Request findRequest(Integer id);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);

    RepairStage findRepairStage(Integer requestId);
}
