package ru.job4j.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        String driver = properties.getProperty("hibernate.connection.driver_class");
        Class.forName(driver);
        connection =  DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
                String sql = String.format("create table if not exists %s();", tableName);
                generalMethod(sql);
    }


    public void dropTable(String tableName) throws Exception {
                String sql = String.format("drop table %s", tableName);
                generalMethod(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
                String sql = String.format("alter table %s add column %s %s;",
                        tableName, columnName, type);
        generalMethod(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
                String sql = String.format("alter table %s drop column %s;",
                        tableName, columnName);
        generalMethod(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
                String sql = String.format("alter table %s rename column %s to %s;",
                        tableName, columnName, newColumnName);
        generalMethod(sql);
    }
    private void generalMethod(String string) throws Exception {
            try (Statement statement = this.connection.createStatement()) {
                statement.execute(string);
            }
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
        String tableName = "new_table";
        String columnName = "new_column";
        String newColumnName = "new_column2";
        String typeName = "text";
        String path = "app.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable(tableName);
        System.out.println(getTableScheme(tableEditor.connection, tableName));
        tableEditor.dropTable(tableName);
        System.out.println(getTableScheme(tableEditor.connection, tableName));
        tableEditor.addColumn(tableName, columnName, typeName);
        System.out.println(getTableScheme(tableEditor.connection, tableName));
        tableEditor.dropColumn(tableName, columnName);
        System.out.println(getTableScheme(tableEditor.connection, tableName));
        tableEditor.renameColumn(tableName, columnName, newColumnName);
        System.out.println(getTableScheme(tableEditor.connection, tableName));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
