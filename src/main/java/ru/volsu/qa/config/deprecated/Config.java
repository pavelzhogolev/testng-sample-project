package ru.volsu.qa.config.deprecated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Deprecated
public class Config {

    private String baseUrl;
    private int baseTimeout;
}
