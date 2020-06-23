package app;

/**
 *
 * @author Miftachut Ekasetya
 */
public interface IOfficeInfo {

    int getOfficeId();
    void setOfficeId(int officeId);
    String getOfficeName();
    void setOfficeName(String officeName);
    short getHasPrinter();
    void setHasPrinter(short hasPrinter);
}
