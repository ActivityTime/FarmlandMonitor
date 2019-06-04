package neau.cekong.pojo;

import java.util.List;

public class RecordVO {
    RecRecord record;
    List<RecRemark> remarks;

    public RecRecord getRecord() {
        return record;
    }

    public void setRecord(RecRecord record) {
        this.record = record;
    }

    public List<RecRemark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<RecRemark> remarks) {
        this.remarks = remarks;
    }
}
