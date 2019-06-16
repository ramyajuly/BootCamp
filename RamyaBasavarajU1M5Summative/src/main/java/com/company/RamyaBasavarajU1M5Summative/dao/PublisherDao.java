package com.company.RamyaBasavarajU1M5Summative.dao;


import com.company.RamyaBasavarajU1M5Summative.dto.Publisher;

import java.util.List;

public interface PublisherDao {
    //Publisher
    Publisher createPublisher(Publisher publisher);

    Publisher readPublisher(int id);

    List<Publisher> readAllPublisher();

    Publisher updatePublisher(Publisher publisher);

    void deletePublisher(int id) throws Exception ;
}
