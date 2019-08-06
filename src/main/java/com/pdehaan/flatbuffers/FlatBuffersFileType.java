package com.pdehaan.flatbuffers;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersFileType extends LanguageFileType
{
    public static final FlatBuffersFileType INSTANCE = new FlatBuffersFileType();

    private FlatBuffersFileType()
    {
        super(FlatBuffersLanguage.INSTANCE);
    }

    @NotNull @Override public String getName()
    {
        return "FlatBuffers file";
    }

    @NotNull @Override public String getDescription()
    {
        return "FlatBuffers IDL file";
    }

    @NotNull @Override public String getDefaultExtension()
    {
        return "fbs";
    }

    @Nullable @Override public Icon getIcon()
    {
        return null;
    }
}
