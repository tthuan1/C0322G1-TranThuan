package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    //    @Query(value = "select * from Blog ", nativeQuery = true)
//    List<Blog> findAll();
    @Query(value = "select * from  blog where id = :id", nativeQuery = true)
    Blog findByIdBlog(@Param("id") int id);


//    UPDATE `blog_app`.`blog` SET `content` = '1', `year` = '1' WHERE (`id` = '6');

    @Modifying
    @Query(value = "update Blog SET `name`= :name, `content` = :content, `year` = :year,`category_id` = :category WHERE (`id` = :id);", nativeQuery = true)
    void edit(@Param("id") Integer id, @Param("content") String content, @Param("year") String year, @Param("name") String name, @Param("category")Integer category);

    @Modifying//cho phép query có thể thực hiện sửa xoá
    @Query(value = "DELETE FROM blog WHERE (`id` = :id);", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = "select * from Blog ", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

}
