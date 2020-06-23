package app;

/**
 *
 * @author meka2
 */

//Implementor class for Interface IUsageHistory
public class UsageHistory implements IUsageHistory {
    String _userId;
    int _sessionId;
    int _lineNo;
    int _sequenceNo;
    String _command;

    UsageHistory(String userId, int sessionId, int lineNo, int sequenceNo, String command) {
        _userId = userId;
        _sessionId = sessionId;
        _lineNo = lineNo;
        _sequenceNo = sequenceNo;
        _command = command;
    }

    public String getUserId() {
        return _userId;
    }

    public int getSessionId() {
        return _sessionId;
    }

    public void setCommand(String command) {
        _command = command;
    }

    public String getCommand() {
        return _command;
    }

    public void setUserId(String userId) {
        _userId = userId;
    }

    public void setSessionId(int sessionId) {
        _sessionId = sessionId;
    }

    public void setLineNo(int lineNo) {
        _lineNo = lineNo;
    }

    public void setSequenceNo(int sequenceNo) {
        _sequenceNo = sequenceNo;
    }

    public int getLineNo() {
        return _lineNo;
    }

    public int getSequenceNo() {
        return _sequenceNo;
    }
}
