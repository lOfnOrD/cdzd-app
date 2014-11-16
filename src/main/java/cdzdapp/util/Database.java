package cdzdapp.util;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;

public enum Database {
    INSTANCE;

    private Flyway flyway;

    private Database() {
        flyway = new Flyway();
        flyway.setDataSource(Config.INSTANCE.getDbUrl(), "SA", "");
        if (Config.INSTANCE.isDbTestData()) {
            flyway.setLocations("db/migration", "db/testdata");
        }
    }

    public void clean() {
        flyway.clean();
    }

    public void migrate() {
        flyway.migrate();
    }

    public DataSource getDataSource() {
        return flyway.getDataSource();
    }
}
