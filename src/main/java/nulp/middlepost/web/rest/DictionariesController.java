package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.domain.PackageType;
import nulp.middlepost.domain.Packaging;
import nulp.middlepost.service.dictionaties.DictionariesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dictionary")
public class DictionariesController {

    private final DictionariesService dictionariesService;

    @GetMapping("/package-type")
    public ResponseEntity<List<PackageType>> getPackageTypes() {
        return ResponseEntity.ok().body(dictionariesService.getAllPackageTypes());
    }

    @GetMapping("/packaging")
    public ResponseEntity<List<Packaging>> getPackaging() {
        return ResponseEntity.ok().body(dictionariesService.getAllPackagingTypes());
    }
}
