package nulp.middlepost.service.pack_receiving.mapper;

import nulp.middlepost.domain.PackageReceiving;
import nulp.middlepost.service.authorization.mapper.CustomerMapper;
import nulp.middlepost.service.authorization.mapper.EmployeeMapper;
import nulp.middlepost.service.dictionaties.mapper.PackagingMapper;
import nulp.middlepost.service.pack.mapper.PacMapper;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingDto;
import nulp.middlepost.service.pack_receiving.dto.PackageReceivingRequest;
import nulp.middlepost.service.post_office.mapper.PostOfficeMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",
        uses = {
                PostOfficeMapper.class,
                CustomerMapper.class,
                PackagingMapper.class,
                EmployeeMapper.class,
        })
public abstract class PackageReceivingMapper {

    @Autowired
    private PacMapper packageMapper;

    @Mapping(target = "packaging", source = "packaging.name")
    public abstract PackageReceivingDto toDto(PackageReceiving packageReceiving);

    @Mapping(target = "sender", expression = "java(customerMapper.fromId(packageReceivingRequest.getSender()))")
    @Mapping(target = "receiver", expression = "java(customerMapper.fromId(packageReceivingRequest.getReceiver()))")
    @Mapping(target = "employee", expression = "java(employeeMapper.fromId(packageReceivingRequest.getEmployee()))")
    @Mapping(target = "pack", ignore = true)
    public abstract PackageReceiving toEntity(PackageReceivingRequest packageReceivingRequest);

    @AfterMapping
    protected void mapPackage(@MappingTarget PackageReceiving packageReceiving, PackageReceivingRequest request) {
        packageReceiving.setPack(packageMapper.fromId(request.getPack()));
    }
}
