package com.example.carshop.auction;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    private AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public List<Auction> find5MostExpensive() {
        return auctionRepository.findTop5ByOrderByPriceDesc();
    }

    public List<Auction> findAllForFilters() {
        return auctionRepository.findAll();
    }

    public List<Auction> findAllSorted(String sort) {
        if ("title".equals(sort)) {
            return auctionRepository.findAllByOrderByCarMakerAscCarModelAsc();
        } else {
            Sort sortBy = Sort.by(sort);
            return auctionRepository.findAll(sortBy);
        }
    }
}