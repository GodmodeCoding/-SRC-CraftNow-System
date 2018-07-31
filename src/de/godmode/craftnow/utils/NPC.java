package de.godmode.craftnow.utils;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.minecraft.server.v1_8_R3.PacketPlayOutEntity.PacketPlayOutEntityLook;
import net.minecraft.server.v1_8_R3.WorldSettings.EnumGamemode;

public class NPC implements Serializable {
   
   private static final long serialVersionUID = -672963264444438574L;
   private int entityID;
   private Location location;
   private GameProfile gameprofile;
   private Float health = 20F;
   
   public NPC(String name, Location location) {
      entityID = (int) Math.ceil(Math.random() * 1000) + 2000;
      gameprofile = new GameProfile(UUID.randomUUID(), name);
      this.location = location.clone();
   }
   
   public NPC(String name, Integer entityID, UUID uuid, Location location) {
      this.entityID = entityID;
      gameprofile = new GameProfile(uuid, name);
      this.location = location.clone();
   }
   
   public int getEntityID() {
      return entityID;
   }
   
   public String getName() {
      return gameprofile.getName();
   }
   
   public Float getHealth() {
      return health;
   }
   
   public void setHealth(Float health) {
      this.health = health;
   }
   
   public Location getLocation() {
      return location;
   }
   
   public void setSkin(String name) {
      
      try {
   
         String value = "";
         String signatur = "";
         
        File file = new File ( "plugins//NPCS//" + name + ".yml" );
         YamlConfiguration cfg = YamlConfiguration.loadConfiguration ( file );
         
         if(!file.exists ()){
   
            Gson gson = new Gson();
            String url = "https://api.mojang.com/users/profiles/minecraft/" + name;
            String json = getStringFromURL(url);
            String uuid = gson.fromJson(json, JsonObject.class).get("id").getAsString();
   
            url = "https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false";
            json = getStringFromURL(url);
            JsonObject mainObject = gson.fromJson(json, JsonObject.class);
            JsonObject jObject = mainObject.get("properties").getAsJsonArray().get(0).getAsJsonObject();
            value = jObject.get("value").getAsString();
            signatur = jObject.get("signature").getAsString();
            
            cfg.set ( "value" , value );
            cfg.set ( "signature" , signatur );
            
            cfg.save ( file );
            
         }else {
            
            value = cfg.getString ( "value" );
            signatur = cfg.getString ( "signature" );
            
         }
   
         if(value == ""){
      
            value = "eyJ0aW1lc3RhbXAiOjE1MTgwMjM5Nzk0NjUsInByb2ZpbGVJZCI6IjcxMjdjYTdiNmZhZDQwNDc4ODdjZjgyMjE2NzFjMDhhIiwicHJvZmlsZU5hbWUiOiJmcGhpbCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYyMTI0ZTg2NDZjZGQxZmVlNTYwMzY5YWM4MmQzYmE4NGIyMTE5NGU3OTFlMjgxNjk5M2M2OGU4Y2E3YzkxIiwibWV0YWRhdGEiOnsibW9kZWwiOiJzbGltIn19fX0=";
            signatur = "yX9ZaOAKtQoFxgQJXUB3k6od1aXkah7/1CjUZ5zyC9d1HAPge9BCsn0BpU+LkixDMbNGzxRaHO9E5lNW9vr4o4JfbLPrt27/5b6WYnumTJPImSxWdA88lmmr0rZlmeyvPn3eBvsCw6JVBFG7slyv0fqvDRHufgBmx9ppULFfuNUH53b9rR1vm1pm4zfzSM/bW3k/1BuSElTDorP0It98RIGU19ajHfJNWfHIO42q/bRP9Ay5o7SSiIWAeAhRkWyjimznJhgxT4ghqW2E/OhfnvDxkWs2ihXkAVqPgL/9gBQREys3JAzFbO7/MOD8FGtwIsD7Xj481hsPJ10lj6FAEmCaQN9kaIE5hYWXepOztSCe9R1FCYApSpuHSRWtsTh65Od5QF/cWqk2clWEe+GFM39Y1N+kvNszRYHo34UHn+jvJb8VYIMzNYMHf90uMDmEu1RlXSHfHtMgNu82POvAese/GEmnWnwExguIyKYCrzRUZ7caGsmLXouWQV3NWUETBXqBio5R/nmWAvBa4ksn981mEZ2NUg8rBb+9RsTHFW97dvfcJkkmZ00YgXRJs39A7nv7p2FGrnAlUq4XMAcUxEMXCNb8CE+aT12kMQA5j3VQiwHoeZ/dWAc+0uU5W/hEND48JAxuMktBerTmN55Vvi6LRAn2ySnGcutKuENHfes=";
      
         }
   
         gameprofile.getProperties().put("textures", new Property("textures", value, signatur));
         
      } catch ( IOException e ) {
         Bukkit.getConsoleSender ().sendMessage ( "�cFILE FEHLER" );
      }catch ( Exception ignore ){
      
      }
   }
   
