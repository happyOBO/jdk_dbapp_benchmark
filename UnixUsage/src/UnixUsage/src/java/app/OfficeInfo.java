package app;

/**
 *
 * @author Miftachut Ekasetya
 */
//Implementor class for Interface IOfficeInfo
public class OfficeInfo implements IOfficeInfo {

    private int _officeId;
    private String _officeName;
    private short _hasPrinter;

    OfficeInfo(int officeId, String officeName) {
        _officeId = officeId;
        _officeName = officeName;
    }

    public int getOfficeId() {
        return _officeId;
    }

    public void setOfficeId(int officeId) {
        _officeId = officeId;
    }

    public String getOfficeName() {
        return _officeName;
    }

    public void setOfficeName(String officeName) {
        _officeName = officeName;
    }

    public short getHasPrinter() {
        return _hasPrinter;
    }

    public void setHasPrinter(short hasPrinter) {
        _hasPrinter = hasPrinter;
    }

}
