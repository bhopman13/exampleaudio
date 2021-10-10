package example.bot;

import net.dv8tion.jda.api.audio.AudioReceiveHandler;
import net.dv8tion.jda.api.audio.CombinedAudio;
import net.dv8tion.jda.api.audio.UserAudio;
import net.dv8tion.jda.api.entities.Guild;

public class AudioHandler implements AudioReceiveHandler {

	private Guild guild;
	public AudioHandler(Guild guild) {
		this.guild = guild;
	}
	
	//combined audio
	@Override
	public boolean canReceiveCombined() {
		//false if not needed
		return true;
	}
	
	//single user audio
	@Override
	public boolean canReceiveUser() {
		//false if not needed
		return true;
	}

	@Override
	public void handleCombinedAudio(CombinedAudio combinedAudio) {
		//after its joined leave it with you muted then unmute to see if it goes to 1 (if it does its getting your audio)
		System.out.println(combinedAudio.getUsers().size());
		//audio bytes come here
	}
	
	@Override
	public void handleUserAudio(UserAudio userAudio) {
		//single user audio bytes here
	}
	
}
