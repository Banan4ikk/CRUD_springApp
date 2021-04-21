package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int peopleCount = 0;
     private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++peopleCount,"Tom",20,"Tom@gmail.com"));
        people.add(new Person(++peopleCount,"Bob",18,"Bob@gmail.com"));
        people.add(new Person(++peopleCount,"James",21,"james@gmail.com"));
        people.add(new Person(++peopleCount,"Cat",16,"Cat@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++peopleCount);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToUpdate = show(id);

        personToUpdate.setName(updatedPerson.getName());
        personToUpdate.setAge(updatedPerson.getAge());
        personToUpdate.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
     people.removeIf( p-> p.getId()==id);
    }
}
