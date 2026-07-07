package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.*;

@RestController // @RestController != @Controller
// MEGLIO USARE @RESTCONTROLLER!
// Entrambe sono delle specializzazioni di @Component quindi si integrano nei meccanismi già noti di Spring
// Ogni metodo del controller corrisponderà ad un endpoint differente
@RequestMapping("/examples") // Serve per dare un prefisso comune a tutti gli endpoint di questo controller
public class ExampleController {

	@GetMapping // GET http://localhost:3001/examples
	public String getExample() {
		return "La risposta arriva dall'endpoint GET http://localhost:3001/examples";
	}

	@PostMapping // POST http://localhost:3001/examples
	public String postExample() {
		return "La risposta arriva dall'endpoint POST http://localhost:3001/examples";
	}

	@PutMapping // PUT http://localhost:3001/examples
	public String putExample() {
		return "La risposta arriva dall'endpoint PUT http://localhost:3001/examples";
	}

	@GetMapping("/getExample") // Nelle parentesi tonde posso definire la parte finale dell'URL (cioè la parte dopo il prefisso comune "/examples")
	public String getExample2() {
		return "La risposta arriva dall'endpoint GET http://localhost:3001/examples/getExample";
	}

	@PostMapping("/postExample")
	public String postExample2() {
		return "La risposta arriva dall'endpoint POST http://localhost:3001/examples/postExample";
	}

	@PatchMapping("/patchExample")
	public String patchExample() {
		return "La risposta arriva dall'endpoint PATCH http://localhost:3001/examples/patchExample";
	}

	// ***************************************************** QUERY PARAMETERS ***********************************************************************
	@GetMapping("/queryParamsExample")
	// GET http://localhost:3001/examples/queryParamsExample?name=Andrea&age=20
	// GET http://localhost:3001/examples/queryParamsExample?name=Alessia&age=21
	// Quando uso l'annotazione @RequestParam, i parametri sono OBBLIGATORI (otterrò una BadRequest come risposta se non li passo)
	// Se in @RequestParam metto required = false, il parametro non sarà più obbligatorio (però otterò null quando non verrà passato)

	// Attenzione che i parametri se non passati avranno valore NULL, con tutte le conseguenze del caso (es. NullPointerException)
	// Quindi o faccio dei controlli con if() oppure posso sfruttare i defaultValue per i parametri in maniera da non avere mai null
	public String queryParamsExample(@RequestParam(defaultValue = "nome_default") String name, @RequestParam(required = false) Integer age) {
		return "name: " + name.toUpperCase() + ", age: " + age;
	}

}
