package com.jolly.dblab;

import org.quickperf.junit5.QuickPerfTest;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest
@QuickPerfTest
@Import({DbLabTestConfiguration.class, QuickPerfSqlConfig.class})
public @interface UseCaseTest {
}
