package nulp.middlepost.web.rest;

import lombok.RequiredArgsConstructor;
import nulp.middlepost.service.location.LocationService;
import nulp.middlepost.service.location.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/location")
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/region/create")
    public ResponseEntity<String> createRegion(@RequestBody RegionRequest regionRequest) {
        return ResponseEntity.ok().body(locationService.createRegion(regionRequest));
    }

    @PostMapping("/district/create")
    public ResponseEntity<String> createDistrict(@RequestBody DistrictRequest districtRequest) {
        return ResponseEntity.ok().body(locationService.createDistrict(districtRequest));
    }

    @PostMapping("/locality/create")
    public ResponseEntity<String> createLocality(@RequestBody LocalityRequest localityRequest) {
        return ResponseEntity.ok().body(locationService.createLocality(localityRequest));
    }

    @GetMapping("/region/all")
    public ResponseEntity<List<RegionDto>> getRegions(){
        return ResponseEntity.ok().body(locationService.getRegions());
    }

    @GetMapping("/district/{regionId}")
    public ResponseEntity<List<DistrictDto>> getDistricts(@PathVariable Long regionId){
        return ResponseEntity.ok().body(locationService.getDistrictsByRegion(regionId));
    }

    @GetMapping("/locality/{districtId}")
    public ResponseEntity<List<LocalityDto>> getLocalities(@PathVariable Long districtId){
        return ResponseEntity.ok().body(locationService.getLocalitiesByDistrictId(districtId));
    }

    @DeleteMapping("/region/delete/{regionId}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long regionId){
        locationService.deleteRegion(regionId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/district/delete/{districtId}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long districtId){
        locationService.deleteDistrict(districtId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/locality/delete/{localityId}")
    public ResponseEntity<Void> deleteLocality(@PathVariable Long localityId){
        locationService.deleteLocality(localityId);
        return ResponseEntity.ok().build();
    }
}
