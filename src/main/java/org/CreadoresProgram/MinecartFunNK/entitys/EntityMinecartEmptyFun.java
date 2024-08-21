package org.CreadoresProgram.MinecartFunNK.entitys;
import cn.nukkit.entity.item.EntityMinecartEmpty;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.math.Vector3;
public class EntityMinecartEmptyFun extends EntityMinecartEmpty{
  @Override
  public boolean onUpdate(int currentTik){
    if(this.closed){
      return false;
    }
    boolean update = super.onUpdate(currentTik);
    if(this.isAlive()){
      if(this.passengers.get(0) == null || (!(this.passengers.get(0) instanceof Player) || this.passengers.size() > 1)) return false;
      Player p = (Player) this.passengers.get(0);
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      this.motionX = -Math.sin(p.getPosition().getYaw() / 180 * Math.PI);
      this.motionZ = Math.cos(p.getPosition().getYaw() / 180 * Math.PI);
      Block target = this.level.getBlock(this.add(this.motionX, 0, this.motionZ).round());
      Block target2 = this.level.getBlock(this.add(this.motionX, 0, this.motionZ).floor());
      if(target.getId() != 0 || target2.getId() != 0){ 
        this.motionY = 0.4 * 3;
      }else{
        this.motionY -= 0.4;
      }
      if(this.checkObstruction(this.x, this.y, this.z)){
        update = true;
      }
      move(this.motionX, this.motionY, this.motionZ);
      this.updateMovement();
      float friction = 1 - this.getDrag();
      if(onGround && (Math.abs(this.motionZ) > 0.00001 || Math.abs(this.motionZ) > 0.00001)){
        friction = this.level.getBlock(new Vector3((int) Math.floor(this.x), (int) Math.floor(this.y - 1), ((int) Math.floor(this.z)) - 1)).getFrictionFactor() * friction;
      }
      this.motionX *= friction;
      this.motionY *= 1 - this.getDrag();
      this.motionZ *= friction;
      if(onGround){
        this.motionY *= -0.5;
      }
    }
    return update || !onGround || Math.abs(this.motionX) > 0.00001 || Math.abs(this.motionY) > 0.00001 || Math.abs(this.motionZ) > 0.00001;
  }
}
