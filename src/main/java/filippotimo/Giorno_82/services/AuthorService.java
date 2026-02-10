package filippotimo.Giorno_82.services;

import filippotimo.Giorno_82.Exceptions.NotFoundException;
import filippotimo.Giorno_82.entities.Author;
import filippotimo.Giorno_82.payloads.NewAuthorPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    List<Author> authorDB = new ArrayList<>();

    // 1. GET -> Torna una lista di Blog Post

    public List<Author> findAllAuthors() {
        return authorDB;
    }

    // 2. GET -> Torna un singolo Blog Post specifico

    public Author findAuthorById(Long authorId) {
        Author found = null;
        for (Author author : this.authorDB) {
            if (author.getId() == authorId) found = author;
        }
        if (found == null) throw new NotFoundException(authorId);
        return found;
    }

    // 3. POST -> Crea un Blog Post

    public Author saveAuthor(NewAuthorPayload authorPayload) {
        Author newAuthor = new Author(authorPayload.getNome(), authorPayload.getCognome(), authorPayload.getEmail(), authorPayload.getDataDiNascita());
        this.authorDB.add(newAuthor);
        System.out.println("L'Autore con id " + newAuthor.getId() + " è stato salvato correttamente");
        return newAuthor;
    }

    // 4. PUT -> Modifica lo specifico Blog post

    public Author findByIdAndUpdateAuthor(Long authorId, NewAuthorPayload authorPayload) {
        Author found = null;
        for (Author author : this.authorDB) {
            if (author.getId() == authorId) {
                found = author;
                found.setNome(authorPayload.getNome());
                found.setCognome(authorPayload.getCognome());
                found.setEmail(authorPayload.getEmail());
                found.setDataDiNascita(authorPayload.getDataDiNascita());
            }
        }
        if (found == null) throw new NotFoundException(authorId);
        return found;
    }

    // 5. DELETE -> Cancella lo specifico Blog post

    public void findByIdAdDeleteAuthor(Long authorId) {
        Author found = null;
        for (Author author : this.authorDB) {
            if (author.getId() == authorId) found = author;
        }
        if (found == null) throw new NotFoundException(authorId);
        this.authorDB.remove(found);
    }

    /*

    public void findByIdAdDeleteAuthor(Long authorId) {
        for (Author author : this.authorDB) {
            this.authorDB.removeIf(a -> a.getId() == authorId);
        }
    }

    */

}
