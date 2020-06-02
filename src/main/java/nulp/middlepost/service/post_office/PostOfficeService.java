package nulp.middlepost.service.post_office;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nulp.middlepost.domain.PostOffice;
import nulp.middlepost.repository.PostOfficeRepository;
import nulp.middlepost.service.post_office.dto.PostOfficeDto;
import nulp.middlepost.service.post_office.dto.PostOfficeRequest;
import nulp.middlepost.service.post_office.mapper.PostOfficeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PostOfficeDto> getByLocality(Long localityId){
        log.debug("Get post offices by locality: {}", localityId);

        postOfficeRepository.findAll();
        return postOfficeRepository.findByLocalityId(localityId)
                .stream()
                .map(postOfficeMapper::toDto)
                .collect(Collectors.toList());
    }
}
