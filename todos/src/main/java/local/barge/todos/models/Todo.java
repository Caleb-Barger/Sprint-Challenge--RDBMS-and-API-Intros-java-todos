package local.barge.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo extends Auditable
{
    /**
     * The primary key (long) of the useremails table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    private String description;

    @ManyToOne
    @JoinColumn(name = "todoid",
        nullable = false)
    @JsonIgnoreProperties(value = "todos",
        allowSetters = true)
    private User user;

    /**
     * The default controller is required by JPA
     */
    public Todo()
    {
    }

    /**
     * Given the parameters, create a new description object
     *
     * @param user      the user (User) assigned to the email
     * @param description description (String) for the given user
     */
    public Todo(
        User user,
        String description)
    {
        this.description = description;
        this.user = user;
    }

    /**
     * Getter for useremailid
     *
     * @return the primary key (long) of this description object
     */
    public long getTodoid()
    {
        return todoid;
    }

    /**
     * Setter for useremailid. Used for seeding data
     *
     * @param useremailid the new primary key (long) of this description object
     */
    public void setTodoid(long useremailid)
    {
        this.todoid = useremailid;
    }

    /**
     * Getter for description
     *
     * @return the email (String) associated with this description object in lowercase
     */
    public String getDescription()
    {
        if (description == null) // this is possible when updating a user
        {
            return null;
        } else
        {
            return description.toLowerCase();
        }
    }

    /**
     * Setter for description
     *
     * @param description the email (String) to replace the one currently assigned to this description object, in lowercase
     */
    public void setDescription(String description)
    {
        this.description = description.toLowerCase();
    }


    /**
     * Getter for user
     *
     * @return the user object associated with this description.
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Setter for user
     *
     * @param user the user object to replace the one currently assigned to this description object
     */
    public void setUser(User user)
    {
        this.user = user;
    }
}
