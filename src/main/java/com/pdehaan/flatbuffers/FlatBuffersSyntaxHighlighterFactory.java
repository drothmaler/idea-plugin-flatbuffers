package com.pdehaan.flatbuffers;

import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersSyntaxHighlighterFactory extends SyntaxHighlighterFactory
{
    @NotNull @Override public SyntaxHighlighter getSyntaxHighlighter(@Nullable Project project,
            @Nullable VirtualFile virtualFile)
    {
        return new FlatBuffersSyntaxHighligher();
    }
}
