package org.joon.makefriends.Data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.joon.makefriends.MakeFriends;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataManager {

    public File PlayerListFolder;

    public void createFile() {
        PlayerListFolder = new File(MakeFriends.getInstance().getDataFolder(), "PlayerList");
        if(!PlayerListFolder.exists()) {
            PlayerListFolder.mkdirs();
        }
    }

    public void createPlayerFile(UUID uuid) {
        File file = new File(MakeFriends.getInstance().getDataFolder(), "PlayerList/" + uuid+ ".yml");
        if(!file.exists()) {
            YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
            List<String> friendsList = new ArrayList<String>();
            yml.set("player", uuid.toString());
            yml.set("friends", friendsList);
            try{
                yml.save(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public File loadPlayerFile(UUID uuid){
        return new File(MakeFriends.getInstance().getDataFolder(), "PlayerList/" + uuid+ ".yml");
    }
}
