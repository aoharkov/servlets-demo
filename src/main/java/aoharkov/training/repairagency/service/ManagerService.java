package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;

import java.util.List;

public interface ManagerService extends UserService {

    List<Request> findAllRequests(int page, int itemsPerPage);

    boolean acceptRequest(Order order);

    boolean declineRequest(Refusal refusal);

    List<Feedback> findAllFeedback(int page, int itemsPerPage);
}
