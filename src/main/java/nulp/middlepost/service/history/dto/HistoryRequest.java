package nulp.middlepost.service.history.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class HistoryRequest {

    private Long id;

    private Long postOffice;

    private Long employee;

    private Instant receivingDate = Instant.now();

    private Boolean isEndOffice;

    private Long pac;
}
