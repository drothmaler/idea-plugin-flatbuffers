package com.pdehaan.flatbuffers;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.pdehaan.flatbuffers.lexer.FlatBuffersLexerAdapter;
import com.pdehaan.flatbuffers.psi.FlatBuffersTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersSyntaxHighligher extends SyntaxHighlighterBase
{
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static
    {
        fillMap(ATTRIBUTES, createTextAttributesKey("FB_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT),
            FlatBuffersTypes.COMMENT
        );

        fillMap(ATTRIBUTES, createTextAttributesKey("FB_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD),
            FlatBuffersTypes.INCLUDE,
            FlatBuffersTypes.NAMESPACE,
            FlatBuffersTypes.TABLE,
            FlatBuffersTypes.STRUCT,
            FlatBuffersTypes.UNION,
            FlatBuffersTypes.ENUM,
            FlatBuffersTypes.ATTRIBUTE,
            FlatBuffersTypes.ROOT_TYPE,
            // built-in types
            FlatBuffersTypes.BOOL,
            FlatBuffersTypes.BYTE,
            FlatBuffersTypes.UBYTE,
            FlatBuffersTypes.SHORT,
            FlatBuffersTypes.USHORT,
            FlatBuffersTypes.INT,
            FlatBuffersTypes.UINT,
            FlatBuffersTypes.LONG,
            FlatBuffersTypes.ULONG,
            FlatBuffersTypes.FLOAT,
            FlatBuffersTypes.DOUBLE,
            FlatBuffersTypes.STRING
        );

        fillMap(ATTRIBUTES, createTextAttributesKey("FB_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING),
            FlatBuffersTypes.STRING_LITERAL
        );

        fillMap(ATTRIBUTES, createTextAttributesKey("FB_NUMERIC_LITERAL", DefaultLanguageHighlighterColors.NUMBER),
            FlatBuffersTypes.INTEGER_LITERAL,
            FlatBuffersTypes.FLOAT_LITERAL
        );
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer()
    {
        return new FlatBuffersLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
    {
        return pack(ATTRIBUTES.get(tokenType));
    }
}
