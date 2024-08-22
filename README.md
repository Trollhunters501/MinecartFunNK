# MinecartFunNK
Adds very fun minecarts to Minecraft Nukkit!

This plugin adds minecarts that can move without tracks!

To spawn use the command:
```
/summon MinecartFun <playername>
```
## For Programmers:
use this plugin as a library

To get the entity the class is "org.CreadoresProgram.MinecartFunNK.entitys.EntityMinecartEmptyFun"

#### Maven:
the command to use the library:
```
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=foldersWhereIsTheJar/MinecartFunNK-1.0.0.jar
```
To use in maven:
```xml
<dependency>
  <groupId>org.creadoresprogram</groupId>
  <artifactId>MinecartFunNK</artifactId>
  <version>1.0.0</version>
  <scope>provided</scope>
</dependency>
```

# Credits:
Original code: https://github.com/iTXTech/Genisys/blob/0.15.0/src/pocketmine/entity/Minecart.php
