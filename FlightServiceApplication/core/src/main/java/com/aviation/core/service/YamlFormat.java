package com.aviation.core.service;

import org.yaml.snakeyaml.Yaml;

public class YamlFormat {

    private Yaml yaml;

    public YamlFormat() {
        this.yaml = new Yaml();
    }

    public String convertToYaml(Object object) {
        return yaml.dump(object);
    }
}
