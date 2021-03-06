package xyz.gnarbot.gnar.db;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import xyz.gnarbot.gnar.Bot;
import xyz.gnarbot.gnar.db.guilds.GuildData;
import xyz.gnarbot.gnar.db.guilds.UserData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OptionsRegistry {
    private final Bot bot;

    public OptionsRegistry(Bot bot) {
        this.bot = bot;
    }

    @Nonnull
    public GuildData ofGuild(Guild guild) { // causing errors for some reason
        GuildData data = bot.db().getGuildData(guild.getId());
        return data == null ? new GuildData(guild.getId()) : data;
    }

    @Nullable
    public GuildData ofGuild(long id) {
        Guild guild = bot.getGuildById(id);
        return guild == null ? null : ofGuild(guild);
    }

    @Nonnull
    public UserData ofUser(User user) {
        UserData data = bot.db().getUserData(user.getId());
        return data == null ? new UserData(user.getId()) : data;
    }

    @Nullable
    public UserData ofUser(String id) {
        User user = bot.getUserById(id);
        return user == null ? null : ofUser(user);
    }
}
