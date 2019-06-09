package neau.cekong.pojo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

public class RecordTableRow {
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;

    private Collection<String> colNames;

    private Map<String, Object> cols;

    public RecordTableRow(LocalDateTime timeStart, LocalDateTime timeEnd, Collection<String> colNames, Map<String, Object> cols) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.colNames = colNames;
        this.cols = cols;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Collection<String> getColNames() {
        return colNames;
    }

    public void setColNames(Collection<String> colNames) {
        this.colNames = colNames;
    }

    public Map<String, Object> getCols() {
        return cols;
    }

    public void setCols(Map<String, Object> cols) {
        this.cols = cols;
    }

    @Override
    public String toString() {
        return "RecordTableRow{" +
                "timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", colNames=" + colNames +
                ", cols=" + cols +
                '}';
    }
}
