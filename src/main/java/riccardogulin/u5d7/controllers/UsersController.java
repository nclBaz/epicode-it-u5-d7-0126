package riccardogulin.u5d7.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.payloads.UserPayload;
import riccardogulin.u5d7.services.UsersService;

import java.util.List;


// ********************************************** USERS CRUD ************************************************

/*

1. GET http://localhost:PORT/users --> 200 OK array di utenti nel payload
2. POST http://localhost:PORT/users (+payload) --> 201 CREATED con utente appena creato (o solo id)
3. GET http://localhost:PORT/users/{userId} --> 200 OK - con utente trovato (se non lo trovo 404 ma lo vedremo domani)
4. PUT http://localhost:PORT/users/{userId} (+payload) --> 200 OK - con utente aggiornato (se non lo trovo 404 ma lo vedremo domani)
5. DELETE http://localhost:PORT/users/{userId} --> 204 NO CONTENT (se non lo trovo 404 ma lo vedremo domani)

*/

@RestController
@RequestMapping("/users")
public class UsersController {

	private final UsersService usersService;

	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	// 1. GET http://localhost:PORT/users --> 200 OK array di utenti nel payload
	@GetMapping
	public List<User> findAll() {
		return this.usersService.findAll();
	}


	// 2. POST http://localhost:PORT/users (+payload) --> 201 CREATED con utente appena creato (o solo id)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) // 201 al posto del 200
	public User createUser(@RequestBody UserPayload body) {
		return this.usersService.saveUser(body);
	}

	// 3. GET http://localhost:PORT/users/{userId} --> 200 OK - con utente trovato (se non lo trovo 404 ma lo vedremo domani)
	@GetMapping("/{userId}")
	public User findById(@PathVariable long userId) {
		return this.usersService.findById(userId);
	}


	// 4. PUT http://localhost:PORT/users/{userId} (+payload) --> 200 OK - con utente aggiornato (se non lo trovo 404 ma lo vedremo domani)
	@PutMapping("/{userId}")
	public User findByIdAndUpdate(@PathVariable long userId, @RequestBody UserPayload body) {
		return this.usersService.findByIdAndUpdate(userId, body);
	}


	// 5. DELETE http://localhost:PORT/users/{userId} --> 204 NO CONTENT (se non lo trovo 404 ma lo vedremo domani)
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT) // 204 al posto di 200
	public void findByIdAndDelete(@PathVariable long userId) {
		this.usersService.findByIdAndDelete(userId);
	}
}
