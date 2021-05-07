package org.elegant.practice.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuyk
 * @Description:
 * @Date: 2020/6/10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Message {

    private Long messageId;

    private String content;

}
