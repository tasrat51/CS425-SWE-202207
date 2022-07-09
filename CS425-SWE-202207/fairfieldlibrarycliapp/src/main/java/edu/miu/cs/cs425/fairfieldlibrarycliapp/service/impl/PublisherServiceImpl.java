package edu.miu.cs.cs425.fairfieldlibrarycliapp.service.impl;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;
   // @Autowired

//    public PublisherServiceImpl(PublisherRepository publisherRepository){
//        this.publisherRepository = publisherRepository;
   // }

    @Override
    public Publisher addNewPublisher(Publisher publisher) {
        //var is local varible in java 10 and above, we can use var inside method
        var newPublisher = publisherRepository.save(publisher);

        return newPublisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {

        var publishers = publisherRepository.findAll();
        return publishers;
    }

    @Override
    public Publisher getPublisherById(Integer publisherId) {
        return publisherRepository.findById(publisherId)
                .orElse(null);
    }

    @Override
    public Publisher updatePublisher(Publisher updatedPublisher) {
        return publisherRepository.save(updatedPublisher);
    }

    @Override
    public void deletePublisherById(Integer publisherId) {
       publisherRepository.deleteById(publisherId);
    }
}
