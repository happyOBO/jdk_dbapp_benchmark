package app;

/**
 *
 * @author Miftachut Ekasetya
 */
public interface IUsageHistory {

    //setter
    void setUserId(String userId);
    void setSessionId(int sessionId);
    void setLineNo(int lineNo);
    void setSequenceNo(int sequenceNo);
    void setCommand(String command);
    
    //getter
    String getUserId();
    int getSessionId();
    int getLineNo();
    int getSequenceNo();
    String getCommand();
    
}
