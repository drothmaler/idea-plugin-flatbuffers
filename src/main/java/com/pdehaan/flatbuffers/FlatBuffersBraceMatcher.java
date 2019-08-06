package com.pdehaan.flatbuffers;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.pdehaan.flatbuffers.psi.FlatBuffersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by pdehaan on 8/28/16.
 */
public class FlatBuffersBraceMatcher implements PairedBraceMatcher
{
    private static final BracePair[] PAIRS = new BracePair[] {
        new BracePair(FlatBuffersTypes.OPEN_PARENTHESIS, FlatBuffersTypes.CLOSE_PARENTHESIS, false),
        new BracePair(FlatBuffersTypes.OPEN_BRACE, FlatBuffersTypes.CLOSE_BRACE, false),
        new BracePair(FlatBuffersTypes.OPEN_BLOCK, FlatBuffersTypes.CLOSE_BLOCK, false)
    };

    @Override
    public BracePair[] getPairs()
    {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(
        @NotNull IElementType iElementType,
        @Nullable IElementType iElementType1
    )
    {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile psiFile, int i)
    {
        return i;
    }
}
