package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;

import java.util.List;

public interface ClientService extends UserService {

    void saveRequest(Request request);

    List<Request> findOwnRequests(int page, int itemsPerPage, Integer id);

    Order findOrder(Integer requestId);

    Refusal findRefusal(Integer requestId);

    void saveFeedback(Feedback feedback);

    RepairStage findRepairStage(Integer requestId);
}
