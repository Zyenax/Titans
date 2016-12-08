package net.Zyenax.Titans;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Team.Option;
import org.bukkit.scoreboard.Team.OptionStatus;

public class PlayerJoin implements Listener {

    @SuppressWarnings("unused")
    private Main plugin;

    public PlayerJoin(Main listener) {
        this.plugin = listener;
    }

    @SuppressWarnings("deprecation")
    private static void setTag(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = board.getTeam(player.getName());
        if (team == null) {
            team = board.registerNewTeam(player.getName());
        }
        team.setOption(Option.COLLISION_RULE, OptionStatus.NEVER);
        team.addPlayer(player);
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(board);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        setTag(event.getPlayer());
    }

}
