package de.alpharogroup.bean.mapper;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @EqualsAndHashCode @ToString @NoArgsConstructor @AllArgsConstructor @Builder(toBuilder = true) @FieldDefaults(level = AccessLevel.PRIVATE) public class DrawnNumbers
{

	UUID id;

	LocalDateTime drawnDate;

}
