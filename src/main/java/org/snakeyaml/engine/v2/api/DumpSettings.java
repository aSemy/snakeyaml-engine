/**
 * Copyright (c) 2018, http://www.snakeyaml.org
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snakeyaml.engine.v2.api;

import org.snakeyaml.engine.v2.common.FlowStyle;
import org.snakeyaml.engine.v2.common.NonPrintableStyle;
import org.snakeyaml.engine.v2.common.ScalarStyle;
import org.snakeyaml.engine.v2.common.SpecVersion;
import org.snakeyaml.engine.v2.nodes.Tag;
import org.snakeyaml.engine.v2.resolver.ScalarResolver;
import org.snakeyaml.engine.v2.serializer.AnchorGenerator;

import java.util.Map;
import java.util.Optional;

/**
 * Fine tuning serializing/dumping
 * Description for all the fields can be found in the builder
 */
public final class DumpSettings {
    private final boolean explicitStart;
    private final boolean explicitEnd;
    private final NonPrintableStyle nonPrintableStyle;
    private final Optional<Tag> explicitRootTag;
    private final AnchorGenerator anchorGenerator;
    private final Optional<SpecVersion> yamlDirective;
    private final Map<String, String> tagDirective;
    private final ScalarResolver scalarResolver;
    private final FlowStyle defaultFlowStyle;
    private final ScalarStyle defaultScalarStyle;

    //emitter
    private final boolean canonical;
    private final boolean multiLineFlow;
    private final boolean useUnicodeEncoding;
    private final int indent;
    private final int indicatorIndent;
    private final int width;
    private final String bestLineBreak;
    private final boolean splitLines;
    private final int maxSimpleKeyLength;

    //general
    private final Map<SettingKey, Object> customProperties;

    DumpSettings(boolean explicitStart, boolean explicitEnd, Optional<Tag> explicitRootTag,
                 AnchorGenerator anchorGenerator, Optional<SpecVersion> yamlDirective, Map<String, String> tagDirective,
                 ScalarResolver scalarResolver, FlowStyle defaultFlowStyle, ScalarStyle defaultScalarStyle,
                 NonPrintableStyle nonPrintableStyle,
                 //emitter
                 boolean canonical, boolean multiLineFlow, boolean useUnicodeEncoding,
                 int indent, int indicatorIndent, int width, String bestLineBreak, boolean splitLines, int maxSimpleKeyLength,
                 Map<SettingKey, Object> customProperties
    ) {
        this.explicitStart = explicitStart;
        this.explicitEnd = explicitEnd;
        this.nonPrintableStyle = nonPrintableStyle;
        this.explicitRootTag = explicitRootTag;
        this.anchorGenerator = anchorGenerator;
        this.yamlDirective = yamlDirective;
        this.tagDirective = tagDirective;
        this.scalarResolver = scalarResolver;
        this.defaultFlowStyle = defaultFlowStyle;
        this.defaultScalarStyle = defaultScalarStyle;
        this.canonical = canonical;
        this.multiLineFlow = multiLineFlow;
        this.useUnicodeEncoding = useUnicodeEncoding;
        this.indent = indent;
        this.indicatorIndent = indicatorIndent;
        this.width = width;
        this.bestLineBreak = bestLineBreak;
        this.splitLines = splitLines;
        this.maxSimpleKeyLength = maxSimpleKeyLength;
        this.customProperties = customProperties;
    }

    public static final DumpSettingsBuilder builder() {
        return new DumpSettingsBuilder();
    }

    public FlowStyle getDefaultFlowStyle() {
        return defaultFlowStyle;
    }

    public ScalarStyle getDefaultScalarStyle() {
        return defaultScalarStyle;
    }

    public boolean isExplicitStart() {
        return explicitStart;
    }

    public AnchorGenerator getAnchorGenerator() {
        return anchorGenerator;
    }

    public ScalarResolver getScalarResolver() {
        return scalarResolver;
    }

    public boolean isExplicitEnd() {
        return explicitEnd;
    }

    public Optional<Tag> getExplicitRootTag() {
        return explicitRootTag;
    }

    public Optional<SpecVersion> getYamlDirective() {
        return yamlDirective;
    }

    public Map<String, String> getTagDirective() {
        return tagDirective;
    }

    public boolean isCanonical() {
        return canonical;
    }

    public boolean isMultiLineFlow() {
        return multiLineFlow;
    }

    public boolean isUseUnicodeEncoding() {
        return useUnicodeEncoding;
    }

    public int getIndent() {
        return indent;
    }

    public int getIndicatorIndent() {
        return indicatorIndent;
    }

    public int getWidth() {
        return width;
    }

    public String getBestLineBreak() {
        return bestLineBreak;
    }

    public boolean isSplitLines() {
        return splitLines;
    }

    public int getMaxSimpleKeyLength() {
        return maxSimpleKeyLength;
    }

    public NonPrintableStyle getNonPrintableStyle() {
        return nonPrintableStyle;
    }

    public Object getCustomProperty(SettingKey key) {
        return customProperties.get(key);
    }
}

