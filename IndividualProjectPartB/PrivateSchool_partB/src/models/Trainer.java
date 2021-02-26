package models;


public class Trainer {
    private String first_name;
    private String last_name;

    public Trainer() {
    }
    
    public Trainer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trainer{first_name=").append(first_name);
        sb.append(", last_name=").append(last_name);
        sb.append('}');
        return sb.toString();
    }
    
    
}
