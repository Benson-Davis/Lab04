package models;

import java.io.Serializable;

/**
 *
 * @author bdavi
 */
public class Note implements Serializable
{
    //create the properties of a Note object
    private String title;
    private String contents;

    public Note()
    {
        this.title = "This is the title";
        this.contents = "Contents go here";
    }

    public Note(String title, String contents)
    {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }
    
    
}