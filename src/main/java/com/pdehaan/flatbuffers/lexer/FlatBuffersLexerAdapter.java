package com.pdehaan.flatbuffers.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersLexerAdapter extends FlexAdapter
{
    public FlatBuffersLexerAdapter()
    {
        super(new FlatBuffersLexer((Reader) null));
    }
}
