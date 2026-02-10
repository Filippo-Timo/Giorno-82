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

    // 1. GET -> Torna una lista di BlogPost

    public List<BlogPost> findAllBlogPosts() {
        return blogPostsDB;
    }

    // 2. GET -> Torna un singolo BlogPost specifico

    public BlogPost findBlogPostById(Long blogPostId) {
        BlogPost found = null;
        for (BlogPost blogPost : this.blogPostsDB) {
            if (blogPost.getId() == blogPostId) found = blogPost;
        }
        if (found == null) throw new NotFoundException(blogPostId);
        return found;
    }

    // 3. POST -> Crea un BlogPost

    public BlogPost saveBlogPost(NewBlogPostPayload blogPostPayload) {
        BlogPost newBlogPost = new BlogPost(blogPostPayload.getCategoria(), blogPostPayload.getTitolo(), blogPostPayload.getContenuto(), blogPostPayload.getTempoDiLettura());
        this.blogPostsDB.add(newBlogPost);
        System.out.println("Il BlogPost con id " + newBlogPost.getId() + " è stato salvato correttamente");
        return newBlogPost;
    }

}
