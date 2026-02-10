package filippotimo.Giorno_82.controllers;

/*

1. GET /blogPosts -> Ritorna la lista di autori (List<User>)
2. GET /blogPosts/123 -> Ritorna un singolo autore (User)
3. POST /blogPosts -> Crea un nuovo autore (new User)
4. PUT /blogPosts/123 -> Modifica lo specifico autore (void)
5. DELETE /blogPosts/123 -> Cancella lo specifico autore (void)

 */

import filippotimo.Giorno_82.entities.BlogPost;
import filippotimo.Giorno_82.payloads.NewBlogPostPayload;
import filippotimo.Giorno_82.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    @Autowired
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    // 1. GET /blogPosts -> Ritorna la lista di autori (List<User>)

    @GetMapping
    public List<BlogPost> findAllBlogPosts() {
        return this.blogPostService.findAllBlogPosts();
    }

    // 2. GET /blogPosts/123 -> Ritorna un singolo autore (User)

    @GetMapping("/{blogPostId}")
    public BlogPost findBlogPostById(@PathVariable Long blogPostId) {
        return this.blogPostService.findBlogPostById(blogPostId);
    }

    // 3. POST /blogPosts -> Crea un nuovo autore (new User)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Questo serve per ricevere un codice 201 se ha successo la creazione
    public BlogPost createBlogPost(@RequestBody NewBlogPostPayload blogPostPayload) {
        return this.blogPostService.saveBlogPost(blogPostPayload);
    }

}
