package com.kailin.appSample.data.bus;

/**
 * RouteOperator {
 * OperatorID (string): 營運業者代碼 ,
 * OperatorName (NameType): 營運業者名稱 ,
 * OperatorCode (string): 營運業者簡碼 ,
 * OperatorNo (string): 營運業者編號[交通部票證資料系統定義]
 * }
 */
public final class RouteOperator {

    private String OperatorID;

    private NameType OperatorName;

    private String OperatorCode;

    private String OperatorNo;

    public String getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(String operatorID) {
        OperatorID = operatorID;
    }

    public NameType getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(NameType operatorName) {
        OperatorName = operatorName;
    }

    public String getOperatorCode() {
        return OperatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        OperatorCode = operatorCode;
    }

    public String getOperatorNo() {
        return OperatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        OperatorNo = operatorNo;
    }

    @Override
    public String toString() {
        return "RouteOperator{" +
                "OperatorID='" + OperatorID + '\'' +
                ", OperatorName=" + OperatorName +
                ", OperatorCode='" + OperatorCode + '\'' +
                ", OperatorNo='" + OperatorNo + '\'' +
                '}';
    }
}
