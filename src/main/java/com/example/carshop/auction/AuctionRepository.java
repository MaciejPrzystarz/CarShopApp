package com.example.carshop.auction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findTop5ByOrderByPriceDesc();

    List<Auction> findAllByOrderByCarMakerAscCarModelAsc();
}