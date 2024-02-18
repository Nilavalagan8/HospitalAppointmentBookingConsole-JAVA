package Model;

public class Hospital {

    private int hospitalId;
    private String name;
    private String phN0;
    private String add;
    private int uId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
    public String getPhN0() {
        return phN0;
    }

    public void setPhN0(String phN0) {
        this.phN0 = phN0;
    }
}
