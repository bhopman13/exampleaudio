package example.bot;


import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

	public Listener() {

	}

	@Override
	public void onReady(ReadyEvent event) {
		event.getJDA().getGuilds().forEach((guild) -> {
			try {
				guild.getAudioManager().setReceivingHandler(new AudioHandler(guild));
				System.out.println(guild.getAudioManager().getReceivingHandler().canReceiveCombined());
			} catch (Exception ignore) {
			}
		});
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getMessage().getContentRaw().equals("!join")) {
			connect(event.getMessage().getMember().getVoiceState().getChannel());
		}
	}
	
	private void connect(VoiceChannel c) {
		c.getGuild().getAudioManager().openAudioConnection(c);
	}

}
