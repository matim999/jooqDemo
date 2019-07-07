package com.example.demo.config;

import org.jooq.*;
import org.jooq.conf.Settings;
import org.jooq.impl.DefaultConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig extends JooqAutoConfiguration.DslContextConfiguration {
    public AppConfig(JooqProperties properties, ConnectionProvider connectionProvider,
                     DataSource dataSource, ObjectProvider<TransactionProvider> transactionProvider,
                     ObjectProvider<RecordMapperProvider> recordMapperProvider,
                     ObjectProvider<RecordUnmapperProvider> recordUnmapperProvider,
                     ObjectProvider<Settings> settings, ObjectProvider<RecordListenerProvider[]> recordListenerProviders,
                     ExecuteListenerProvider[] executeListenerProviders, ObjectProvider<VisitListenerProvider[]> visitListenerProviders,
                     ObjectProvider<TransactionListenerProvider[]> transactionListenerProviders, ObjectProvider<ExecutorProvider> executorProvider) {
        super(properties, connectionProvider, dataSource, transactionProvider,
                recordMapperProvider, recordUnmapperProvider, settings, recordListenerProviders,
                executeListenerProviders, visitListenerProviders, transactionListenerProviders,
                executorProvider);
    }

    @Override
    public DefaultConfiguration jooqConfiguration() {
        DefaultConfiguration defaultConfiguration = super.jooqConfiguration();
        Settings settings = defaultConfiguration.settings();
        defaultSettings(settings);
        defaultConfiguration.set(settings);
        return defaultConfiguration;
    }

//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public DataSourceConnectionProvider connectionProvider() {
//        return new DataSourceConnectionProvider
//                (new TransactionAwareDataSourceProxy(dataSource));
//    }
//
//    @Bean
//    public DefaultDSLContext dsl() {
//        return new DefaultDSLContext(configuration());
//    }
//
//    private DefaultConfiguration configuration() {
//        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
//        jooqConfiguration.set(connectionProvider());
//        jooqConfiguration.set(SQLDialect.POSTGRES);
//        jooqConfiguration.set(jooqSettings());
//        return jooqConfiguration;
//    }
//
//    private Settings jooqSettings() {
//        Settings defaultSettings = new Settings();
//        defaultSettings.setRenderFormatted(true);
//        return defaultSettings;
//    }


    void defaultSettings(Settings settings) {
        settings.setRenderSchema(false);
        settings.setRenderFormatted(true);
        settings.setExecuteLogging(true);
    }
}
