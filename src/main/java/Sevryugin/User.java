package Sevryugin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO класс User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String fio;
    private Rule rule;
}
