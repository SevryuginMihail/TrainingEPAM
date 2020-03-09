package Sevryugin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum Rule{
    ADMIN,
    USER,
    MODERATOR
};
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String fio;
    private Rule rule;
}
