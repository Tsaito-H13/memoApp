package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//DB接続情報をプロパティーファイルから取得するクラス　WEB-INF/classes配下に置かれているdb.propertiesを読み込む
public class DBProperties {
    private static Properties properties = new Properties();

    static {
        try (InputStream is = DBProperties.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUser() {
        return properties.getProperty("user");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}