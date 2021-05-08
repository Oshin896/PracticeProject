package com.example.pagination.controller;


import com.example.pagination.entity.PagingEntity;
import com.example.pagination.enums.Direction;
import com.example.pagination.enums.OrderBy;
import com.example.pagination.exception.PaginationSortingException;
import com.example.pagination.exception.PagingSortingErrorResponse;
import com.example.pagination.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pagination")

public class PaginationController {

    @Autowired
    private PaginationService paginationService;

    @RequestMapping(value = "/conditionalPagination", params = { "orderBy", "direction", "page",
            "size" }, method = RequestMethod.GET)    @ResponseBody
    public Page<PagingEntity> findJsonDataByPageAndSize(@RequestParam("orderBy") String orderBy,
                                                        @RequestParam("direction") String direction, @RequestParam("page") int page,
                                                        @RequestParam("size") int size) {

        if (!(direction.equals(Direction.ASCENDING.getDirectionCode())
                || direction.equals(Direction.DESCENDING.getDirectionCode()))) {
            throw new PaginationSortingException("Invalid sort direction");
        }

        if (!(orderBy.equals(OrderBy.ID.getOrderByCode()) || orderBy.equals(OrderBy.USERID.getOrderByCode()))) {
            throw new PaginationSortingException("Invalid orderBy condition");
        }
        Page<PagingEntity> list = paginationService.findJsonDataByCondition(orderBy, direction, page, size);
        return list;
    }

    @ExceptionHandler(PaginationSortingException.class)
    public ResponseEntity<PagingSortingErrorResponse> exceptionHandler(Exception ex) {
        PagingSortingErrorResponse pagingSortingErrorResponse = new PagingSortingErrorResponse();
        pagingSortingErrorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        pagingSortingErrorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<PagingSortingErrorResponse>(pagingSortingErrorResponse, HttpStatus.OK);
    }

}
