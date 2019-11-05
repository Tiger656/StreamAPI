package by.courses.java.streamapi.operation;

import by.courses.java.streamapi.entity.UserBase;

import java.util.Collection;
import java.util.stream.Collectors;

public class DefaultStream implements Operation<UserBase> {

    @Override
    public Collection<UserBase> removeWithMaxAge(Collection<UserBase> entities) {
        return entities.stream().filter(user -> user.getAge() < (entities.stream().map(UserBase::getAge).mapToInt(v -> v).max().getAsInt())).collect(Collectors.toList());
    }

    @Override
    public Collection<UserBase> removeAllOlder(Collection<UserBase> entities, int age) {
        return entities.stream().filter(user -> user.getAge() <= age).collect(Collectors.toList());
    }

    @Override
    public double getAverageAge(Collection<UserBase> entities) {
        return entities.stream().map(UserBase::getAge).mapToInt(v -> v).average().getAsDouble();
    }

    @Override
    public UserBase getThirdInCollection(Collection<UserBase> entities) {
        return entities.stream().skip(2).findFirst().get();
    }

    @Override
    public Collection<UserBase> getTwoUsersStartingFromSecond(Collection<UserBase> entities) {
        return entities.stream().skip(1).limit(2).collect(Collectors.toList());
    }

    @Override
    public boolean isCharacterPresentInAllNames(Collection<UserBase> entities, String character) {
        return entities.stream().allMatch(person -> person.getName().toLowerCase().contains(character.toLowerCase()));
    }

    @Override
    public Collection<UserBase> addValueToAllNames(Collection<UserBase> entities, String value) {
        return entities.stream().peek(person -> person.setName(person.getName() + value)).collect(Collectors.toList());
    }

    @Override
    public Collection<UserBase> sortByNameThanByAge(Collection<UserBase> entities) {
        return entities.stream().sorted((p1, p2) ->
                p1.getName() != p2.getName() ? p1.getName().compareTo(p2.getName()) :
                        p1.getAge().compareTo(p2.getAge())).collect(Collectors.toList());
    }
}
