package TraniningRestAsured;

public class ProductData {



    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;


    String name;
    String job;

    public ProductData(String name, String job){
        setName(name);
        setJob(job);
    }

    public ProductData(int id, String email, String first_name, String last_name,String avatar){
        setId(id);
        setEmail(email);
        setFirst_name(first_name);
        setLast_name(last_name);
        setAvatar(avatar);


    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
