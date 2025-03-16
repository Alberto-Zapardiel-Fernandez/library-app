package com.library.library_app.infrastructure.mybatis;

import com.library.library_app.domain.model.BookModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyBatisBookMapper {
    List<BookModel> findAll(int offset, int limit);

    int count();
}
