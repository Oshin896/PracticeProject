package com.example.pagination.dao;


import com.example.pagination.entity.PagingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationDao extends PagingAndSortingRepository<PagingEntity, Integer> {

}
