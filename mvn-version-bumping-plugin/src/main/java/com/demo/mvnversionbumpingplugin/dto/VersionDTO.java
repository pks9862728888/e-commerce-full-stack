package com.demo.mvnversionbumpingplugin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.StringUtils;

@Getter
@Setter
@Builder
@Slf4j
public class VersionDTO {
    private int majorVersion;
    private int minorVersion;
    private int patchVersion;
    private String suffix;

    public void bumpMajor() {
        log.info("Major version bumped!");
        this.majorVersion++;
    }

    public void bumpMinor() {
        log.info("Minor version bumped!");
        this.minorVersion++;
    }

    public void bumpPatch() {
        log.info("Patch version bumped!");
        this.patchVersion++;
    }

    @Override
    public String toString() {
        if (StringUtils.isEmpty(suffix) || suffix.equals("EMPTY")) {
            return String.format("%s.%s.%s", majorVersion, minorVersion, patchVersion);
        } else {
            return String.format("%s.%s.%s-%s", majorVersion, minorVersion, patchVersion, suffix);
        }
    }
}