   public void animation(int animation) {
      PacketPlayOutAnimation packet = new PacketPlayOutAnimation();
      setValue(packet, "a", entityID);
      setValue(packet, "b", (byte) animation);
      sendPacket(packet);
   }
   
   public void status(int status) {
      PacketPlayOutEntityStatus packet = new PacketPlayOutEntityStatus();
      setValue(packet, "a", entityID);
      setValue(packet, "b", (byte) status);
      sendPacket(packet);
   }
   
   /*
   public void equip( Slot slot, ItemStack itemstack) {
      PacketPlayOutEntityEquipment packet = new PacketPlayOutEntityEquipment();
      setValue(packet, "a", entityID);
      setValue(packet, "b", slot.getSlot());
      setValue(packet, "c", itemstack);
      sendPacket(packet);
   }
    */
   
   @SuppressWarnings("deprecation")
   public void sleep(boolean state) {
      if (state) {
         Location bedLocation = new Location(location.getWorld(), 1, 1, 1);
         PacketPlayOutBed packet = new PacketPlayOutBed();
         setValue(packet, "a", entityID);
         setValue(packet, "b", new BlockPosition(bedLocation.getX(), bedLocation.getY(), bedLocation.getZ()));
         
         for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendBlockChange(bedLocation, Material.BED_BLOCK, (byte) 0);
         }
         
         sendPacket(packet);
         teleport(location.clone().add(0, 0.3, 0));
      } else {
         animation(2);
         teleport(location.clone().subtract(0, 0.3, 0));
      }
   }
   
   public void spawn() {
      PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();
      setValue(packet, "a", entityID);
      setValue(packet, "b", gameprofile.getId());
      setValue(packet, "c", getFixLocation(location.getX()));
      setValue(packet, "d", getFixLocation(location.getY()));
      setValue(packet, "e", getFixLocation(location.getZ()));
      setValue(packet, "f", getFixRotation(location.getYaw()));
      setValue(packet, "g", getFixRotation(location.getPitch()));
      setValue(packet, "h", 0);
      DataWatcher w = new DataWatcher(null);
      w.a(6, health);
      addToTablist();
      w.a(10, (byte) 127);
      setValue(packet, "i", w);
      sendPacket(packet);
      headRotation(location.getYaw(), location.getPitch());
   }
   
   public void spawn(Player player) {
      PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();
      setValue(packet, "a", entityID);
      setValue(packet, "b", gameprofile.getId());
      setValue(packet, "c", getFixLocation(location.getX()));
      setValue(packet, "d", getFixLocation(location.getY()));
      setValue(packet, "e", getFixLocation(location.getZ()));
      setValue(packet, "f", getFixRotation(location.getYaw()));
      setValue(packet, "g", getFixRotation(location.getPitch()));
      setValue(packet, "h", 0);
      DataWatcher w = new DataWatcher(null);
      w.a(6, health);
      addToTablist();
      w.a(10, (byte) 127);
      setValue(packet, "i", w);
      sendPacket(packet, player);
      headRotation(location.getYaw(), location.getPitch());
   }
   
   public void teleport(Location location) {
      PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport();
      setValue(packet, "a", entityID);
      setValue(packet, "b", getFixLocation(location.getX()));
      setValue(packet, "c", getFixLocation(location.getY()));
      setValue(packet, "d", getFixLocation(location.getZ()));
      setValue(packet, "e", getFixRotation(location.getYaw()));
      setValue(packet, "f", getFixRotation(location.getPitch()));
      
      sendPacket(packet);
      headRotation(location.getYaw(), location.getPitch());
      this.location = location.clone();
   }
   
   public void headRotation(float yaw, float pitch) {
      PacketPlayOutEntityLook packet = new PacketPlayOutEntityLook(entityID, getFixRotation(yaw),
         getFixRotation(pitch), true);
      PacketPlayOutEntityHeadRotation packetHead = new PacketPlayOutEntityHeadRotation();
      setValue(packetHead, "a", entityID);
      setValue(packetHead, "b", getFixRotation(yaw));
      
      sendPacket(packet);
      sendPacket(packetHead);
      
      this.location.setYaw(yaw);
      this.location.setPitch(pitch);
   }
   
   public void headRotation(Location location) {
      headRotation(location.getYaw(), location.getPitch());
   }
   
   public void destroy() {
      PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { entityID });
      removeFromTablist();
      sendPacket(packet);
   }
   
   public void destroy(Player player) {
      PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[] { entityID });
      removeFromTablist();
      sendPacket(packet, player);
   }
   
   public void addToTablist() {
      PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
      PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET,
         CraftChatMessage.fromString(gameprofile.getName())[0]);
      @SuppressWarnings("unchecked")
      List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(
         packet, "b");
      players.add(data);
      
      setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER);
      setValue(packet, "b", players);
      sendPacket(packet);
   }
   
   public void removeFromTablist() {
      PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
      PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET,
         CraftChatMessage.fromString(gameprofile.getName())[0]);
      @SuppressWarnings("unchecked")
      List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(
         packet, "b");
      players.add(data);
      setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
      setValue(packet, "b", players);
      
      sendPacket(packet);
   }
   
   public void removeFromTablist(Player player) {
      PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();
      PacketPlayOutPlayerInfo.PlayerInfoData data = packet.new PlayerInfoData(gameprofile, 1, EnumGamemode.NOT_SET,
         CraftChatMessage.fromString(gameprofile.getName())[0]);
      @SuppressWarnings("unchecked")
      List<PacketPlayOutPlayerInfo.PlayerInfoData> players = (List<PacketPlayOutPlayerInfo.PlayerInfoData>) getValue(
         packet, "b");
      players.add(data);
      setValue(packet, "a", PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER);
      setValue(packet, "b", players);
      
      sendPacket(packet, player);
   }
   
   private int getFixLocation(double pos) {
      return (int) MathHelper.floor(pos * 32.0D);
   }
   
   private byte getFixRotation(float yawpitch) {
      return (byte) ((int) (yawpitch * 256.0F / 360.0F));
   }
   
   private void setValue(Object obj, String name, Object value) {
      try {
         Field field = obj.getClass().getDeclaredField(name);
         field.setAccessible(true);
         field.set(obj, value);
      } catch (Exception e) {
      }
   }
   
   private Object getValue(Object obj, String name) {
      try {
         Field field = obj.getClass().getDeclaredField(name);
         field.setAccessible(true);
         return field.get(obj);
      } catch (Exception e) {
      }
      return null;
   }
   
   private void sendPacket(Packet<?> packet, Player player) {
      ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
   }
   
   private void sendPacket(Packet<?> packet) {
      for (Player player : Bukkit.getOnlinePlayers()) {
         sendPacket(packet, player);
      }
   }
   
   private String getStringFromURL(String url) {
      String text = "";
      try {
         Scanner scanner = new Scanner(new URL(url).openStream());
         while (scanner.hasNext()) {
            String line = scanner.nextLine();
            while (line.startsWith(" ")) {
               line = line.substring(1);
            }
            text = text + line;
         }
         scanner.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return text;
   }
   
   public HashMap<String, Object> encode() {
      HashMap<String, Object> map = new HashMap<>();
      
      // LOC
      map.put("X", location.getX());
      map.put("Y", location.getY());
      map.put("Z", location.getZ());
      map.put("Pitch", location.getPitch());
      map.put("Yaw", location.getYaw());
      map.put("World", location.getWorld().getName());
      
      // DATA
      map.put("name", gameprofile.getName());
      map.put("entityID", entityID);
      map.put("UUID", gameprofile.getId());
      map.put("health", health);
      
      // GAMEPROFILE
      String value = "";
      String signatur = "";
      for (Property property : gameprofile.getProperties().get("textures")) {
         value = property.getValue();
         signatur = property.getSignature();
      }
      map.put("value", value);
      map.put("signatur", signatur);
      
      return map;
   }
   
   public static NPC decode(HashMap<String, Object> map) {
      String name = (String) map.get("name");
      Integer entityID = (Integer) map.get("entityID");
      UUID uuid = (UUID) map.get("UUID");
      
      World world = Bukkit.getWorld((String) map.get("World"));
      Double x = (Double) map.get("X");
      Double y = (Double) map.get("Y");
      Double z = (Double) map.get("Z");
      Float pitch = (Float) map.get("Pitch");
      Float yaw = (Float) map.get("Yaw");
      Location location = new Location(world, x, y, z, yaw, pitch);
      
      NPC npc = new NPC(name, entityID, uuid, location);
      npc.health = (Float) map.get("health");
      String value = (String) map.get("value");
      String signatur = (String) map.get("signatur");
      npc.gameprofile.getProperties().put("textures", new Property("textures", value, signatur));
      return npc;
   }
   
   public String toString() {
      return encode().toString();
   }

}
