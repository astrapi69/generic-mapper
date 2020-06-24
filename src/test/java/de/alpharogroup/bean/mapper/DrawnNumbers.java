package de.alpharogroup.bean.mapper;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter @Setter @EqualsAndHashCode @ToString @NoArgsConstructor @AllArgsConstructor @Builder(toBuilder = true) @FieldDefaults(level = AccessLevel.PRIVATE) public class DrawnNumbers
{

	/**
	 * The point of time when this drawn has been made
	 */
	LocalDateTime drawnDate;

}
