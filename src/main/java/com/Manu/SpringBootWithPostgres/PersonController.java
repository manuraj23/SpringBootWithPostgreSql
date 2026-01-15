package com.Manu.SpringBootWithPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepo personRepo;

    // ===================== save() =====================
    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return ResponseEntity.ok(personRepo.save(person));
    }

    // ===================== saveAll() – RequestBody =====================
    @PostMapping("/addAll")
    public ResponseEntity<List<Person>> addAllPersons(@RequestBody List<Person> persons) {
        return ResponseEntity.ok(personRepo.saveAll(persons));
    }

    // ===================== saveAll() – PathVariable =====================
    // POST /person/addByPath/Manu,Raj,Ankit
    @PostMapping("/addByPath/{names}")
    public ResponseEntity<List<Person>> addByPath(@PathVariable List<String> names) {

        List<Person> persons = names.stream()
                .map(n -> {
                    Person p = new Person();
                    p.setName(n);
                    p.setEmail(n.toLowerCase() + "@gmail.com");
                    return p;
                })
                .toList();

        return ResponseEntity.ok(personRepo.saveAll(persons));
    }

    // ===================== saveAll() – RequestParam =====================
    // POST /person/addByParam?name=Manu&name=Raj
    @PostMapping("/addByParam")
    public ResponseEntity<List<Person>> addByParam(@RequestParam List<String> name) {

        List<Person> persons = name.stream()
                .map(n -> {
                    Person p = new Person();
                    p.setName(n);
                    p.setEmail(n.toLowerCase() + "@gmail.com");
                    return p;
                })
                .toList();

        return ResponseEntity.ok(personRepo.saveAll(persons));
    }

    // ===================== findById() =====================
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        Optional<Person> person = personRepo.findById(id);
        return person.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ===================== findAll() =====================
    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personRepo.findAll());
    }

    // ===================== existsById() =====================
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
        return ResponseEntity.ok(personRepo.existsById(id));
    }

    // ===================== count() =====================
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(personRepo.count());
    }

    // ===================== deleteById() =====================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        personRepo.deleteById(id);
        return ResponseEntity.ok("Deleted person with id " + id);
    }

    // ===================== deleteAll() =====================
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        personRepo.deleteAll();
        return ResponseEntity.ok("All persons deleted");
    }
}
