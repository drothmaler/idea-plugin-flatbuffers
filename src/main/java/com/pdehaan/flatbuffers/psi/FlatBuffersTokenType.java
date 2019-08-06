package com.pdehaan.flatbuffers.psi;

import com.intellij.psi.tree.IElementType;
import com.pdehaan.flatbuffers.FlatBuffersLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersTokenType extends IElementType
{
    public FlatBuffersTokenType(@NotNull @NonNls String debugName)
    {
        super(debugName, FlatBuffersLanguage.INSTANCE);
    }

    @Override
    public String toString()
    {
        return "FlatBuffersTokenType." + super.toString();
    }
}
