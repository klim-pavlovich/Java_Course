package Java_Lections;

public class Worker {
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString(){
        return String.format("id:%d fn:%s ln:%s s:%d", id, firstName, lastName, salary);
    }

    
    public boolean equals(Object o){
        Worker t = (Worker) o;
        return id == t.id && firstName == t.firstName;
    }


    @Override
    public int HashCode(){
        return super.hashCode();
    }
}
