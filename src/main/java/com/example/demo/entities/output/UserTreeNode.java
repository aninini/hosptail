package com.example.demo.entities.output;

import com.example.demo.entities.UserCase;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * <p> 用户树节点 </p>
 *
 */
@Data
public class UserTreeNode extends UserCase {

    List<UserTreeNode> children = Lists.newArrayList();

}
