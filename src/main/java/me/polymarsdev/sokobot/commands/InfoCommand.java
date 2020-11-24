package me.polymarsdev.sokobot.commands;

import me.polymarsdev.sokobot.Bot;
import me.polymarsdev.sokobot.entity.Command;
import me.polymarsdev.sokobot.event.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;

public class InfoCommand extends Command {

    public InfoCommand() {
        super("info");
    }

    @Override
    public void execute(CommandEvent event) {
        Bot.debug("Received info command (or bot mention)");
        Guild guild = event.getGuild();
        EmbedBuilder info = new EmbedBuilder();
        final String prefix = Bot.getPrefix(guild);
        info.setTitle("Sokobot");
        info.setThumbnail(guild.getSelfMember().getUser().getAvatarUrl());
        info.setDescription("Sokobot, kutuyu zorlayan klasik bulmaca oyunu Sokoban'ı oynamanıza izin veren bir bottur.");
        info.setColor(0xdd2e53);
        info.addField("Nasıl oynanır", "Sen bir **Sokoban'sın** :flushed:.\n Oklara basarak karakterini hareket ettirebilirsin **boxes** :brown_square: "
                + "onların üstüne **hedefler** :negative_squared_cross_mark:.", false);
        info.addField("Özellikleri", ":white_small_square:**Sonsoz leveller**\nMapler random olarak oluşturulur"
                + "ilerledikçe zorluk artar.\n:white_small_square:**Varied " + "controls"
                + "**\nSokobot oyuncunun deneyimini iyileştirmek için birden fazla kontrol seçeneğine sahiptir."
                + "tepkiler ve **WASD** \n:white_small_square:**Eşzamanlı oyunlar**\nGücü sayesinde "
                + "Java HashMaps:tm:, Birden fazla kullanıcı botu aynı anda, birine müdahale etmeden kullanabilir "
                + "bir diğeri.\n:white_small_square:**Özel prefixler**\nSokobot'un başkalarıyla çakışmasını önlemek için "
                + "botlar, yöneticiler Sokobot'un komutlarına önsöz vermek için herhangi bir tek karakterlik ön ek seçebilir.", false);
        info.addField(
                "Komutlar",
                ("``" + prefix + "play`` Şu anda bir oyunda değil iseniz " + "oyunu başlatmak için" + "kullanılır.\n``"
                        + prefix + "stop`` aktif oyununuzu istediğiniz zaman durdurmak için " + "kullanabilir.\n``" + prefix
                        + "info`` provides some useful details about the bot and " + "kuralları " + "oyun.\n``" + Bot
                        .getPrefix(guild) + "prefix [character]`` Kullanılabilir " + "prefixi ayarlar"
                        + "bot responds to."), false);
        info.addField(
                "Add to your server",
                "https://top.gg/bot/713635251703906336\nSokobot is currently in " + Bot.getShardManager().getGuilds()
                                                                                       .size() + " servers.", false);
        /*
        // Official Support Server
        info.addField("Support / Feedback",
        "Official Support Server: https://invite.affluentproductions.org/apserver", false);
         */
        info.addField("Source code", "...", false);
        info.setFooter("created by PolyMars | edited by best is real | google çeviri üzerinden çevrilmiştir hatalar olabilir", "https://avatars0.githubusercontent" + ".com/u/51007356?s=460&u"
                + "=4eb8fd498421a2eee9781edfbadf654386cf06c7&v=4");
        event.reply(info.build());
    }
}
