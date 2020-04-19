package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

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

        System.out.println("Started in bootstrap..");
        System.out.println("Number of books = " + bookRepository.count());
    }
}
