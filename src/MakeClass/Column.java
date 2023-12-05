package MakeClass;


public class Column {

    private String  sqlCtt         ;  /* SQL내용        */
    
    private String  srchTblNm ;
    
    private String  tblNm     ;
    private String  colNm     ;
    private String  colId     ;
    private String  pkYn      ;
    private String  dataTyp   ;
    private String  dataLen   ;
    private String  nullYn    ;
    private String  dataDef   ;
    private String  cmnt      ;

    private String  aliasNm   ;

    public String getSqlCtt() {
        return sqlCtt;
    }

    public void setSqlCtt(String sqlCtt) {
        this.sqlCtt = sqlCtt;
    }

    public String getSrchTblNm() {
        return srchTblNm;
    }

    public void setSrchTblNm(String srchTblNm) {
        this.srchTblNm = srchTblNm;
    }

    public String getTblNm() {
        return tblNm;
    }

    public void setTblNm(String tblNm) {
        this.tblNm = tblNm;
    }

    public String getColNm() {
        return colNm;
    }

    public void setColNm(String colNm) {
        this.colNm = colNm;
        setAliasNm(colNm);
    }

    public String getColId() {
        return colId;
    }

    public void setColId(String colId) {
        this.colId = colId;
    }

    public String getPkYn() {
        return pkYn;
    }

    public void setPkYn(String pkYn) {
        this.pkYn = pkYn;
    }

    public String getDataTyp() {
        return dataTyp;
    }

    public void setDataTyp(String dataTyp) {
        this.dataTyp = dataTyp;
    }

    public String getDataLen() {
        return dataLen;
    }

    public void setDataLen(String dataLen) {
        this.dataLen = dataLen;
    }

    public String getNullYn() {
        return nullYn;
    }

    public void setNullYn(String nullYn) {
        this.nullYn = nullYn;
    }

    public String getDataDef() {
        return dataDef;
    }

    public void setDataDef(String dataDef) {
        this.dataDef = dataDef;
    }

    public String getCmnt() {
        return cmnt;
    }

    public void setCmnt(String cmnt) {
        this.cmnt = cmnt;
    }
    
    
    public String getAliasNm() {
        return aliasNm;
    }

    private void setAliasNm(String colNm) {
        String result = "";
        
        String temp = colNm.toLowerCase();
        
        int idx = -1;
        String split = "_";
        String word  = "";
        while ( true ) {
            
            idx = temp.indexOf(split);
            
            if ( idx < 0 ) {
                word = temp;
            } else {
                word = temp.substring(0, idx);
                temp = temp.substring(idx + 1);
            }

            result = result + word.substring(0, 1).toUpperCase() + word.substring(1);

            if ( idx < 0 ) {
                break;
            }
        }
        
        aliasNm = result.substring(0, 1).toLowerCase() + result.substring(1);
    }
    
    
}
