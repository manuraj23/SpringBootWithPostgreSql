package com.Manu.SpringBootWithPostgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {  //Long is the type of primary key and Person is the entity

}


//save() method is used to save an entity to the database.
//saveAll() method is used to save multiple entities to the database in a single operation.
//findById() method is used to retrieve an entity by its primary key.
//findAll() method is used to retrieve all entities of a given type from the database.
//deleteById() method is used to delete an entity by its primary key.
//deleteAll() method is used to delete all entities of a given type from the database.
//count() method is used to count the number of entities of a given type in the database.
//existsById() method is used to check if an entity with a given primary key exists in the database.
//JpaRepository provides many more methods for pagination, sorting, and custom queries.
