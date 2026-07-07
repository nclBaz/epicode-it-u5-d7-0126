package riccardogulin.u5d7.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class UserPayload {
	// Attenzione a non confondere il payload con la rispettiva ENTITY
	// L'unico scopo di questa classe è quello di definire come saranno
	// fatti i payload in fase di creazione di un nuovo utente
	// In pratica deve contenere gli attributi presenti nel JSON che mi invierà
	// il client
	private String name;
	private String surname;
	private String email;
	private String password;
}
