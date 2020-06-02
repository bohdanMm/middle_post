package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.post_office.PostOfficeService;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;
import nulp.middlepost.service.post_office.dto.PostOfficeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post-office")
public class PostOfficeController {

    private final PostOfficeService postOfficeService;

    @PostMapping("/create")
    public ResponseEntity<PostOfficeDto> create(@RequestBody PostOfficeRequest postOfficeRequest) {
        return ResponseEntity.ok().body(postOfficeService.create(postOfficeRequest));
    }

    @GetMapping("/{localityId}")
    public ResponseEntity<List<PostOfficeDto>> getByLocalityId(@PathVariable Long localityId){
        return ResponseEntity.ok().body(postOfficeService.getByLocality(localityId));
    }
}
