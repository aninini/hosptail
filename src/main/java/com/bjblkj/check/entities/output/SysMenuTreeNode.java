package com.bjblkj.check.entities.output;

import com.bjblkj.check.entities.SysMenuCase;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * <p> 菜单树节点 </p>
 *
 */
@Data
public class SysMenuTreeNode extends SysMenuCase {

    List<SysMenuTreeNode> children = Lists.newArrayList();

}
