package com.pdehaan.flatbuffers;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersFile extends PsiFileBase
{
    protected FlatBuffersFile(@NotNull FileViewProvider fileViewProvider)
    {
        super(fileViewProvider, FlatBuffersLanguage.INSTANCE);
    }

    @NotNull @Override public FileType getFileType()
    {
        return FlatBuffersFileType.INSTANCE;
    }
}
