/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.jetbrains.python.refactoring;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;

/**
 * @author oleg
*/
public class FileDataContext implements DataContext {
  private final PsiFile myFile;

  public FileDataContext(final PsiFile file) {
    myFile = file;
  }

  @Nullable
  public Object getData(@NonNls String dataId) {
    if (LangDataKeys.LANGUAGE.is(dataId)) {
      return myFile.getLanguage();
    }
    if (PlatformDataKeys.PROJECT.is(dataId)) {
      return myFile.getProject();
    }
    if (LangDataKeys.PSI_FILE.is(dataId)) {
      return myFile;
    }

    throw new IllegalArgumentException("Data not supported: " + dataId);
  }
}