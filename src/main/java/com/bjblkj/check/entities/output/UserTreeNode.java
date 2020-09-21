package com.bjblkj.check.entities.output;

import com.bjblkj.check.entities.UserCase;
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
