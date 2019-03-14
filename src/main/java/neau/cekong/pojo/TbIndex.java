package neau.cekong.pojo;

public class TbIndex {
    private Integer id;

    private String indexName;

    private Integer indexFarther;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    public Integer getIndexFarther() {
        return indexFarther;
    }

    public void setIndexFarther(Integer indexFarther) {
        this.indexFarther = indexFarther;
    }
}