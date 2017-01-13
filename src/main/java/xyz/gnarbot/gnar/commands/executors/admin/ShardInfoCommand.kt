package xyz.gnarbot.gnar.commands.executors.admin

import net.dv8tion.jda.core.EmbedBuilder
import xyz.gnarbot.gnar.Bot
import xyz.gnarbot.gnar.commands.handlers.*
import xyz.gnarbot.gnar.members.Clearance
import xyz.gnarbot.gnar.utils.Note
import java.util.StringJoiner

@Command(
        aliases = arrayOf("shards", "shard", "shardinfo"),
        description = "Get shard information.",
        clearance = Clearance.BOT_MASTER,
        showInHelp = false
)
class ShardInfoCommand : CommandExecutor()
{
    override fun execute(message : Note, label : String, args : Array<String>)
    {
        val eb = EmbedBuilder()
        
        repeat(Bot.shards.size / 2 + 1)
        {
            val sj = StringJoiner("\n")
    
            Bot.shards.forEach {
                sj.add("__**Shard ${it.id}                                                       **__")
                sj.add("  Status: **[${it.jda.status}]()**")
                sj.add("  Hosts: **[${it.jda.guilds.size}]()**")
            }
            
            eb.addField("", sj.toString(), true)
        }
        
        message.channel.sendMessage(eb.build())
    }
}