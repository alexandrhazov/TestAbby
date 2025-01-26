package Helpers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    default Config loadConfig() {
        return ConfigFactory.load("application.conf");
    }

    default String getBaseUrl() {
        return loadConfig().getString("baseUrl");
    }
}

