package aoharkov.training.repairagency.command.master;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.service.MasterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllRepairStagesCommand implements Command {
    private final MasterService masterService;

    public FindAllRepairStagesCommand(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String page = request.getParameter("page");

        int itemsPerPage = Integer.parseInt(rows);
        int pageNum = Integer.parseInt(page);

        Page<RepairStage> pageOfRepairStages = masterService.findAllRepairStages(pageNum, itemsPerPage);

        List<RepairStage> repairStages = pageOfRepairStages.getContent();
        request.setAttribute("stages", repairStages);
        request.setAttribute("maxPage", pageOfRepairStages.getTotalPages());
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/master/stages", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
