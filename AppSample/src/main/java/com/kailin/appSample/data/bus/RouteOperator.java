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

    private String OperatorNo;

    private NameType Name;

    private String OperatorCode;

    private String OperatorID;

    public String getOperatorNo() {
        return OperatorNo;
    }

    public void setOperatorNo(String OperatorNo) {
        this.OperatorNo = OperatorNo;
    }

    public NameType getName() {
        return Name;
    }

    public void setName(NameType Name) {
        this.Name = Name;
    }

    public String getOperatorCode() {
        return OperatorCode;
    }

    public void setOperatorCode(String OperatorCode) {
        this.OperatorCode = OperatorCode;
    }

    public String getOperatorID() {
        return OperatorID;
    }

    public void setOperatorID(String OperatorID) {
        this.OperatorID = OperatorID;
    }

    @Override
    public String toString() {
        return "RouteOperator{" +
                "OperatorNo='" + OperatorNo + '\'' +
                ", NameType=" + Name +
                ", OperatorCode='" + OperatorCode + '\'' +
                ", OperatorID='" + OperatorID + '\'' +
                '}';
    }
}
