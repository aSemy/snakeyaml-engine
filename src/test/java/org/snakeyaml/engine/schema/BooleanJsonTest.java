/*
 * Copyright (c) 2018, SnakeYAML
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.snakeyaml.engine.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Dump;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

@org.junit.jupiter.api.Tag("fast")
public class BooleanJsonTest {

  Load loader = new Load(LoadSettings.builder().build());

  @Test
  void parseBoolean() {
    assertEquals(Boolean.TRUE, loader.loadFromString("true"));
    assertEquals(Boolean.FALSE, loader.loadFromString("false"));
    assertEquals("False", loader.loadFromString("False"));
    assertEquals("True", loader.loadFromString("True"));
    // the ! non-specific tag
    assertEquals("true", loader.loadFromString("! true"));
  }

  @Test
  void dumpBoolean() {
    Dump dumper = new Dump(DumpSettings.builder().build());
    assertEquals("true\n", dumper.dumpToString(Boolean.TRUE));
    assertEquals("false\n", dumper.dumpToString(Boolean.FALSE));
  }
}
