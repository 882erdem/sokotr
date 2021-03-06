package me.polymarsdev.sokobot.commands;

import me.polymarsdev.sokobot.Bot;
import me.polymarsdev.sokobot.entity.Command;
import me.polymarsdev.sokobot.event.CommandEvent;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

public class PrefixCommand extends Command {

    public PrefixCommand() {
        super("prefix");
    }

    @Override
    public void execute(CommandEvent event) {
        User user = event.getAuthor();
        Member member = event.getMember();
        String[] args = event.getArgs();
        Guild guild = event.getGuild();
        Bot.debug("Received prefix command: " + event.getMessage().getContentRaw());
        if (args.length > 0) {
            if (!member.hasPermission(Permission.ADMINISTRATOR)) {
                Bot.debug("Failed to change prefix of " + guild.getName() + " (" + guild.getId()
                                  + "): Yetersiz yetkiler");
                event.reply(user.getAsMention() + ", bu komutu kullanma izniniz yok.");
                return;
            }
            String newPrefix = args[0].toLowerCase();
            if (newPrefix.length() > 1) {
                Bot.debug("Failed to change prefix of " + guild.getName() + " (" + guild.getId() + "): length");
                event.reply(user.getAsMention() + ", the prefix must be one character long!");
                return;
            }
            Bot.setPrefix(guild, newPrefix);
            Bot.debug("Successfully changed server prefix of " + guild.getName() + " (" + guild.getId() + ") to: "
                              + newPrefix);
            event.reply("Önek başarıyla değiştirildi ``" + newPrefix + "``.");
            return;
        }
        event.reply(user.getAsMention() + ", please use `" + Bot.getPrefix(guild)
                            + "bir sunucu öneki ayarlamak için lütfen <yeni önek> `önekini kullanın.");
    }
}
