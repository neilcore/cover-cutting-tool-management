package dev.briancore22.couver.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJPARepository<T, ID> extends JpaRepository<T, ID> {
    static final Integer STATUS_ACTIVE = 1;
    static final Integer STATUS_INACTIVE = 2;
    static final Integer STATUS_DELETED = 3;
    static final Integer STATUS_PENDING = 4;
    static final Integer STATUS_REJECTED = 5;
    static final Integer STATUS_APPROVED = 6;
    static final Integer STATUS_IN_PROGRESS = 7;
    static final Integer STATUS_COMPLETED = 8;
    static final Integer STATUS_FAILED = 9;
    static final Integer STATUS_SUCCESS = 10;
    static final Integer STATUS_ERROR = 11;
    static final Integer STATUS_CANCELLED = 12;
    static final Integer STATUS_DEFECT = 13;
}
