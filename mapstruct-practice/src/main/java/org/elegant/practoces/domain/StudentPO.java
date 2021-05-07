package org.elegant.practoces.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/11/16
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentPO {

    private String id;

    private String name;

    private Integer age;

}
