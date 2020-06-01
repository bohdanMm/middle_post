package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.history.HistoryService;
import nulp.middlepost.service.history.dto.HistoryDto;
import nulp.middlepost.service.history.dto.HistoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping("/create")
    public ResponseEntity<HistoryDto> create(@RequestBody HistoryRequest historyRequest) {
        return ResponseEntity.ok().body(historyService.create(historyRequest));
    }

    @GetMapping("/{packageId}")
    public ResponseEntity<List<HistoryDto>> getPackageHistory(@PathVariable Long packageId){
        return ResponseEntity.ok().body(historyService.getForPac(packageId));
    }
}
