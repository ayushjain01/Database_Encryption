package mypackage;

import java.io.Serializable;

@SuppressWarnings("serial")
public class student implements Serializable {

    private static String usn ;
    private static String name;
    private static String address;
    private static String mobile;
    
    public static String getUsn() {
        return usn;
    }
    @SuppressWarnings("static-access")
	public void setUsn(String usn) {
        this.usn = usn;
    }
    public static String getName() {
        return name;
    }
    @SuppressWarnings("static-access")
	public void setName(String name) {
        this.name = name;
    }
    public static String getAddr() {
        return address;
    }
    @SuppressWarnings("static-access")
	public void setAddr(String address) {
        this.address = address;
    }
    public static String getMob() {
        return mobile;
    }
    @SuppressWarnings("static-access")
	public void setMob(String mobile) {
        this.mobile = mobile;
    }
}