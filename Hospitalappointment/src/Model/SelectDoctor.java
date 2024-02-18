package Model;

public class SelectDoctor {
    private int doctorId;
    private String doctorName;
    private String doctorPhone;
    private  int specialityId;
    private String SpecialityDepartment;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityDepartment() {
        return SpecialityDepartment;
    }

    public void setSpecialityDepartment(String specialityDepartment) {
        SpecialityDepartment = specialityDepartment;
    }
}
