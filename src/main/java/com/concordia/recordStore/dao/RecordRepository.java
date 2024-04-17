package com.concordia.recordStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concordia.recordStore.entity.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    // that's it ... no need to write any code LOL!

}