package riccardogulin.u5d7.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class NewProductResponsePayload {
	private int id;
	private String name;
	private double price;
	private String description;
	private LocalDateTime createdAt;
}
