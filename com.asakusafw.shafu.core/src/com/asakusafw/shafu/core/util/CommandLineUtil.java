/**
 * Copyright 2013-2018 Asakusa Framework Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asakusafw.shafu.core.util;

import java.util.List;

/**
 * Utilities for command lines.
 * @since 0.2.4
 * @version 0.4.3
 */
public final class CommandLineUtil {

    /**
     * Extracts and returns the Gradle tasks names from the command line string.
     * @param commandLine the command line string
     * @return the parsed tokens
     * @deprecated Use {@link GradleArguments} instead
     */
    @Deprecated
    public static List<String> parseGradleTaskNames(String commandLine) {
        return GradleArguments.parse(commandLine).getTaskNames();
    }

    /**
     * Extracts and returns the Gradle build arguments from the command line string.
     * @param commandLine the command line string
     * @return the parsed tokens
     * @deprecated Use {@link GradleArguments} instead
     */
    @Deprecated
    public static List<String> parseGradleBuildArguments(String commandLine) {
        return GradleArguments.parse(commandLine).getGradleOptions();
    }

    /**
     * Extracts and returns the instant Gradle version from the command line string.
     * @param commandLine the command line string
     * @return the parsed version, or {@code null} if it is not found
     * @since 0.4.3
     * @deprecated Use {@link GradleArguments} instead
     */
    @Deprecated
    public static String parseGradleVersion(String commandLine) {
        return GradleArguments.parse(commandLine).getGradleVersion();
    }

    /**
     * Parses the command line.
     * @param commandLine the command line
     * @return the parsed tokens
     * @deprecated Use {@link GradleArguments} instead
     */
    @Deprecated
    public static List<String> parseCommandLineTokens(String commandLine) {
        return GradleArguments.parseTokens(commandLine);
    }
}
