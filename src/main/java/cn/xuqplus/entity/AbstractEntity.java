package cn.xuqplus.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long createAt;
    private Long modifyAt;
    @Version
    private Integer version;

    @PrePersist
    public void prePersist() {
        this.createAt = System.currentTimeMillis();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifyAt = System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Long modifyAt) {
        this.modifyAt = modifyAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
