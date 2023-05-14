// Generated from c:\Users\Potato\Documents\Programming Languages\CODE-GroupPascal\CODE_Interpreter\Simple.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"BEGIN", "END", "NEWLINEOP", "DATATYPE", "BOOLVAL", "CHARVAL", "INTEGERVAL", 
			"FLOATVAL", "STRINGVAL", "WS", "NEWLINE", "FUNCTIONNAME", "VARIABLENAME", 
			"COMMENT"
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


	public SimpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0145\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00ca\n\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00d5\n\37\3 \3 \5 \u00d9\n "+
		"\3 \3 \3!\5!\u00de\n!\3!\6!\u00e1\n!\r!\16!\u00e2\3\"\5\"\u00e6\n\"\3"+
		"\"\6\"\u00e9\n\"\r\"\16\"\u00ea\3\"\3\"\5\"\u00ef\n\"\3\"\6\"\u00f2\n"+
		"\"\r\"\16\"\u00f3\3#\3#\7#\u00f8\n#\f#\16#\u00fb\13#\3#\3#\3#\7#\u0100"+
		"\n#\f#\16#\u0103\13#\3#\3#\3#\7#\u0108\n#\f#\16#\u010b\13#\3#\6#\u010e"+
		"\n#\r#\16#\u010f\5#\u0112\n#\3$\6$\u0115\n$\r$\16$\u0116\3$\3$\3%\6%\u011c"+
		"\n%\r%\16%\u011d\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u012b\n&\3\'\3\'"+
		"\7\'\u012f\n\'\f\'\16\'\u0132\13\'\3\'\3\'\7\'\u0136\n\'\f\'\16\'\u0139"+
		"\13\'\5\'\u013b\n\'\3(\3(\7(\u013f\n(\f(\16(\u0142\13(\3(\3(\2\2)\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)\3\2\f\5\2\62;C\\c|\3\2\62;\3\2$$\3\2))\3\2__\5\2\13"+
		"\13\17\17\"\"\4\2\f\f\17\17\4\2aac|\6\2\62;C\\aac|\3\2c|\2\u015b\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5T\3\2\2\2\7V\3\2"+
		"\2\2\tX\3\2\2\2\13a\3\2\2\2\rh\3\2\2\2\17p\3\2\2\2\21u\3\2\2\2\23w\3\2"+
		"\2\2\25z\3\2\2\2\27|\3\2\2\2\31~\3\2\2\2\33\u0080\3\2\2\2\35\u0082\3\2"+
		"\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008d"+
		"\3\2\2\2)\u0090\3\2\2\2+\u0093\3\2\2\2-\u0096\3\2\2\2/\u009a\3\2\2\2\61"+
		"\u009d\3\2\2\2\63\u00a1\3\2\2\2\65\u00a3\3\2\2\2\67\u00ae\3\2\2\29\u00b7"+
		"\3\2\2\2;\u00c9\3\2\2\2=\u00d4\3\2\2\2?\u00d6\3\2\2\2A\u00dd\3\2\2\2C"+
		"\u00e5\3\2\2\2E\u0111\3\2\2\2G\u0114\3\2\2\2I\u011b\3\2\2\2K\u012a\3\2"+
		"\2\2M\u013a\3\2\2\2O\u013c\3\2\2\2QR\7K\2\2RS\7H\2\2S\4\3\2\2\2TU\7*\2"+
		"\2U\6\3\2\2\2VW\7+\2\2W\b\3\2\2\2XY\7D\2\2YZ\7G\2\2Z[\7I\2\2[\\\7K\2\2"+
		"\\]\7P\2\2]^\7\"\2\2^_\7K\2\2_`\7H\2\2`\n\3\2\2\2ab\7G\2\2bc\7P\2\2cd"+
		"\7F\2\2de\7\"\2\2ef\7K\2\2fg\7H\2\2g\f\3\2\2\2hi\7G\2\2ij\7N\2\2jk\7U"+
		"\2\2kl\7G\2\2lm\7\"\2\2mn\7K\2\2no\7H\2\2o\16\3\2\2\2pq\7G\2\2qr\7N\2"+
		"\2rs\7U\2\2st\7G\2\2t\20\3\2\2\2uv\7?\2\2v\22\3\2\2\2wx\7<\2\2xy\7\"\2"+
		"\2y\24\3\2\2\2z{\7.\2\2{\26\3\2\2\2|}\7,\2\2}\30\3\2\2\2~\177\7\61\2\2"+
		"\177\32\3\2\2\2\u0080\u0081\7\'\2\2\u0081\34\3\2\2\2\u0082\u0083\7-\2"+
		"\2\u0083\36\3\2\2\2\u0084\u0085\7/\2\2\u0085 \3\2\2\2\u0086\u0087\7@\2"+
		"\2\u0087\"\3\2\2\2\u0088\u0089\7>\2\2\u0089$\3\2\2\2\u008a\u008b\7@\2"+
		"\2\u008b\u008c\7?\2\2\u008c&\3\2\2\2\u008d\u008e\7>\2\2\u008e\u008f\7"+
		"?\2\2\u008f(\3\2\2\2\u0090\u0091\7?\2\2\u0091\u0092\7?\2\2\u0092*\3\2"+
		"\2\2\u0093\u0094\7>\2\2\u0094\u0095\7@\2\2\u0095,\3\2\2\2\u0096\u0097"+
		"\7C\2\2\u0097\u0098\7P\2\2\u0098\u0099\7F\2\2\u0099.\3\2\2\2\u009a\u009b"+
		"\7Q\2\2\u009b\u009c\7T\2\2\u009c\60\3\2\2\2\u009d\u009e\7P\2\2\u009e\u009f"+
		"\7Q\2\2\u009f\u00a0\7V\2\2\u00a0\62\3\2\2\2\u00a1\u00a2\7(\2\2\u00a2\64"+
		"\3\2\2\2\u00a3\u00a4\7D\2\2\u00a4\u00a5\7G\2\2\u00a5\u00a6\7I\2\2\u00a6"+
		"\u00a7\7K\2\2\u00a7\u00a8\7P\2\2\u00a8\u00a9\7\"\2\2\u00a9\u00aa\7E\2"+
		"\2\u00aa\u00ab\7Q\2\2\u00ab\u00ac\7F\2\2\u00ac\u00ad\7G\2\2\u00ad\66\3"+
		"\2\2\2\u00ae\u00af\7G\2\2\u00af\u00b0\7P\2\2\u00b0\u00b1\7F\2\2\u00b1"+
		"\u00b2\7\"\2\2\u00b2\u00b3\7E\2\2\u00b3\u00b4\7Q\2\2\u00b4\u00b5\7F\2"+
		"\2\u00b5\u00b6\7G\2\2\u00b68\3\2\2\2\u00b7\u00b8\7&\2\2\u00b8:\3\2\2\2"+
		"\u00b9\u00ba\7D\2\2\u00ba\u00bb\7Q\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00ca"+
		"\7N\2\2\u00bd\u00be\7E\2\2\u00be\u00bf\7J\2\2\u00bf\u00c0\7C\2\2\u00c0"+
		"\u00ca\7T\2\2\u00c1\u00c2\7K\2\2\u00c2\u00c3\7P\2\2\u00c3\u00ca\7V\2\2"+
		"\u00c4\u00c5\7H\2\2\u00c5\u00c6\7N\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8"+
		"\7C\2\2\u00c8\u00ca\7V\2\2\u00c9\u00b9\3\2\2\2\u00c9\u00bd\3\2\2\2\u00c9"+
		"\u00c1\3\2\2\2\u00c9\u00c4\3\2\2\2\u00ca<\3\2\2\2\u00cb\u00cc\7V\2\2\u00cc"+
		"\u00cd\7T\2\2\u00cd\u00ce\7W\2\2\u00ce\u00d5\7G\2\2\u00cf\u00d0\7H\2\2"+
		"\u00d0\u00d1\7C\2\2\u00d1\u00d2\7N\2\2\u00d2\u00d3\7U\2\2\u00d3\u00d5"+
		"\7G\2\2\u00d4\u00cb\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d5>\3\2\2\2\u00d6\u00d8"+
		"\7)\2\2\u00d7\u00d9\t\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00db\7)\2\2\u00db@\3\2\2\2\u00dc\u00de\7/\2\2\u00dd\u00dc\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00e1\t\3\2\2\u00e0\u00df\3\2"+
		"\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"B\3\2\2\2\u00e4\u00e6\7/\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e8\3\2\2\2\u00e7\u00e9\t\3\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ee\7\60\2\2\u00ed\u00ef\7/\2\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00f2\t\3\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4D\3\2\2\2"+
		"\u00f5\u00f9\7$\2\2\u00f6\u00f8\n\4\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb"+
		"\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fc\u0112\7$\2\2\u00fd\u0101\7)\2\2\u00fe\u0100\n\5\2"+
		"\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0112\7)\2\2\u0105"+
		"\u0109\7]\2\2\u0106\u0108\n\6\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2"+
		"\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u010e\7_\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u00f5\3\2\2\2\u0111\u00fd\3\2\2\2\u0111\u0105\3\2\2\2\u0112F\3\2\2\2"+
		"\u0113\u0115\t\7\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\b$\2\2\u0119"+
		"H\3\2\2\2\u011a\u011c\t\b\2\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2"+
		"\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eJ\3\2\2\2\u011f\u0120\7"+
		"F\2\2\u0120\u0121\7K\2\2\u0121\u0122\7U\2\2\u0122\u0123\7R\2\2\u0123\u0124"+
		"\7N\2\2\u0124\u0125\7C\2\2\u0125\u012b\7[\2\2\u0126\u0127\7U\2\2\u0127"+
		"\u0128\7E\2\2\u0128\u0129\7C\2\2\u0129\u012b\7P\2\2\u012a\u011f\3\2\2"+
		"\2\u012a\u0126\3\2\2\2\u012bL\3\2\2\2\u012c\u0130\t\t\2\2\u012d\u012f"+
		"\t\n\2\2\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u013b\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0137\t\13"+
		"\2\2\u0134\u0136\t\n\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u012c\3\2\2\2\u013a\u0133\3\2\2\2\u013bN\3\2\2\2\u013c\u0140"+
		"\7%\2\2\u013d\u013f\n\b\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0143\u0144\b(\2\2\u0144P\3\2\2\2\30\2\u00c9\u00d4\u00d8\u00dd\u00e2"+
		"\u00e5\u00ea\u00ee\u00f3\u00f9\u0101\u0109\u010f\u0111\u0116\u011d\u012a"+
		"\u0130\u0137\u013a\u0140\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}