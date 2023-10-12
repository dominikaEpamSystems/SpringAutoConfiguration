package com.epam.SpringAutoConfiguration.repository;

import com.epam.SpringAutoConfiguration.entity.DataSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSourceEntityRepository extends JpaRepository<DataSourceEntity, Long> {
}
