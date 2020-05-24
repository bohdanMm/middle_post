package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.location.LocationService;
import nulp.middlepost.service.location.dto.DistrictRequest;
import nulp.middlepost.service.location.dto.LocalityRequest;
import nulp.middlepost.service.location.dto.RegionRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/region/create")
    public ResponseEntity<String> createRegion(@RequestBody RegionRequest regionRequest){
        return ResponseEntity.ok().body(locationService.createRegion(regionRequest));
    }

    @PostMapping("/district/create")
    public ResponseEntity<String> createDistrict (@RequestBody DistrictRequest districtRequest){
        return ResponseEntity.ok().body(locationService.createDistrict(districtRequest));
    }

    @PostMapping("/locality/create")
    public ResponseEntity<String> createLocality(@RequestBody LocalityRequest localityRequest){
        return ResponseEntity.ok().body(locationService.createLocality(localityRequest));
    }
}
