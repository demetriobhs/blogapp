package br.com.dbrainlab.domain.post.persistence.model;

import br.com.dbrainlab.domain.category.Category;
import br.com.dbrainlab.domain.post.subdomain.reply.Reply;
import br.com.dbrainlab.domain.post.subdomain.section.Section;
import br.com.dbrainlab.infrastructure.persistence.model.impl.IdentityModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Post extends IdentityModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private Date creationDate;

    private Date lastUpdateDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "post")
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

    @ManyToMany(mappedBy = "posts")
    private List<Reply> tags = new ArrayList<>();

}
