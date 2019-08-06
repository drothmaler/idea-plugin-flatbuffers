package com.pdehaan.flatbuffers;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.pdehaan.flatbuffers.lexer.FlatBuffersLexerAdapter;
import com.pdehaan.flatbuffers.parser.FlatBuffersParser;
import com.pdehaan.flatbuffers.psi.FlatBuffersTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Created by pdehaan on 8/27/16.
 */
public class FlatBuffersParserDefinition implements ParserDefinition
{
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(FlatBuffersTypes.COMMENT);
    public static final TokenSet STRING_LITERALS = TokenSet.create(FlatBuffersTypes.STRING_LITERAL);

    public static final IFileElementType FILE =
            new IFileElementType(Language.findInstance(FlatBuffersLanguage.class));

    @NotNull @Override public Lexer createLexer(Project project)
    {
        return new FlatBuffersLexerAdapter();
    }

    @Override public PsiParser createParser(Project project)
    {
        return new FlatBuffersParser();
    }

    @Override public IFileElementType getFileNodeType()
    {
        return FILE;
    }

    @NotNull @Override public TokenSet getWhitespaceTokens()
    {
        return WHITE_SPACES;
    }

    @NotNull @Override public TokenSet getCommentTokens()
    {
        return COMMENTS;
    }

    @NotNull @Override public TokenSet getStringLiteralElements()
    {
        return STRING_LITERALS;
    }

    @NotNull @Override public PsiElement createElement(ASTNode astNode)
    {
        return FlatBuffersTypes.Factory.createElement(astNode);
    }

    @Override public PsiFile createFile(FileViewProvider fileViewProvider)
    {
        return new FlatBuffersFile(fileViewProvider);
    }

    @Override public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
}
