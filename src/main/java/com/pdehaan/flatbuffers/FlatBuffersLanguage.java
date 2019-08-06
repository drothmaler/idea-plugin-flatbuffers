package com.pdehaan.flatbuffers;

import com.intellij.lang.Language;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersLanguage extends Language
{
    public static final FlatBuffersLanguage INSTANCE = new FlatBuffersLanguage();

    private FlatBuffersLanguage()
    {
        super("flatbuffers");
    }
}
