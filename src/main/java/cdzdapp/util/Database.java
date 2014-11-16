package cdzdapp.util;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public boolean canConnect() {
        try (Connection connection = getDataSource().getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM USER")) {
                statement.executeQuery();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
