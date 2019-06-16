package com.example.demo.repositores;

import com.example.demo.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends CrudRepository<Tag, Integer> {

    @Query(value = "INSERT INTO post_tag VALUES (NULL, :post, :tag)", nativeQuery = true)
    void saveConnection(@Param("post") Integer post, @Param("tag") Integer tag);

}
