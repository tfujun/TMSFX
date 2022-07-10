package model;


public class Session {
    private Faculty faculty;
    public Faculties faculties;
    
    public Session(){
        this.faculties = new Faculties(); 
        this.faculty = new Faculty();
    }
 
    public Faculty getFaculty(String email, String password){
        return faculties.getFaculty(email, password);
    }

}
