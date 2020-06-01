package nulp.middlepost.service.history;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.Employee;
import nulp.middlepost.domain.History;
import nulp.middlepost.repository.HistoryRepository;
import nulp.middlepost.service.history.dto.HistoryDto;
import nulp.middlepost.service.history.dto.HistoryRequest;
import nulp.middlepost.service.history.mapper.HistoryMapper;
import nulp.middlepost.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;
    private final UserService userService;

    public HistoryDto create(HistoryRequest historyRequest) {
        log.debug("Create history record");

        History history = historyMapper.toEntity(historyRequest);
        Employee employee = userService.getEmployeeById(historyRequest.getEmployee());
        history.setPostOffice(employee.getPostOffice());
        History save = historyRepository.save(history);

        return historyMapper.toDto(save);
    }

    public List<HistoryDto> getForPac(Long pacId){
        log.debug("Get package history: {}", pacId);

        return historyRepository.findByPacId(pacId)
                .stream()
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }
}
