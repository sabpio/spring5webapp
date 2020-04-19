package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in bootstrap..");

        Publisher publisher = new Publisher("publisher", "armii krajowej 35", "piotrkow", "lodzkie", "97-300");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());

        Author eric = new Author("eric", "evans");
        Book ddd = new Book("ddd", "123124124");
        authorRepository.save(eric);
        bookRepository.save(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        Author rob = new Author("rob", "johnson");
        Book noEJB = new Book("noEJB", "216546456");
        authorRepository.save(rob);
        bookRepository.save(noEJB);

        rob.getBooks().add(noEJB);
        noEJB.getAuthors().add(rob);

        System.out.println("Number of books = " + bookRepository.count());
    }
}
