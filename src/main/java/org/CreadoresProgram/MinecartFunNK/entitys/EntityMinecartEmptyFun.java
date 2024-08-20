package org.CreadoresProgram.MinecartFunNK.entitys;
import cn.nukkit.entity.item.EntityMinecartEmpty;
import cn.nukkit.Player;
import cn.nukkit.math.MathHelper;
public class EntityMinecartEmptyFun extends EntityMinecartEmpty{
  @Override
  public boolean onUpdate(int currentTik){
    if(this.closed){
      return false;
    }
    boolean update = super.onUpdate(currentTik);
    if(this.isAlive()){
      if(this.passengers.get(0) == null || (!(this.passengers.get(0) instanceof Player) || this.passengers.size() > 1)) return false;
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      this.motionY -= 0.04;
      
    }
  }
}
