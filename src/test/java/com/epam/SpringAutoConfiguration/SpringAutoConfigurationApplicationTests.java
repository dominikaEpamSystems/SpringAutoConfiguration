package com.epam.SpringAutoConfiguration;

import com.epam.SpringAutoConfiguration.config.DataSourceConfiguration;
import com.epam.SpringAutoConfiguration.entity.DataSourceEntity;
import com.epam.SpringAutoConfiguration.repository.DataSourceEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class SpringAutoConfigurationApplicationTests {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(DataSourceConfiguration.class));

    @Autowired
    private DataSourceEntityRepository dataSourceEntityRepository;

    @Test
    public void shouldSaveEntityToTheDataSource() {
        DataSourceEntity entity = new DataSourceEntity();
        entity.setName("Test Entity");
        dataSourceEntityRepository.save(entity);
        System.out.printf(entity.getId().toString());
        assertNotNull(entity.getId());
    }

    @Test
    public void shouldUseDefaultDataSource() {
        this.contextRunner.run((context) -> {
            assertThat(context).hasSingleBean(DataSource.class);
            assertThat(context.getBean(DataSource.class))
                    .isSameAs(context.getBean(DataSourceConfiguration.class).defaultDataSource());
        });
    }
}
