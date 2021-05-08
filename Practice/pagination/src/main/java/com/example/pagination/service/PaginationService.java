package com.example.pagination.service;


import com.example.pagination.dao.PaginationDao;
import com.example.pagination.entity.PagingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginationService extends Sort{

    @Autowired
    private PaginationDao paginationDao;
    protected Sort sort = null;



    public Page<PagingEntity> findJsonDataByCondition(String orderBy, String direction, int page, int size) {

        if (direction.equals("ASC")) {
            sort = new Sort(new Sort.Order(Direction.ASC, orderBy));
        }
        if (direction.equals("DESC")) {
            sort = new Sort(new Sort.Order(Direction.DESC, orderBy));
        }
        Pageable pageable = new PageRequest(page, size, sort);
        Page<PagingEntity> data = paginationDao.findAll(pageable);
        return data;
    }
}