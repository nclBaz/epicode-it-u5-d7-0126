package riccardogulin.u5d7.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
@ToString
public class User {
	private long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String avatarURL;
	private LocalDateTime createdAt;

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.createdAt = LocalDateTime.now();
		Random random = new Random();
		this.id = random.nextInt(1, 10000);
		this.avatarURL = "https://picsum.photos/200/300";
	}
}
