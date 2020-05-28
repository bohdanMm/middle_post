package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.pack.PackageService;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.dto.PackageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/package")
public class PackageController {

    private final PackageService packageService;

    @PostMapping("/create")
    public ResponseEntity<PackageDto> create(@RequestBody PackageRequest packageRequest) {
        return ResponseEntity.ok().body(packageService.create(packageRequest));
    }
}
