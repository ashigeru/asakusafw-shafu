/**
 * Copyright 2013 Asakusa Framework Team.
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
package com.asakusafw.shafu.internal.ui.preferences;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.asakusafw.shafu.internal.ui.Activator;
import com.asakusafw.shafu.internal.ui.LogUtil;

/**
 * Represents a log level property value.
 */
public enum GradleLogLevel implements GradleOption {

    /**
     * Quiet level.
     */
    QUIET(Messages.GradleLogLevel_quietDescription, new String[] {
            "--quiet", //$NON-NLS-1$
    }),

    /**
     * Normal level.
     */
    LIFECYCLE(Messages.GradleLogLevel_lifecycleDescription),

    /**
     * Info level.
     */
    INFO(Messages.GradleLogLevel_infoDescription, new String[] {
            "--info", //$NON-NLS-1$
    }),

    /**
     * Debug level.
     */
    DEBUG(Messages.GradleLogLevel_debugDescription, new String[] {
            "--debug", //$NON-NLS-1$
    }),

    ;

    private final String description;

    private final List<String> arguments;

    private GradleLogLevel(String description, String... arguments) {
        this.description = description;
        this.arguments = Collections.unmodifiableList(Arrays.asList(arguments));
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSymbol() {
        return this.name();
    }

    /**
     * Returns a constants for the target symbol.
     * @param symbol the target symbol
     * @return the corresponded constant, or {@link #LIFECYCLE} if the target symbol is not supported
     */
    public static GradleLogLevel fromSymbol(String symbol) {
        try {
            return GradleLogLevel.valueOf(symbol);
        } catch (IllegalArgumentException e) {
            LogUtil.log(new Status(
                    IStatus.WARNING,
                    Activator.PLUGIN_ID,
                    MessageFormat.format(
                            "Symbol \"{1}\" is not defined in \"{0}\"", //$NON-NLS-1$
                            GradleLogLevel.class.getName(),
                            symbol)));
            return LIFECYCLE;
        }
    }

    @Override
    public List<String> getArguments() {
        return arguments;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
