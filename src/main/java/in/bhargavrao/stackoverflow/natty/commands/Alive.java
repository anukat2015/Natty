package in.bhargavrao.stackoverflow.natty.commands;

import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.event.PingMessageEvent;
import in.bhargavrao.stackoverflow.natty.utils.CommandUtils;

/**
 * Created by bhargav.h on 30-Sep-16.
 */
public class Alive implements SpecialCommand {


    private PingMessageEvent event;
    private String message;

    public Alive(PingMessageEvent event) {
        this.event = event;
        this.message = event.getMessage().getPlainContent();
    }

    @Override
    public boolean validate() {
        return CommandUtils.checkForCommand(message,"alive");
    }

    @Override
    public void execute(Room room) {
        room.replyTo(event.getMessage().getId(), "Nope");
    }

    @Override
    public String description() {
        return "Returns a test reply to inform that the bot is alive";
    }

    @Override
    public String name() {
        return "alive";
    }
}
