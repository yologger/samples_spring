package com.yologger.project.repository.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NationCountDTO {
    private String nation;
    private Long count;

    @Builder
    public NationCountDTO(String nation, Long count) {
        this.nation = nation;
        this.count = count;
    }
}
