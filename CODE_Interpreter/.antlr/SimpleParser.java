// Generated from c:\Users\Potato\Documents\Programming Languages\CODE-GroupPascal\CODE_Interpreter\Simple.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, BEGIN=26, END=27, NEWLINEOP=28, DATATYPE=29, BOOLVAL=30, CHARVAL=31, 
		INTEGERVAL=32, FLOATVAL=33, STRINGVAL=34, WS=35, NEWLINE=36, FUNCTIONNAME=37, 
		VARIABLENAME=38, COMMENT=39;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_statement = 2, RULE_condstmt = 3, 
		RULE_ifstmt = 4, RULE_elseifstmt = 5, RULE_elsestmt = 6, RULE_vardec = 7, 
		RULE_assign = 8, RULE_assignList = 9, RULE_functionCall = 10, RULE_declaratorlist = 11, 
		RULE_declarator = 12, RULE_constant = 13, RULE_value = 14, RULE_mulDivOp = 15, 
		RULE_addMinOp = 16, RULE_compareOp = 17, RULE_logicalOp = 18, RULE_concOp = 19, 
		RULE_assignOp = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "statement", "condstmt", "ifstmt", "elseifstmt", 
			"elsestmt", "vardec", "assign", "assignList", "functionCall", "declaratorlist", 
			"declarator", "constant", "value", "mulDivOp", "addMinOp", "compareOp", 
			"logicalOp", "concOp", "assignOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'IF'", "'('", "')'", "'BEGIN IF'", "'END IF'", "'ELSE IF'", "'ELSE'", 
			"'='", "': '", "','", "'*'", "'/'", "'%'", "'+'", "'-'", "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'<>'", "'AND'", "'OR'", "'NOT'", "'&'", "'BEGIN CODE'", 
			"'END CODE'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "BEGIN", "END", "NEWLINEOP", "DATATYPE", "BOOLVAL", "CHARVAL", 
			"INTEGERVAL", "FLOATVAL", "STRINGVAL", "WS", "NEWLINE", "FUNCTIONNAME", 
			"VARIABLENAME", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(SimpleParser.BEGIN, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode END() { return getToken(SimpleParser.END, 0); }
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<TerminalNode> COMMENT() { return getTokens(SimpleParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(SimpleParser.COMMENT, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==COMMENT) {
				{
				{
				setState(42);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(BEGIN);
			setState(49);
			match(NEWLINE);
			setState(50);
			statements();
			setState(51);
			match(END);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==COMMENT) {
				{
				{
				setState(52);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << DATATYPE) | (1L << FUNCTIONNAME) | (1L << VARIABLENAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(SimpleParser.NEWLINE, 0); }
		public VardecContext vardec() {
			return getRuleContext(VardecContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CondstmtContext condstmt() {
			return getRuleContext(CondstmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATATYPE:
				{
				setState(65);
				vardec();
				}
				break;
			case VARIABLENAME:
				{
				setState(66);
				assign();
				}
				break;
			case FUNCTIONNAME:
				{
				setState(67);
				functionCall();
				}
				break;
			case T__0:
				{
				setState(68);
				condstmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(71);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondstmtContext extends ParserRuleContext {
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public List<ElseifstmtContext> elseifstmt() {
			return getRuleContexts(ElseifstmtContext.class);
		}
		public ElseifstmtContext elseifstmt(int i) {
			return getRuleContext(ElseifstmtContext.class,i);
		}
		public List<ElsestmtContext> elsestmt() {
			return getRuleContexts(ElsestmtContext.class);
		}
		public ElsestmtContext elsestmt(int i) {
			return getRuleContext(ElsestmtContext.class,i);
		}
		public CondstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condstmt; }
	}

	public final CondstmtContext condstmt() throws RecognitionException {
		CondstmtContext _localctx = new CondstmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			ifstmt();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(74);
				elseifstmt();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(80);
				elsestmt();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstmtContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(SimpleParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(SimpleParser.COMMENT, i);
		}
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifstmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__0);
			setState(87);
			match(T__1);
			setState(88);
			value(0);
			setState(89);
			match(T__2);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==COMMENT) {
				{
				{
				setState(90);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(T__3);
			setState(97);
			match(NEWLINE);
			setState(98);
			statements();
			setState(99);
			match(T__4);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseifstmtContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(SimpleParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(SimpleParser.COMMENT, i);
		}
		public ElseifstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifstmt; }
	}

	public final ElseifstmtContext elseifstmt() throws RecognitionException {
		ElseifstmtContext _localctx = new ElseifstmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elseifstmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__5);
			setState(107);
			match(T__1);
			setState(108);
			value(0);
			setState(109);
			match(T__2);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==COMMENT) {
				{
				{
				setState(110);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(T__3);
			setState(117);
			match(NEWLINE);
			setState(118);
			statements();
			setState(119);
			match(T__4);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(120);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElsestmtContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(SimpleParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(SimpleParser.COMMENT, i);
		}
		public ElsestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestmt; }
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_elsestmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__6);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE || _la==COMMENT) {
				{
				{
				setState(127);
				_la = _input.LA(1);
				if ( !(_la==NEWLINE || _la==COMMENT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__3);
			setState(134);
			match(NEWLINE);
			setState(135);
			statements();
			setState(136);
			match(T__4);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					_la = _input.LA(1);
					if ( !(_la==NEWLINE || _la==COMMENT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardecContext extends ParserRuleContext {
		public TerminalNode DATATYPE() { return getToken(SimpleParser.DATATYPE, 0); }
		public DeclaratorlistContext declaratorlist() {
			return getRuleContext(DeclaratorlistContext.class,0);
		}
		public VardecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardec; }
	}

	public final VardecContext vardec() throws RecognitionException {
		VardecContext _localctx = new VardecContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_vardec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(DATATYPE);
			setState(144);
			declaratorlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public AssignListContext assignList() {
			return getRuleContext(AssignListContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			assignList();
			setState(147);
			match(T__7);
			setState(148);
			value(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignListContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLENAME() { return getTokens(SimpleParser.VARIABLENAME); }
		public TerminalNode VARIABLENAME(int i) {
			return getToken(SimpleParser.VARIABLENAME, i);
		}
		public AssignListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignList; }
	}

	public final AssignListContext assignList() throws RecognitionException {
		AssignListContext _localctx = new AssignListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(VARIABLENAME);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					match(T__7);
					setState(152);
					match(VARIABLENAME);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode FUNCTIONNAME() { return getToken(SimpleParser.FUNCTIONNAME, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(FUNCTIONNAME);
			setState(159);
			match(T__8);
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(160);
				value(0);
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(161);
						match(T__9);
						setState(162);
						value(0);
						}
						} 
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorlistContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public DeclaratorlistContext declaratorlist() {
			return getRuleContext(DeclaratorlistContext.class,0);
		}
		public DeclaratorlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaratorlist; }
	}

	public final DeclaratorlistContext declaratorlist() throws RecognitionException {
		DeclaratorlistContext _localctx = new DeclaratorlistContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_declaratorlist);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				declarator();
				setState(172);
				match(T__9);
				setState(173);
				declaratorlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public TerminalNode VARIABLENAME() { return getToken(SimpleParser.VARIABLENAME, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declarator);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(VARIABLENAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(VARIABLENAME);
				setState(179);
				match(T__7);
				setState(180);
				value(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTEGERVAL() { return getToken(SimpleParser.INTEGERVAL, 0); }
		public TerminalNode FLOATVAL() { return getToken(SimpleParser.FLOATVAL, 0); }
		public TerminalNode CHARVAL() { return getToken(SimpleParser.CHARVAL, 0); }
		public TerminalNode BOOLVAL() { return getToken(SimpleParser.BOOLVAL, 0); }
		public TerminalNode STRINGVAL() { return getToken(SimpleParser.STRINGVAL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLVAL) | (1L << CHARVAL) | (1L << INTEGERVAL) | (1L << FLOATVAL) | (1L << STRINGVAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantExpressionContext extends ValueContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class AdditiveExpressionContext extends ValueContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public AddMinOpContext addMinOp() {
			return getRuleContext(AddMinOpContext.class,0);
		}
		public AdditiveExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallExpressionContext extends ValueContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesisExpressionContext extends ValueContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ParenthesisExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ComparisonExpressionContext extends ValueContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public CompareOpContext compareOp() {
			return getRuleContext(CompareOpContext.class,0);
		}
		public ComparisonExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class MultiplicativeExpressionContext extends ValueContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public MulDivOpContext mulDivOp() {
			return getRuleContext(MulDivOpContext.class,0);
		}
		public MultiplicativeExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class VariablenameExpressionContext extends ValueContext {
		public TerminalNode VARIABLENAME() { return getToken(SimpleParser.VARIABLENAME, 0); }
		public VariablenameExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class LogicalExpressionContext extends ValueContext {
		public LogicalOpContext logicalOp() {
			return getRuleContext(LogicalOpContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public LogicalExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class NewlineopExpressionContext extends ValueContext {
		public TerminalNode NEWLINEOP() { return getToken(SimpleParser.NEWLINEOP, 0); }
		public NewlineopExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ChoyensContext extends ValueContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public ChoyensContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ConcatenateExpressionContext extends ValueContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ConcOpContext concOp() {
			return getRuleContext(ConcOpContext.class,0);
		}
		public ConcatenateExpressionContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		return value(0);
	}

	private ValueContext value(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueContext _localctx = new ValueContext(_ctx, _parentState);
		ValueContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_value, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new ConstantExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				constant();
				}
				break;
			case 2:
				{
				_localctx = new VariablenameExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187);
				match(VARIABLENAME);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new LogicalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189);
				logicalOp();
				setState(190);
				value(8);
				}
				break;
			case 5:
				{
				_localctx = new NewlineopExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(NEWLINEOP);
				}
				break;
			case 6:
				{
				_localctx = new ChoyensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				declarator();
				}
				break;
			case 7:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(T__1);
				setState(195);
				value(0);
				setState(196);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(220);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ComparisonExpressionContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(200);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(201);
						compareOp();
						setState(202);
						value(10);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(204);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(205);
						logicalOp();
						setState(206);
						value(8);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(208);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(209);
						mulDivOp();
						setState(210);
						value(7);
						}
						break;
					case 4:
						{
						_localctx = new AdditiveExpressionContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(212);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(213);
						addMinOp();
						setState(214);
						value(6);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenateExpressionContext(new ValueContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_value);
						setState(216);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(217);
						concOp();
						setState(218);
						value(5);
						}
						break;
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulDivOpContext extends ParserRuleContext {
		public MulDivOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivOp; }
	}

	public final MulDivOpContext mulDivOp() throws RecognitionException {
		MulDivOpContext _localctx = new MulDivOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mulDivOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddMinOpContext extends ParserRuleContext {
		public AddMinOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMinOp; }
	}

	public final AddMinOpContext addMinOp() throws RecognitionException {
		AddMinOpContext _localctx = new AddMinOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_addMinOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompareOpContext extends ParserRuleContext {
		public CompareOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOp; }
	}

	public final CompareOpContext compareOp() throws RecognitionException {
		CompareOpContext _localctx = new CompareOpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compareOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicalOpContext extends ParserRuleContext {
		public LogicalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOp; }
	}

	public final LogicalOpContext logicalOp() throws RecognitionException {
		LogicalOpContext _localctx = new LogicalOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_logicalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcOpContext extends ParserRuleContext {
		public ConcOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concOp; }
	}

	public final ConcOpContext concOp() throws RecognitionException {
		ConcOpContext _localctx = new ConcOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_concOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignOpContext extends ParserRuleContext {
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignOp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return value_sempred((ValueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean value_sempred(ValueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\2\3\2\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\3\6\3@\n\3\r\3"+
		"\16\3A\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\5\3\5\7\5N\n\5\f\5\16\5Q\13"+
		"\5\3\5\7\5T\n\5\f\5\16\5W\13\5\3\6\3\6\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a"+
		"\13\6\3\6\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\7\7r\n\7\f\7\16\7u\13\7\3\7\3\7\3\7\3\7\3\7\7\7|\n\7\f\7\16\7\177\13"+
		"\7\3\b\3\b\7\b\u0083\n\b\f\b\16\b\u0086\13\b\3\b\3\b\3\b\3\b\3\b\7\b\u008d"+
		"\n\b\f\b\16\b\u0090\13\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7"+
		"\13\u009c\n\13\f\13\16\13\u009f\13\13\3\f\3\f\3\f\3\f\3\f\7\f\u00a6\n"+
		"\f\f\f\16\f\u00a9\13\f\5\f\u00ab\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00b2\n\r"+
		"\3\16\3\16\3\16\3\16\5\16\u00b8\n\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c9\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00df\n\20\f\20\16\20\u00e2\13\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\2\3\36\27\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\b\4\2&&))\3\2 $\3\2\r\17\3\2\20"+
		"\21\3\2\22\27\3\2\30\32\2\u00f8\2/\3\2\2\2\4?\3\2\2\2\6G\3\2\2\2\bK\3"+
		"\2\2\2\nX\3\2\2\2\fl\3\2\2\2\16\u0080\3\2\2\2\20\u0091\3\2\2\2\22\u0094"+
		"\3\2\2\2\24\u0098\3\2\2\2\26\u00a0\3\2\2\2\30\u00b1\3\2\2\2\32\u00b7\3"+
		"\2\2\2\34\u00b9\3\2\2\2\36\u00c8\3\2\2\2 \u00e3\3\2\2\2\"\u00e5\3\2\2"+
		"\2$\u00e7\3\2\2\2&\u00e9\3\2\2\2(\u00eb\3\2\2\2*\u00ed\3\2\2\2,.\t\2\2"+
		"\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2"+
		"\2\62\63\7\34\2\2\63\64\7&\2\2\64\65\5\4\3\2\659\7\35\2\2\668\t\2\2\2"+
		"\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7"+
		"\2\2\3=\3\3\2\2\2>@\5\6\4\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\5"+
		"\3\2\2\2CH\5\20\t\2DH\5\22\n\2EH\5\26\f\2FH\5\b\5\2GC\3\2\2\2GD\3\2\2"+
		"\2GE\3\2\2\2GF\3\2\2\2HI\3\2\2\2IJ\7&\2\2J\7\3\2\2\2KO\5\n\6\2LN\5\f\7"+
		"\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PU\3\2\2\2QO\3\2\2\2RT\5\16"+
		"\b\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\t\3\2\2\2WU\3\2\2\2XY\7"+
		"\3\2\2YZ\7\4\2\2Z[\5\36\20\2[_\7\5\2\2\\^\t\2\2\2]\\\3\2\2\2^a\3\2\2\2"+
		"_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\6\2\2cd\7&\2\2de\5\4\3\2"+
		"ei\7\7\2\2fh\t\2\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\13\3\2\2"+
		"\2ki\3\2\2\2lm\7\b\2\2mn\7\4\2\2no\5\36\20\2os\7\5\2\2pr\t\2\2\2qp\3\2"+
		"\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\6\2\2wx\7&"+
		"\2\2xy\5\4\3\2y}\7\7\2\2z|\t\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~"+
		"\3\2\2\2~\r\3\2\2\2\177}\3\2\2\2\u0080\u0084\7\t\2\2\u0081\u0083\t\2\2"+
		"\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\6\2\2\u0088"+
		"\u0089\7&\2\2\u0089\u008a\5\4\3\2\u008a\u008e\7\7\2\2\u008b\u008d\t\2"+
		"\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\17\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\37\2"+
		"\2\u0092\u0093\5\30\r\2\u0093\21\3\2\2\2\u0094\u0095\5\24\13\2\u0095\u0096"+
		"\7\n\2\2\u0096\u0097\5\36\20\2\u0097\23\3\2\2\2\u0098\u009d\7(\2\2\u0099"+
		"\u009a\7\n\2\2\u009a\u009c\7(\2\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\25\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u00a0\u00a1\7\'\2\2\u00a1\u00aa\7\13\2\2\u00a2\u00a7\5\36\20"+
		"\2\u00a3\u00a4\7\f\2\2\u00a4\u00a6\5\36\20\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\27\3\2\2\2\u00ac\u00b2\5\32\16\2\u00ad\u00ae\5\32\16\2\u00ae\u00af\7"+
		"\f\2\2\u00af\u00b0\5\30\r\2\u00b0\u00b2\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b1"+
		"\u00ad\3\2\2\2\u00b2\31\3\2\2\2\u00b3\u00b8\7(\2\2\u00b4\u00b5\7(\2\2"+
		"\u00b5\u00b6\7\n\2\2\u00b6\u00b8\5\36\20\2\u00b7\u00b3\3\2\2\2\u00b7\u00b4"+
		"\3\2\2\2\u00b8\33\3\2\2\2\u00b9\u00ba\t\3\2\2\u00ba\35\3\2\2\2\u00bb\u00bc"+
		"\b\20\1\2\u00bc\u00c9\5\34\17\2\u00bd\u00c9\7(\2\2\u00be\u00c9\5\26\f"+
		"\2\u00bf\u00c0\5&\24\2\u00c0\u00c1\5\36\20\n\u00c1\u00c9\3\2\2\2\u00c2"+
		"\u00c9\7\36\2\2\u00c3\u00c9\5\32\16\2\u00c4\u00c5\7\4\2\2\u00c5\u00c6"+
		"\5\36\20\2\u00c6\u00c7\7\5\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00bb\3\2\2\2"+
		"\u00c8\u00bd\3\2\2\2\u00c8\u00be\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c2"+
		"\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c4\3\2\2\2\u00c9\u00e0\3\2\2\2\u00ca"+
		"\u00cb\f\13\2\2\u00cb\u00cc\5$\23\2\u00cc\u00cd\5\36\20\f\u00cd\u00df"+
		"\3\2\2\2\u00ce\u00cf\f\t\2\2\u00cf\u00d0\5&\24\2\u00d0\u00d1\5\36\20\n"+
		"\u00d1\u00df\3\2\2\2\u00d2\u00d3\f\b\2\2\u00d3\u00d4\5 \21\2\u00d4\u00d5"+
		"\5\36\20\t\u00d5\u00df\3\2\2\2\u00d6\u00d7\f\7\2\2\u00d7\u00d8\5\"\22"+
		"\2\u00d8\u00d9\5\36\20\b\u00d9\u00df\3\2\2\2\u00da\u00db\f\6\2\2\u00db"+
		"\u00dc\5(\25\2\u00dc\u00dd\5\36\20\7\u00dd\u00df\3\2\2\2\u00de\u00ca\3"+
		"\2\2\2\u00de\u00ce\3\2\2\2\u00de\u00d2\3\2\2\2\u00de\u00d6\3\2\2\2\u00de"+
		"\u00da\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\37\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\t\4\2\2\u00e4!\3"+
		"\2\2\2\u00e5\u00e6\t\5\2\2\u00e6#\3\2\2\2\u00e7\u00e8\t\6\2\2\u00e8%\3"+
		"\2\2\2\u00e9\u00ea\t\7\2\2\u00ea\'\3\2\2\2\u00eb\u00ec\7\33\2\2\u00ec"+
		")\3\2\2\2\u00ed\u00ee\7\n\2\2\u00ee+\3\2\2\2\26/9AGOU_is}\u0084\u008e"+
		"\u009d\u00a7\u00aa\u00b1\u00b7\u00c8\u00de\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}