package app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {

    @Id
    @Column (name = "actor_id", nullable = false, unique = true)
    private int actorID;

    @Column (name = "name")
    private String name;

    @Column (name = "know_for_department")
    private String department;

    @Column (name = "character")
    private String character;
}
