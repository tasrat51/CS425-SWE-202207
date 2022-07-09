package edu.miu.cs.cs425.fairfieldlibrarycliapp;

import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.PrimaryAddress;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.model.Publisher;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.repository.PublisherRepository;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.service.PrimaryAddressService;
import edu.miu.cs.cs425.fairfieldlibrarycliapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// this class is UI
public class FairfieldlibrarycliappApplication implements CommandLineRunner {
        @Autowired // Field Injection
    private PublisherService publisherService;
        @Autowired
    private PrimaryAddressService primaryAddressService;

    //    @Autowired
//    public FairfieldlibrarycliappApplication(PublisherService publisherService,
//                                             PrimaryAddressService primaryAddressService) {
//        this.publisherService = publisherService;
//        this.primaryAddressService = primaryAddressService;
//    }

    public static void main(String[] args) {
        SpringApplication.run(FairfieldlibrarycliappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World SpringBoot!!!");
              Publisher mcg = new Publisher(null, "McGraw-Hill");
              publisherService.addNewPublisher(mcg);
              System.out.println(createNewPublisher(mcg));
              Publisher wile = new Publisher(null, "John Wiley and Sons");
              publisherService.addNewPublisher(wile);
              System.out.println(createNewPublisher(wile));
        printAllPublishers();
        printPublisherById(1);
        printPublisherById(10);
       updateAndPrintPublisherById(1);
              deletePublisherById(1);
        System.out.println("Finished execution");
   }

    private Publisher createNewPublisher(Publisher publisher) { // C: Create
        return publisherService.addNewPublisher(publisher);

   }

    private void printAllPublishers() { // R: Read
        var publishers = publisherService.getAllPublishers();
        publishers.forEach(System.out::println);
    }
//
    private void printPublisherById(Integer publisherId) {
        var publisher = publisherService.getPublisherById(publisherId);
        if(publisher != null) {
            System.out.println(publisher);
        } else {
            System.out.printf("Publisher with PublisherId: %d is not found!\n", publisherId);
        }
    }
//
    private void updateAndPrintPublisherById(Integer publisherId) { // U: Update
        var publisher = publisherService.getPublisherById(publisherId);
        publisher.setName("McGraw-Hill, Inc.");
        var mcgAddr = new PrimaryAddress(null, "1000 N Court Street", "Cleveland",
                "OH", "52335-0001", publisher);

        publisher.setPrimaryAddress(mcgAddr);

                var newMcGrawHillAddr = primaryAddressService.addNewPrimaryAddress(mcgAddr);
                publisher.setPrimaryAddress(newMcGrawHillAddr);

        var updatedPublisher = publisherService.updatePublisher(publisher);
        System.out.println(updatedPublisher);
    }

   private void deletePublisherById(Integer publisherId) { // D: Delete
         publisherService.deletePublisherById(publisherId);
   }
}