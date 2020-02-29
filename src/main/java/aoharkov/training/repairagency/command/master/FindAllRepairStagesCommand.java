package aoharkov.training.repairagency.command.master;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.service.MasterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_PAGE;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_ROWS;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.parseWithDefault;

public class FindAllRepairStagesCommand implements Command {
    private final MasterService masterService;

    public FindAllRepairStagesCommand(MasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsPerPage = parseWithDefault(request.getParameter("rows"), DEFAULT_ROWS);
        int pageNum = parseWithDefault(request.getParameter("page"), DEFAULT_PAGE);

        Page<RepairStage> pageOfRepairStages = masterService.findAllRepairStages(pageNum, itemsPerPage);
        request.setAttribute("stages", pageOfRepairStages.getContent());
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
