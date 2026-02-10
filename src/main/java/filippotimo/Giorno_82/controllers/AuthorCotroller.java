package filippotimo.Giorno_82.controllers;

/*

1. GET /authors -> Ritorna la lista di blog post (List<Blog>)
2. GET /authors/123 -> Ritorna un singolo blog post (Blog)
3. POST /authors -> Crea un nuovo blog post (new Blog)
4. PUT /authors/123 -> Modifica lo specifico blog post (void)
5. DELETE /authors/123 -> Cancella lo specifico blog post (void)

 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorCotroller {
}
