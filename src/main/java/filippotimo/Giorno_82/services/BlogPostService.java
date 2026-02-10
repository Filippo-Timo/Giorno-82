package filippotimo.Giorno_82.services;

import filippotimo.Giorno_82.Exceptions.NotFoundException;
import filippotimo.Giorno_82.entities.BlogPost;
import filippotimo.Giorno_82.payloads.NewBlogPostPayload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService {

    List<BlogPost> blogPostsDB = new ArrayList<>();

    // 1. GET -> Torna una lista di Blog Post

    public List<BlogPost> findAllBlogPosts() {
        return blogPostsDB;
    }

    // 2. GET -> Torna un singolo Blog Post specifico

    public BlogPost findBlogPostById(Long blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsDB) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    // 3. POST -> Crea un Blog Post

    public BlogPost saveBlogPost(NewBlogPostPayload blogPostPayload) {
        BlogPost newBlogPost = new BlogPost(blogPostPayload.getCategoria(), blogPostPayload.getTitolo(), blogPostPayload.getContenuto(), blogPostPayload.getTempoDiLettura());
        this.blogPostsDB.add(newBlogPost);
        System.out.println("Il BlogPost con id " + newBlogPost.getId() + " è stato salvato correttamente");
        return newBlogPost;
    }

    // 4. PUT -> Modifica lo specifico Blog post

    public BlogPost findByIdAndUpdateBlogPost(Long blogPostId, NewBlogPostPayload blogPostPayload) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsDB) {
            if (blogPost.getId() == blogPostId) {
                found = blogPost;
                found.setCategoria(blogPostPayload.getCategoria());
                found.setTitolo(blogPostPayload.getTitolo());
                found.setContenuto(blogPostPayload.getContenuto());
                found.setTempoDiLettura(blogPostPayload.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    // 5. DELETE -> Cancella lo specifico Blog post

    public void findByIdAdDeleteBlogPost(Long blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsDB) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        this.blogPostsDB.remove(found);
    }

    /*

    public void findByIdAdDeleteBlogPost(Long blogPostId) {
        for (BlogPost blogPost : this.blogPostsDB) {
            this.blogPostsDB.removeIf(b -> b.getId() == blogPost.getId());
        }
    }

    */
}
