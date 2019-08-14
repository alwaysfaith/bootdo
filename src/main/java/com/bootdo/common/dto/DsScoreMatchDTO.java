package com.bootdo.common.dto;

import com.bootdo.common.domain.DsScoreMatchDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author : Caixin
 * @date 2019/8/14 9:29
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DsScoreMatchDTO implements Serializable {
    private static final long serialVersionUID = -3124435283087345444L;

    private Boolean flag;

    private List<DsScoreMatchDO> dsScoreMatchList;
}
