package com.example.demo.repositores;

import com.example.demo.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends CrudRepository<Tag, Integer> {
}
