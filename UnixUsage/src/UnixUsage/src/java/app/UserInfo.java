package app;
import java.util.Date;

/**
 *
 * @author Naeem Q.
 */

//Implementor class for Interface IUserInfo
public class UserInfo implements IUserInfo {

    private String _userId;
    private String _firstname;
    private String _lastname;
    private String _sex;
    private int _departmentId;
    private int _officeId;
    private int _graduate;
    private int _raceId;
    private String _password;
    private int _yearsUsingUnix;
    private Date _enrollDate;


    public UserInfo(String userId, String firstname ,String lastname, String sex, int departmentId, int officeId, int graduate, int raceId, String password, int yearsUsingUnix, Date enrollDate) {
        setUserId(userId);
        setMembers(firstname
                , lastname
                , sex
                , departmentId
                , officeId
                , graduate
                , raceId
                , password
                , yearsUsingUnix
                , enrollDate);
    }

    public UserInfo(String firstname, String lastname, String sex, int departmentId, int officeId, int graduate, int raceId, String password, int yearsUsingUnix, Date enrollDate) {
        setMembers(firstname
                , lastname
                , sex
                , departmentId
                , officeId
                , graduate
                , raceId
                , password
                , yearsUsingUnix
                , enrollDate);
    }


    private void setMembers(String firstname , String lastname, String sex, int departmentId, int officeId, int graduate, int raceId, String password, int yearsUsingUnix, Date enrollDate) {
        setFirstname(firstname);
        setLastname(lastname);
        setSex(sex);
        setDepartmentId(departmentId);
        setOfficeId(officeId);
        setGraduate(graduate);
        setRaceId(raceId);
        setPassword(password);
        setYearsUsingUnix(yearsUsingUnix);
        setEnrollDate(enrollDate);
    }


    // Setter Methods
    private void setUserId(String userId) {
        _userId = userId;
    }

    private void setFirstname(String firstname) {
        _firstname = firstname;
    }

    private void setLastname(String lastname) {
        _lastname = lastname;
    }

    private void setSex(String sex) {
        _sex = sex;
    }

    private void setDepartmentId(int departmentId) {
        _departmentId = departmentId;
    }

    private void setOfficeId(int officeId) {
        _officeId = officeId;
    }

    private void setGraduate(int graduate) {
        _graduate = graduate;
    }

    private void setRaceId(int raceId) {
        _raceId = raceId;
    }

    private void setPassword(String password) {
        _password = password;
    }

    private void setYearsUsingUnix(int yearsUsingUnix) {
        _yearsUsingUnix =yearsUsingUnix;
    }

    private void setEnrollDate(Date enrollDate) {
        _enrollDate = enrollDate;
    }

    // Getter Methods
    public String getUserId()
    {
        return new String(_userId);
    }

    public String getFirstname() {
        return new String(_firstname);
    }
    
    public String getLastname() {
        return new String(_lastname);
    }

    public String getSex() {
        return new String(_sex);
    }

    public int getDepartmentId() {
        return _departmentId;
    }

    public int getOfficeId() {
        return _officeId;
    }

    public int getGraduate() {
        return _graduate;
    }

    public int getRaceId() {
        return _raceId;
    }

    public String getPassword() {
        return new String(_password);
    }

    public int getYearsUsingUnix() {
        return _yearsUsingUnix;
    }

    public Date getEnrollDate() {
        Date tmp = _enrollDate;
        return tmp;
    }
}
