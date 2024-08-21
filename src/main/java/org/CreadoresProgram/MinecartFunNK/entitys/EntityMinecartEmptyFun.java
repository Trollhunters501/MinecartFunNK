package org.CreadoresProgram.MinecartFunNK.entitys;
import cn.nukkit.entity.item.EntityMinecartEmpty;
import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.math.Vector3;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;
public class EntityMinecartEmptyFun extends EntityMinecartEmpty{
  private String entityName;
  public EntityMinecartEmptyFun(FullChunk chunk, CompoundTag nbt){
    super(chunk, nbt);
    setName("MinecartFun");
  }
  @Override
  public boolean onUpdate(int currentTik){
    if(this.closed){
      return false;
    }
    int tickDiff = currentTik - this.lastUpdate;
    if(tickDiff <= 1){
      return false;
    }
    boolean update = false;
    if(this.isAlive()){
      if(this.passengers == null) return super.onUpdate(currentTik);
      if(this.passengers.isEmpty()) return super.onUpdate(currentTik);
      if(this.passengers.size() > 1 || !(this.passengers.get(0) instanceof Player)) return super.onUpdate(currentTik);
      this.lastUpdate = currentTik;
      Player p = (Player) this.passengers.get(0);
      this.lastX = this.x;
      this.lastY = this.y;
      this.lastZ = this.z;
      this.motionX = -Math.sin(p.yaw / 180 * Math.PI);
      this.motionZ = Math.cos(p.yaw / 180 * Math.PI);
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
      double friction = (double) 1 - this.getDrag();
      if(onGround && (Math.abs(this.motionX) > 0.00001 || Math.abs(this.motionZ) > 0.00001)){
        friction = this.level.getBlock(new Vector3((int) Math.floor(this.x), (int) Math.floor(this.y - 1), ((int) Math.floor(this.z)) - 1)).getFrictionFactor() * friction;
      }
      this.motionX *= friction;
      this.motionY *= 1 - ((double) this.getDrag());
      this.motionZ *= friction;
      if(onGround){
        this.motionY *= -0.4;
      }
    }
    return update || !onGround || Math.abs(this.motionX) > 0.00001 || Math.abs(this.motionY) > 0.00001 || Math.abs(this.motionZ) > 0.00001;
  }

  @Override
  public String getInteractButtonText(){
    return this.passengers.isEmpty() ? "§a§lEnter the §9MinecartFun!" : "";
  }
  public void setName(String name){
    this.entityName = name;
  }
}
