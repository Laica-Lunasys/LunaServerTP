package net.shiroumi.spigot.bungeecord;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageRecipient;

public class LunaServerTP extends JavaPlugin
{
  private static final Logger log = Logger.getLogger("Minecraft");
  private LunaServerTP plugin;
  public static String server;

  //起動//
  public void onEnable()
  {
	  /*プラグインファイルからプラグイン名を取得する
	  / + pdfFile.getName() + をメッセージの中に含ませると、
	  プラグイン名をプレフィクスとして利用可能。*/
	  
    PluginDescriptionFile pdfFile = getDescription();

    this.plugin = this;
    
    // Config生成のテスト//
    /*    File file = new File(getDataFolder() + File.separator + "config.yml");

   if (!file.exists()) {
      log.info("[" + pdfFile.getName() + "]" + " Generating config.yml...");

      getConfig().options().copyDefaults(true);
      saveConfig();
      

     Config生成完了のメッセージ > log.info("[" + pdfFile.getName() + "]" + " Config.yml generated!");
    } */
    log.info("[" + pdfFile.getName() + "]" + " has been enabled!");
    
  }

  //停止//
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();

    log.info("[" + pdfFile.getName() + "]" + " has been disabled!");
  }

  public void LunaServerTPMessageListener(LunaServerTP plugin)
  {
    this.plugin = plugin;
  }

  public boolean onCommand1(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (commandLabel.equalsIgnoreCase("svtp"))
    {
      //未使用に付きコメント PluginDescriptionFile pdfFile = getDescription();
      if (args.length != 1)
      {
       
      }
      else if ((sender instanceof Player))
      {
        if (sender.hasPermission("lunasvtp.tp"))
        {
          server = args[0];
          sender.sendMessage(ChatColor.GRAY + "接続中...");
          
//sender.sendMessage(ChatColor.GOLD + "[" + pdfFile.getName() + "] " + "Sending to " + server + ".");//
          
          Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

          ByteArrayOutputStream b = new ByteArrayOutputStream();
          DataOutputStream out = new DataOutputStream(b);
          try
          {
            out.writeUTF("Connect");
            out.writeUTF(server);
          }
          
          catch (IOException localIOException)
          {
          }

          ((PluginMessageRecipient)sender).sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
        }
        else
        {
          sender.sendMessage(ChatColor.RED + "You do not have permission.");
        }
      } else
		sender.sendMessage(ChatColor.RED + "You do not have permission.");
    }
	return true;}
  
    
    public boolean onCommand2(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
      if (commandLabel.equalsIgnoreCase("svtp"))
      {
        //未使用に付きコメント PluginDescriptionFile pdfFile = getDescription();
        {
         
        }}
      
        else if ((sender instanceof Player))
        {
            server = args[0];
            sender.sendMessage(ChatColor.RED + "引数がたりません！ /svtp サーバー名");
            

  }
	return true;
	}}