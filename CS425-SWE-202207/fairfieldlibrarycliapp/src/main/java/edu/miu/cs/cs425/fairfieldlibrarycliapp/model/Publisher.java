package edu.miu.cs.cs425.fairfieldlibrarycliapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(name = "publisher_name",nullable = false)
//    @NotNull(message = "publisher name can not be null")
//    @NotEmpty(message = "publisher name can not be empty")
//    @NotBlank(message = "publisher name can not be blank spaces")
    private String name;
     @OneToOne(cascade=CascadeType.ALL)
     @JoinColumn(name="primary_addr_id",nullable=true) // we give this annotation to the owner of the r|p.
     // nullable true b/c the r/p is 0..1, when it is zero it is null
    private PrimaryAddress primaryAddress;

    public Publisher() {
        this(null,null);
    }

    public Publisher(Integer publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public String getName() {
        return name;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryAddress getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(PrimaryAddress primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    @Override
    public String toString(){
      return String.format("{PublisherId: %d,PublisherName:%s,PrimaryAddress: %s}\n",publisherId,name,primaryAddress);
    }
}
