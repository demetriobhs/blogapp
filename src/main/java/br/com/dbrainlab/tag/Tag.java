package br.com.dbrainlab.tag;

import br.com.dbrainlab.infrastructure.persistence.IdentityModel;
import br.com.dbrainlab.post.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Tag extends IdentityModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "tag_posts",
        joinColumns = @JoinColumn(name = "tag_id"),
        inverseJoinColumns = @JoinColumn(name = "post_id")
    )
    private List<Post> posts = new ArrayList<>();

}
