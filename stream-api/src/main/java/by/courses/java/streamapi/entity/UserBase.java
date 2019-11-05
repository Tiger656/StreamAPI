package by.courses.java.streamapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor(staticName = "of")
public class UserBase {

    private String name;

    private Integer age;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBase person = (UserBase) o;
        return age.equals(person.age) &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
