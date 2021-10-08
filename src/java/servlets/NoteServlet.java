package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author bdavi
 */
public class NoteServlet extends HttpServlet
{


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        if(request.getParameter("edit") == null)
        {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");//get the path to the file on the executing machine
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));//create a reader for the file
            String title = "";
            String contents = "";

            //Note note = (Note)request.getAttribute("theNote");

            if(reader.ready() == false)
            {

            } else
            {
                title = reader.readLine();
                while(reader.ready())
                {
                    contents += reader.readLine();
                }
            }
            Note currentNote = new Note(title, contents);//create a Note object with the saved values for attributes
            request.setAttribute("theNote", currentNote);//set attribute to be the Note pulled from the file
            reader.close();
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        } else 
        {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");//get the path to the file on the executing machine
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));//create a reader for the file
            String title = "";
            String contents = "";

            //Note note = (Note)request.getAttribute("theNote");

            if(reader.ready() == false)
            {

            } else
            {
                title = reader.readLine();
                while(reader.ready())
                {
                    contents += reader.readLine();
                }
            }
            Note currentNote = new Note(title, contents);//create a Note object with the saved values for attributes
            request.setAttribute("theNote", currentNote);//set attribute to be the Note pulled from the file
            reader.close();
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //empty strings in case nothing is in the request object to get, to avoid errors
        String title = "";
        String contents = "";
        
        title = request.getParameter("titleText");
        contents = request.getParameter("contentsText");
        
        Note newNote = new Note(title, contents);
        
        //create an attribute to hold the note
        //make it a session attribute?
        request.setAttribute("theNote", newNote);
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");//get the path to the file on the executing machine
        PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));//set up a writer to the path
        printer.println(title);
        printer.println(contents);//write title and contents to file, along with a delimiter
        printer.close();
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }

}
