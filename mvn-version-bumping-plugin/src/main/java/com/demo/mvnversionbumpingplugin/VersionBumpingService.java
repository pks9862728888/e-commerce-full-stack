package com.demo.mvnversionbumpingplugin;

import com.demo.mvnversionbumpingplugin.config.VersionConfig;
import com.demo.mvnversionbumpingplugin.dto.VersionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class VersionBumpingService {

    @Autowired
    private VersionConfig versionConfig;

    public Optional<String> getBumpedVersionIfPossible(String currVersion) {
        // Parse current version
        Optional<VersionDTO> currentVersion = parseCurrentVersionPattern1(currVersion);
        if (currentVersion.isEmpty()) {
            currentVersion = parseCurrentVersionPattern2(currVersion);
        }

        // Bump version
        return currentVersion.map(this::bumpVersion);
    }

    private String bumpVersion(VersionDTO versionDTO) {
        if (versionConfig.getBumpMajor()) {
            versionDTO.bumpMajor();
        }
        if (versionConfig.getBumpMinor()) {
            versionDTO.bumpMinor();
        }
        if (versionConfig.getBumpPatch()) {
            versionDTO.bumpPatch();
        }
        versionDTO.setSuffix(versionConfig.getSuffix());
        return versionDTO.toString();
    }

    private Optional<VersionDTO> parseCurrentVersionPattern1(String currVersion) {
        Pattern pattern = Pattern.compile("(?<MAJOR>\\d)+.(?<MINOR>\\d)+.(?<PATCH>\\d)+");
        Matcher matcher = pattern.matcher(currVersion);
        try {
            if (matcher.matches()) {
                return Optional.of(VersionDTO.builder()
                        .majorVersion(Integer.parseInt(matcher.group("MAJOR").trim()))
                        .minorVersion(Integer.parseInt(matcher.group("MINOR").trim()))
                        .minorVersion(Integer.parseInt(matcher.group("PATCH").trim()))
                        .build());
            }
        } catch (Exception e) {
            log.error("Exception occurred while parsing using pattern1: MAJOR.MINOR.PATCH - {} ex: {}",
                    currVersion, e.toString());
        }
        return Optional.empty();
    }

    private Optional<VersionDTO> parseCurrentVersionPattern2(String currVersion) {
        Pattern pattern = Pattern.compile("(?<MAJOR>\\d)+.(?<MINOR>\\d)+.(?<PATCH>\\d)+-(?<SUFFIX>\\d)+");
        Matcher matcher = pattern.matcher(currVersion);
        try {
            if (matcher.matches()) {
                return Optional.of(VersionDTO.builder()
                        .majorVersion(Integer.parseInt(matcher.group("MAJOR").trim()))
                        .minorVersion(Integer.parseInt(matcher.group("MINOR").trim()))
                        .minorVersion(Integer.parseInt(matcher.group("PATCH").trim()))
                        .suffix(matcher.group("SUFFIX").trim())
                        .build());
            }
        } catch (Exception e) {
            log.error("Exception occurred while parsing using pattern2: MAJOR.MINOR.PATCH-SUFFIX - {} ex: {}",
                    currVersion, e.toString());
        }
        return Optional.empty();
    }
}
