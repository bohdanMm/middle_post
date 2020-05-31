package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.pack_receiving.PackageReceivingService;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/package-receiving")
public class PackageReceivingController {

    private final PackageReceivingService packageReceivingService;

    @PostMapping("/create")
    public ResponseEntity<PackageReceivingDto> create(@RequestBody PackageReceivingRequest packageReceivingRequest) {
        return ResponseEntity.ok().body(packageReceivingService.create(packageReceivingRequest));
    }
}
