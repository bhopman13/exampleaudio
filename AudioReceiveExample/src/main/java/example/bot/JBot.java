package example.bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class JBot {

	private String token = "";

	public static void main(String[] args) {
		new JBot();
	}

	public JBot() {
		try {
			JDA jda = JDABuilder.createDefault(token).addEventListeners(new Listener()).build();
		} catch (LoginException e) {
			//shame
		}

	}
}
