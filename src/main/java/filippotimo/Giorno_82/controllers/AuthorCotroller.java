package filippotimo.Giorno_82.controllers;

/*

1. GET /authors -> Ritorna la lista di autori (List<Author>)
2. GET /authors/123 -> Ritorna un singolo autore (Author)
3. POST /authors -> Crea un nuovo autore (new Author)
4. PUT /authors/123 -> Modifica lo specifico autore (Author)
5. DELETE /authors/123 -> Cancella lo specifico autore (void)

 */

import filippotimo.Giorno_82.entities.Author;
import filippotimo.Giorno_82.payloads.NewAuthorPayload;
import filippotimo.Giorno_82.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorCotroller {

    private final AuthorService authorService;

    @Autowired
    public AuthorCotroller(AuthorService authorService) {
        this.authorService = authorService;
    }

    // 1. GET /authors -> Ritorna la lista di autori (List<Author>)

    @GetMapping
    public List<Author> findAllAuthors() {
        return this.authorService.findAllAuthors();
    }

    // 2. GET /authors/123 -> Ritorna un singolo autore (Author)

    @GetMapping("/{authorId}")
    public Author findAuthorById(@PathVariable Long authorId) {
        return this.authorService.findAuthorById(authorId);
    }

    // 3. POST /authors -> Crea un nuovo autore (new Author)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Questo serve per ricevere un codice 201 se ha successo la creazione
    public Author createAuthor(@RequestBody NewAuthorPayload authorPayload) {
        return this.authorService.saveAuthor(authorPayload);
    }

    // 4. PUT /authors/123 -> Modifica lo specifico autore (Author)

    @PutMapping("/{authorId}")
    public Author findAuthorByIdAndUpdate(@PathVariable Long authorId, @RequestBody NewAuthorPayload authorPayload) {
        return this.authorService.findByIdAndUpdateAuthor(authorId, authorPayload);
    }

    // 5. DELETE /authors/123 -> Cancella lo specifico autore (void)

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Questo serve per ricevere un codice 204 se ha successo la cancellazione
    public void findAuthorByIdAndDelete(@PathVariable Long authorId) {
        this.authorService.findByIdAdDeleteAuthor(authorId);
    }

}
