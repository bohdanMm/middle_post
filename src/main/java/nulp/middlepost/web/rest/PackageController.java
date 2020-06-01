package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.pack.PackageService;
import nulp.middlepost.service.pack.dto.PackageDto;
import nulp.middlepost.service.pack.specification.PackageCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/package")
public class PackageController {

    private final PackageService packageService;

    @GetMapping("/all")
    public ResponseEntity<List<PackageDto>> getAll(PackageCriteria criteria){
        return ResponseEntity.ok().body(packageService.getAll(criteria));
    }
}
