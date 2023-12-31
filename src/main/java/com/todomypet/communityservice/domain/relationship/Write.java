package com.todomypet.communityservice.domain.relationship;

import com.todomypet.communityservice.domain.node.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Builder
@Getter
public class Write {

    @RelationshipId
    private Long id;

    @TargetNode
    private User user;
}
