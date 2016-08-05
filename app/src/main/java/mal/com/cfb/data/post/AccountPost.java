package mal.com.cfb.data.post;

import mal.com.cfb.data.user.Account;

/**
 * Created by user on 8/3/16.
 */

public class AccountPost {

    private Account postOwner;
    private Post post;

    public AccountPost(Account postOwner, Post post) {
        this.postOwner = postOwner;
        this.post = post;
    }

    public Account getPostOwner() {
        return postOwner;
    }

    public void setPostOwner(Account postOwner) {
        this.postOwner = postOwner;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
