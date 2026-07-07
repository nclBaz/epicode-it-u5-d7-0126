package riccardogulin.u5d7.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.exceptions.NotFoundException;
import riccardogulin.u5d7.payloads.UserPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsersService {
	private List<User> usersDB = new ArrayList<>();

	public List<User> findAll() {
		return this.usersDB;
	}

	public User saveUser(UserPayload body) {
		// TODO: Validare i campi
		User newUser = new User(body.getName(), body.getSurname(), body.getEmail(), body.getPassword());
		this.usersDB.add(newUser);
		log.info("L'utente " + newUser.getId() + " è stato creato");
		return newUser;
	}

	public User findById(long userId) {
		User found = null;

		for (User user : this.usersDB) {
			if (user.getId() == userId) found = user;
		}

		if (found == null) throw new NotFoundException(userId);

		return found;
	}

	public User findByIdAndUpdate(long userId, UserPayload body) {
		User found = null;

		for (User user : this.usersDB) {
			if (user.getId() == userId) {
				found = user;
				found.setName(body.getName());
				found.setSurname(body.getSurname());
				found.setEmail(body.getEmail());
				found.setPassword(body.getPassword());
			}
		}

		if (found == null) throw new NotFoundException(userId);

		return found;
	}

	public void findByIdAndDelete(long userId) {
		User found = null;

		for (User user : this.usersDB) {
			if (user.getId() == userId) found = user;
		}

		if (found == null) throw new NotFoundException(userId);

		this.usersDB.remove(found);
	}
}
