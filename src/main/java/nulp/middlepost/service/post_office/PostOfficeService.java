package nulp.middlepost.service.post_office;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.PostOffice;
import nulp.middlepost.repository.PostOfficeRepository;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;
import nulp.middlepost.service.post_office.dto.PostOfficeRequest;
import nulp.middlepost.service.post_office.mapper.PostOfficeMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;
    private final PostOfficeMapper postOfficeMapper;

    public PostOfficeDto create(PostOfficeRequest postOfficeRequest) {
        log.debug("Create post office");

        PostOffice savedPostOffice = postOfficeRepository.save(postOfficeMapper.toEntity(postOfficeRequest));

        return postOfficeMapper.toDto(savedPostOffice);
    }
}
