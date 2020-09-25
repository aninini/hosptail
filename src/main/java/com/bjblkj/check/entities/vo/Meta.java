package com.bjblkj.check.entities.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class Meta {

   private String title;

   private boolean keepAlive = new Boolean(false);

   private List<String> btnPermissions = Lists.newArrayList();

}
