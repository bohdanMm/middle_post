package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.post_office.PostOfficeService;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;
import nulp.middlepost.service.post_office.dto.PostOfficeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post-office")
public class PostOfficeController {

    private final PostOfficeService postOfficeService;

    @PostMapping("/create")
    public ResponseEntity<PostOfficeDto> create(@RequestBody PostOfficeRequest postOfficeRequest) {
        return ResponseEntity.ok().body(postOfficeService.create(postOfficeRequest));
    }
}
