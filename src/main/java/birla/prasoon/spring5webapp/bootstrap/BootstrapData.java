package birla.prasoon.spring5webapp.bootstrap;

import birla.prasoon.spring5webapp.domain.Address;
import birla.prasoon.spring5webapp.domain.Author;
import birla.prasoon.spring5webapp.domain.Book;
import birla.prasoon.spring5webapp.domain.Publisher;
import birla.prasoon.spring5webapp.repositories.AddressRepository;
import birla.prasoon.spring5webapp.repositories.AuthorRepository;
import birla.prasoon.spring5webapp.repositories.BookRepository;
import birla.prasoon.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement withoug EJB", "3123124123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Address address1 = new Address("Kasganj","U.P.", "207123");
        Address address2 = new Address("Delhi", "Delhi", "110035");
        Publisher publisher = new Publisher("Prasoon Birla");
        publisher.getAddress().add(address1);
        publisher.getAddress().add(address2);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        ddd.setPublisher(publisher);

        address1.setPublisher(publisher);
        address2.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        authorRepository.save(rod);
        publisherRepository.save(publisher);
        addressRepository.save(address1);
        addressRepository.save(address2);
        System.out.println("WORKED WELL");
        System.out.println("BOOK Repository count: " + bookRepository.count());
        System.out.println("Author Repository count: " + authorRepository.count());
        System.out.println("Publisher saved: count: "+ publisherRepository.count());
        System.out.println("Addresses saved: count: " + addressRepository.count() );
    }
}
