package app;

import java.util.Date;

/**
 *
 * @author Naeem Q.
 */
public interface IUserInfo {
    String getUserId();
    String getFirstname();
    String getLastname();
    String getSex();
    int getDepartmentId();
    int getOfficeId();
    int getGraduate();
    int getRaceId();
    String getPassword();
    int getYearsUsingUnix();
    Date getEnrollDate();
}
