package com.scaler.ProductService.Controllers;

import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.DTOs.SearchRequestDTO;
import com.scaler.ProductService.Services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public Page<ResponseProductDTO> search(@RequestBody SearchRequestDTO searchRequestDTO) {
        return searchService.search(searchRequestDTO.getQuery()
                , searchRequestDTO.getPageNumber()
                , searchRequestDTO.getPageSize());
    }
}
