package com.pdehaan.flatbuffers;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * Created by pdehaan on 8/28/16.
 */
public class FlatBuffersCommenter implements Commenter
{

    @Nullable
    @Override
    public String getLineCommentPrefix()
    {
        return "//";
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix()
    {
        return null;
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix()
    {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix()
    {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix()
    {
        return null;
    }
}
