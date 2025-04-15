import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
@EnableTransactionManagement
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/testdb");
        ds.setUsername("root");
        ds.setPassword("password");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("your.package");
        factory.getHibernateProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        factory.getHibernateProperties().put("hibernate.hbm2ddl.auto", "update");
        return factory;
    }

    @Bean
    public TransferService transferService(SessionFactory sessionFactory) {
        return new TransferService(sessionFactory);
    }
}
