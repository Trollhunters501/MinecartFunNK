package org.CreadoresProgram.MinecartFunNK;
import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import org.CreadoresProgram.MinecartFunNK.entitys.EntityMinecartEmptyFun;
import cn.nukkit.entity.Entity;
public class Main extends PluginBase{
  @Override
  public void onEnable(){
    this.getLogger().info("§aDone!");
  }
  @Override
  public void onLoad(){
    this.getLogger().info("§eLoading...");
    Entity.registerEntity("MinecartFun", EntityMinecartEmptyFun.class);
  }
}
