package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        connection = null;
    }

    public void createTable(String tableName) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "",
                        ""
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, tableName));
            }
        }
    }


    public void dropTable(String tableName) {
    }

    public void addColumn(String tableName, String columnName, String type) {
    }

    public void dropColumn(String tableName, String columnName) {
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
    }

    private static Connection getConnection() throws Exception {
        String path = "app.properties";
        Config config = new Config(path);
        config.load();
        String url = config.value("hibernate.connection.url");
        String login = config.value("hibernate.connection.username");
        String password = config.value("hibernate.connection.password");
        String driver = config.value("hibernate.connection.driver_class");
        Class.forName(driver);
        return DriverManager.getConnection(url, login, password);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }
    public static void main(String[] args) throws Exception {
        String s = "NewTable";
        String path = "app.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
      TableEditor tableEditor = new TableEditor(properties);
      tableEditor.createTable(s);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
