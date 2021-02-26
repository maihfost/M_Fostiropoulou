package models;


public class TrainerCourse {
    private int trainer_id;
    private String f_name;
    private String l_name;
    private int course_id;

    public TrainerCourse(int trainer_id, String f_name, String l_name, int course_id) {
        this.trainer_id = trainer_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.course_id = course_id;
    }

    
    
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(int trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrainerCourse{trainer_id=").append(trainer_id);
        sb.append(", f_name=").append(f_name);
        sb.append(", l_name=").append(l_name);
        sb.append(", course_id=").append(course_id);
        sb.append('}');
        return sb.toString();
    }

}
