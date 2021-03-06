// Copyright 2000-2017 JetBrains s.r.o.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.intellij.openapi.ui.panel;

import org.jetbrains.annotations.NotNull;

/**
 * Panel grid represents a series of panels of the same type laid out according to the
 * specific design specs (usually vertically).
 *
 * @param <T> type of a single panel builder
 */
public interface PanelGridBuilder<T extends PanelBuilder> extends PanelBuilder {
  /**
   * Adds a signle panel builder to grid.
   * @param builder signle row panel builder
   * @return <code>this</code>
   */
  PanelGridBuilder<T> add(@NotNull T builder);

  /**
   * Set to <code>true</code> if grid rows should resize vertically when the panel is resized. Grid components
   * don't resize, only grid cells are resized and components are centered vertically within the cells.
   * Set to <code>false</code> if an empty space should take all free area below the grid. This is the default
   * setting.
   * @param expand only needed to set explicitly to <code>true</code>. <code>false</code> is default.
   * @return <code>this</code>
   */
  PanelGridBuilder<T> expandVertically(boolean expand);
}
