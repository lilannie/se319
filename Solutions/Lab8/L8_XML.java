// Generated from L8_XML.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class L8_XML extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMAILELEMENT=1, DATEELEMENT=2, PHONEELEMENT=3, CREDITCARDELEMENT=4, OTHERELEMENT=5, 
		WS=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUM", "ONEDIG", "TWODIG", "THREEDIG", "FOURDIG", "FIVEDIG", "SIXDIG", 
		"SEVENDIG", "EIGHTDIG", "NINEDIG", "TENDIG", "ELEVENDIG", "TWELVEDIG", 
		"THIRTEENDIG", "FOURTEENDIG", "FIFTEENDIG", "ALPHA", "ALPHANUM", "SPECIAL", 
		"ELEMNAME", "LOCALPART", "DOMAINPART", "EMAIL", "DAY", "MONTH", "YEAR", 
		"DATE", "PHONEONE", "PHONETWO", "PHONETHREE", "PHONEFOUR", "PHONE", "VISA", 
		"MASTERCARD", "AMERICANEXPRESS", "DINERSCLUB", "DISCOVER", "JCB", "CREDITCARD", 
		"EMAILELEMENT", "DATEELEMENT", "PHONEELEMENT", "CREDITCARDELEMENT", "OTHERELEMENT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAILELEMENT", "DATEELEMENT", "PHONEELEMENT", "CREDITCARDELEMENT", 
		"OTHERELEMENT", "WS"
	};
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


		String currentElement = "";


	public L8_XML(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "L8_XML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 39:
			EMAILELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 40:
			DATEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 41:
			PHONEELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
			CREDITCARDELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
			OTHERELEMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EMAILELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("---Email Tag Found---");
			break;
		case 1:
			System.out.print("Email: "+getText().substring(7));
			break;
		case 2:
			System.out.print("Invalid Email ("+getText().substring(7)+") On Line " + getLine());
			break;
		case 3:
			System.out.print("\n\n");
			break;
		}
	}
	private void DATEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			System.out.println("---Date Tag Found---");
			break;
		case 5:
			System.out.print("Date: "+getText().substring(6));
			break;
		case 6:
			System.out.print("Invalid Date ("+getText().substring(6)+") On Line " + getLine());
			break;
		case 7:
			System.out.print("\n\n");
			break;
		}
	}
	private void PHONEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			System.out.println("---Phone Tag Found---");
			break;
		case 9:
			System.out.print("Phone: "+getText().substring(7));
			break;
		case 10:
			System.out.print("Invalid Phone ("+getText().substring(7)+") On Line " + getLine());
			break;
		case 11:
			System.out.print("\n\n");
			break;
		}
	}
	private void CREDITCARDELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			System.out.println("---Credit Card Tag Found---");
			break;
		case 13:
			System.out.print("Credit Card: "+getText().substring(12));
			break;
		case 14:
			System.out.print("Invalid Credit Card ("+getText().substring(12)+") On Line " + getLine());
			break;
		case 15:
			System.out.print("\n\n");
			break;
		}
	}
	private void OTHERELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:
			currentElement = getText(); System.out.print("---Other Tag Found---\n" + getText().substring(1,getText().length()-1)+": ");
			break;
		case 17:
			System.out.print(getText().substring(currentElement.length()));
			break;
		case 18:
			System.out.print("\n\n");
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\b\u0256\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\5\3a\n\3\3\4\3\4\3\4\5\4f\n\4\3\5\3\5\3\5"+
		"\3\5\5\5l\n\5\3\6\3\6\3\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"{\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0084\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\5\t\u008e\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0099"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b2\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c0\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00cf\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00df"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00f0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0102\n\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\5\25\u010c\n\25\3\25\7\25\u010f\n\25\f\25\16\25\u0112"+
		"\13\25\3\26\3\26\5\26\u0116\n\26\3\26\3\26\3\26\5\26\u011b\n\26\6\26\u011d"+
		"\n\26\r\26\16\26\u011e\3\26\3\26\6\26\u0123\n\26\r\26\16\26\u0124\5\26"+
		"\u0127\n\26\3\27\3\27\6\27\u012b\n\27\r\27\16\27\u012c\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\5\31\u0137\n\31\3\32\3\32\3\32\3\32\5\32\u013d"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0148\n\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!"+
		"\3!\3!\3!\5!\u016d\n!\3\"\3\"\3\"\5\"\u0172\n\"\3#\3#\3#\3#\3#\5#\u0179"+
		"\n#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0187\n%\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\5&\u0193\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u019d\n\'"+
		"\3\'\3\'\3\'\3\'\3\'\5\'\u01a4\n\'\3(\3(\3(\3(\3(\3(\5(\u01ac\n(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u01bb\n)\f)\16)\u01be\13)\3)\5)"+
		"\u01c1\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\7*\u01da\n*\f*\16*\u01dd\13*\3*\5*\u01e0\n*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u01f9\n+\f+\16"+
		"+\u01fc\13+\3+\5+\u01ff\n+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\7,\u021e\n,\f,\16,\u0221\13"+
		",\3,\5,\u0224\n,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3"+
		"-\5-\u0238\n-\3-\3-\3-\3-\3-\7-\u023f\n-\f-\16-\u0242\13-\3-\3-\3-\3-"+
		"\3-\5-\u0249\n-\3-\5-\u024c\n-\3-\3-\3.\6.\u0251\n.\r.\16.\u0252\3.\3"+
		".\7\u01bc\u01db\u01fa\u021f\u0240\2/\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21"+
		"\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\3S\4U\5W\6Y\7[\b\3\2"+
		"\16\3\2\62;\3\2C|\5\2\62;C\\c|\t\2##&&(/<=??aa\u0080\u0080\3\2\62\64\3"+
		"\2\62\63\3\2\63;\3\2\63\67\4\2\66\6699\3\2\62\67\4\288::\5\2\13\f\17\17"+
		"\"\"\u0267\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\3]\3\2\2\2\5`\3\2\2\2\7e\3\2\2\2\tk\3\2\2\2\13r\3\2\2\2\rz\3\2"+
		"\2\2\17\u0083\3\2\2\2\21\u008d\3\2\2\2\23\u0098\3\2\2\2\25\u00a4\3\2\2"+
		"\2\27\u00b1\3\2\2\2\31\u00bf\3\2\2\2\33\u00ce\3\2\2\2\35\u00de\3\2\2\2"+
		"\37\u00ef\3\2\2\2!\u0101\3\2\2\2#\u0103\3\2\2\2%\u0105\3\2\2\2\'\u0107"+
		"\3\2\2\2)\u010b\3\2\2\2+\u0126\3\2\2\2-\u012a\3\2\2\2/\u012e\3\2\2\2\61"+
		"\u0136\3\2\2\2\63\u013c\3\2\2\2\65\u0147\3\2\2\2\67\u0149\3\2\2\29\u014f"+
		"\3\2\2\2;\u0155\3\2\2\2=\u015b\3\2\2\2?\u0161\3\2\2\2A\u016c\3\2\2\2C"+
		"\u016e\3\2\2\2E\u0178\3\2\2\2G\u017a\3\2\2\2I\u0186\3\2\2\2K\u0192\3\2"+
		"\2\2M\u01a3\3\2\2\2O\u01ab\3\2\2\2Q\u01ad\3\2\2\2S\u01cd\3\2\2\2U\u01eb"+
		"\3\2\2\2W\u020b\3\2\2\2Y\u0235\3\2\2\2[\u0250\3\2\2\2]^\t\2\2\2^\4\3\2"+
		"\2\2_a\5\3\2\2`_\3\2\2\2`a\3\2\2\2a\6\3\2\2\2bc\5\3\2\2cd\5\3\2\2df\3"+
		"\2\2\2eb\3\2\2\2ef\3\2\2\2f\b\3\2\2\2gh\5\3\2\2hi\5\3\2\2ij\5\3\2\2jl"+
		"\3\2\2\2kg\3\2\2\2kl\3\2\2\2l\n\3\2\2\2mn\5\3\2\2no\5\3\2\2op\5\3\2\2"+
		"pq\5\3\2\2qs\3\2\2\2rm\3\2\2\2rs\3\2\2\2s\f\3\2\2\2tu\5\3\2\2uv\5\3\2"+
		"\2vw\5\3\2\2wx\5\3\2\2xy\5\3\2\2y{\3\2\2\2zt\3\2\2\2z{\3\2\2\2{\16\3\2"+
		"\2\2|}\5\3\2\2}~\5\3\2\2~\177\5\3\2\2\177\u0080\5\3\2\2\u0080\u0081\5"+
		"\3\2\2\u0081\u0082\5\3\2\2\u0082\u0084\3\2\2\2\u0083|\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\20\3\2\2\2\u0085\u0086\5\3\2\2\u0086\u0087\5\3\2\2\u0087"+
		"\u0088\5\3\2\2\u0088\u0089\5\3\2\2\u0089\u008a\5\3\2\2\u008a\u008b\5\3"+
		"\2\2\u008b\u008c\5\3\2\2\u008c\u008e\3\2\2\2\u008d\u0085\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\22\3\2\2\2\u008f\u0090\5\3\2\2\u0090\u0091\5\3\2"+
		"\2\u0091\u0092\5\3\2\2\u0092\u0093\5\3\2\2\u0093\u0094\5\3\2\2\u0094\u0095"+
		"\5\3\2\2\u0095\u0096\5\3\2\2\u0096\u0097\5\3\2\2\u0097\u0099\3\2\2\2\u0098"+
		"\u008f\3\2\2\2\u0098\u0099\3\2\2\2\u0099\24\3\2\2\2\u009a\u009b\5\3\2"+
		"\2\u009b\u009c\5\3\2\2\u009c\u009d\5\3\2\2\u009d\u009e\5\3\2\2\u009e\u009f"+
		"\5\3\2\2\u009f\u00a0\5\3\2\2\u00a0\u00a1\5\3\2\2\u00a1\u00a2\5\3\2\2\u00a2"+
		"\u00a3\5\3\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009a\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\26\3\2\2\2\u00a6\u00a7\5\3\2\2\u00a7\u00a8\5\3\2\2\u00a8\u00a9"+
		"\5\3\2\2\u00a9\u00aa\5\3\2\2\u00aa\u00ab\5\3\2\2\u00ab\u00ac\5\3\2\2\u00ac"+
		"\u00ad\5\3\2\2\u00ad\u00ae\5\3\2\2\u00ae\u00af\5\3\2\2\u00af\u00b0\5\3"+
		"\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00a6\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\30\3\2\2\2\u00b3\u00b4\5\3\2\2\u00b4\u00b5\5\3\2\2\u00b5\u00b6\5\3\2"+
		"\2\u00b6\u00b7\5\3\2\2\u00b7\u00b8\5\3\2\2\u00b8\u00b9\5\3\2\2\u00b9\u00ba"+
		"\5\3\2\2\u00ba\u00bb\5\3\2\2\u00bb\u00bc\5\3\2\2\u00bc\u00bd\5\3\2\2\u00bd"+
		"\u00be\5\3\2\2\u00be\u00c0\3\2\2\2\u00bf\u00b3\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\32\3\2\2\2\u00c1\u00c2\5\3\2\2\u00c2\u00c3\5\3\2\2\u00c3\u00c4"+
		"\5\3\2\2\u00c4\u00c5\5\3\2\2\u00c5\u00c6\5\3\2\2\u00c6\u00c7\5\3\2\2\u00c7"+
		"\u00c8\5\3\2\2\u00c8\u00c9\5\3\2\2\u00c9\u00ca\5\3\2\2\u00ca\u00cb\5\3"+
		"\2\2\u00cb\u00cc\5\3\2\2\u00cc\u00cd\5\3\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00c1\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\34\3\2\2\2\u00d0\u00d1\5\3\2"+
		"\2\u00d1\u00d2\5\3\2\2\u00d2\u00d3\5\3\2\2\u00d3\u00d4\5\3\2\2\u00d4\u00d5"+
		"\5\3\2\2\u00d5\u00d6\5\3\2\2\u00d6\u00d7\5\3\2\2\u00d7\u00d8\5\3\2\2\u00d8"+
		"\u00d9\5\3\2\2\u00d9\u00da\5\3\2\2\u00da\u00db\5\3\2\2\u00db\u00dc\5\3"+
		"\2\2\u00dc\u00dd\5\3\2\2\u00dd\u00df\3\2\2\2\u00de\u00d0\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\36\3\2\2\2\u00e0\u00e1\5\3\2\2\u00e1\u00e2\5\3\2"+
		"\2\u00e2\u00e3\5\3\2\2\u00e3\u00e4\5\3\2\2\u00e4\u00e5\5\3\2\2\u00e5\u00e6"+
		"\5\3\2\2\u00e6\u00e7\5\3\2\2\u00e7\u00e8\5\3\2\2\u00e8\u00e9\5\3\2\2\u00e9"+
		"\u00ea\5\3\2\2\u00ea\u00eb\5\3\2\2\u00eb\u00ec\5\3\2\2\u00ec\u00ed\5\3"+
		"\2\2\u00ed\u00ee\5\3\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e0\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0 \3\2\2\2\u00f1\u00f2\5\3\2\2\u00f2\u00f3\5\3\2\2"+
		"\u00f3\u00f4\5\3\2\2\u00f4\u00f5\5\3\2\2\u00f5\u00f6\5\3\2\2\u00f6\u00f7"+
		"\5\3\2\2\u00f7\u00f8\5\3\2\2\u00f8\u00f9\5\3\2\2\u00f9\u00fa\5\3\2\2\u00fa"+
		"\u00fb\5\3\2\2\u00fb\u00fc\5\3\2\2\u00fc\u00fd\5\3\2\2\u00fd\u00fe\5\3"+
		"\2\2\u00fe\u00ff\5\3\2\2\u00ff\u0100\5\3\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u00f1\3\2\2\2\u0101\u0102\3\2\2\2\u0102\"\3\2\2\2\u0103\u0104\t\3\2\2"+
		"\u0104$\3\2\2\2\u0105\u0106\t\4\2\2\u0106&\3\2\2\2\u0107\u0108\t\5\2\2"+
		"\u0108(\3\2\2\2\u0109\u010c\5#\22\2\u010a\u010c\7a\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010a\3\2\2\2\u010c\u0110\3\2\2\2\u010d\u010f\5%\23\2\u010e"+
		"\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111*\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0116\5%\23\2\u0114\u0116"+
		"\5\'\24\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2"+
		"\u0117\u011a\7\60\2\2\u0118\u011b\5%\23\2\u0119\u011b\5\'\24\2\u011a\u0118"+
		"\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u0115\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0127\3\2"+
		"\2\2\u0120\u0123\5%\23\2\u0121\u0123\5\'\24\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0127\3\2\2\2\u0126\u011c\3\2\2\2\u0126\u0122\3\2\2\2\u0127"+
		",\3\2\2\2\u0128\u012b\5%\23\2\u0129\u012b\4/\60\2\u012a\u0128\3\2\2\2"+
		"\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d.\3\2\2\2\u012e\u012f\5+\26\2\u012f\u0130\7B\2\2\u0130\u0131"+
		"\5-\27\2\u0131\60\3\2\2\2\u0132\u0133\t\6\2\2\u0133\u0137\t\2\2\2\u0134"+
		"\u0135\7\65\2\2\u0135\u0137\t\7\2\2\u0136\u0132\3\2\2\2\u0136\u0134\3"+
		"\2\2\2\u0137\62\3\2\2\2\u0138\u0139\7\62\2\2\u0139\u013d\t\b\2\2\u013a"+
		"\u013b\7\63\2\2\u013b\u013d\t\6\2\2\u013c\u0138\3\2\2\2\u013c\u013a\3"+
		"\2\2\2\u013d\64\3\2\2\2\u013e\u013f\7\64\2\2\u013f\u0140\7\62\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u0142\t\2\2\2\u0142\u0148\t\2\2\2\u0143\u0144\7\64"+
		"\2\2\u0144\u0145\7\63\2\2\u0145\u0146\7\62\2\2\u0146\u0148\7\62\2\2\u0147"+
		"\u013e\3\2\2\2\u0147\u0143\3\2\2\2\u0148\66\3\2\2\2\u0149\u014a\5\61\31"+
		"\2\u014a\u014b\7\61\2\2\u014b\u014c\5\63\32\2\u014c\u014d\7\61\2\2\u014d"+
		"\u014e\5\65\33\2\u014e8\3\2\2\2\u014f\u0150\5\t\5\2\u0150\u0151\7/\2\2"+
		"\u0151\u0152\5\t\5\2\u0152\u0153\7/\2\2\u0153\u0154\5\13\6\2\u0154:\3"+
		"\2\2\2\u0155\u0156\5\t\5\2\u0156\u0157\7\60\2\2\u0157\u0158\5\t\5\2\u0158"+
		"\u0159\7\60\2\2\u0159\u015a\5\13\6\2\u015a<\3\2\2\2\u015b\u015c\5\t\5"+
		"\2\u015c\u015d\7\"\2\2\u015d\u015e\5\t\5\2\u015e\u015f\7\"\2\2\u015f\u0160"+
		"\5\13\6\2\u0160>\3\2\2\2\u0161\u0162\7*\2\2\u0162\u0163\5\t\5\2\u0163"+
		"\u0164\7+\2\2\u0164\u0165\5\t\5\2\u0165\u0166\7/\2\2\u0166\u0167\5\13"+
		"\6\2\u0167@\3\2\2\2\u0168\u016d\59\35\2\u0169\u016d\5;\36\2\u016a\u016d"+
		"\5=\37\2\u016b\u016d\5? \2\u016c\u0168\3\2\2\2\u016c\u0169\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016dB\3\2\2\2\u016e\u0171\7\66\2\2"+
		"\u016f\u0172\5\33\16\2\u0170\u0172\5!\21\2\u0171\u016f\3\2\2\2\u0171\u0170"+
		"\3\2\2\2\u0172D\3\2\2\2\u0173\u0174\7\67\2\2\u0174\u0175\t\t\2\2\u0175"+
		"\u0179\5\37\20\2\u0176\u0177\7\67\2\2\u0177\u0179\5!\21\2\u0178\u0173"+
		"\3\2\2\2\u0178\u0176\3\2\2\2\u0179F\3\2\2\2\u017a\u017b\7\65\2\2\u017b"+
		"\u017c\t\n\2\2\u017c\u017d\5\35\17\2\u017dH\3\2\2\2\u017e\u017f\7\65\2"+
		"\2\u017f\u0180\7\62\2\2\u0180\u0181\3\2\2\2\u0181\u0182\t\13\2\2\u0182"+
		"\u0187\5\31\r\2\u0183\u0184\7\65\2\2\u0184\u0185\t\f\2\2\u0185\u0187\5"+
		"\33\16\2\u0186\u017e\3\2\2\2\u0186\u0183\3\2\2\2\u0187J\3\2\2\2\u0188"+
		"\u0189\78\2\2\u0189\u018a\7\62\2\2\u018a\u018b\7\63\2\2\u018b\u018c\7"+
		"\63\2\2\u018c\u018d\3\2\2\2\u018d\u0193\5\33\16\2\u018e\u018f\78\2\2\u018f"+
		"\u0190\7\67\2\2\u0190\u0191\3\2\2\2\u0191\u0193\5\37\20\2\u0192\u0188"+
		"\3\2\2\2\u0192\u018e\3\2\2\2\u0193L\3\2\2\2\u0194\u0195\7\64\2\2\u0195"+
		"\u0196\7\63\2\2\u0196\u0197\7\65\2\2\u0197\u019d\7\63\2\2\u0198\u0199"+
		"\7\63\2\2\u0199\u019a\7:\2\2\u019a\u019b\7\62\2\2\u019b\u019d\7\62\2\2"+
		"\u019c\u0194\3\2\2\2\u019c\u0198\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a4"+
		"\5\31\r\2\u019f\u01a0\7\65\2\2\u01a0\u01a1\7\67\2\2\u01a1\u01a2\3\2\2"+
		"\2\u01a2\u01a4\5\37\20\2\u01a3\u019c\3\2\2\2\u01a3\u019f\3\2\2\2\u01a4"+
		"N\3\2\2\2\u01a5\u01ac\5C\"\2\u01a6\u01ac\5E#\2\u01a7\u01ac\5G$\2\u01a8"+
		"\u01ac\5I%\2\u01a9\u01ac\5K&\2\u01aa\u01ac\5M\'\2\u01ab\u01a5\3\2\2\2"+
		"\u01ab\u01a6\3\2\2\2\u01ab\u01a7\3\2\2\2\u01ab\u01a8\3\2\2\2\u01ab\u01a9"+
		"\3\2\2\2\u01ab\u01aa\3\2\2\2\u01acP\3\2\2\2\u01ad\u01ae\7>\2\2\u01ae\u01af"+
		"\7G\2\2\u01af\u01b0\7O\2\2\u01b0\u01b1\7C\2\2\u01b1\u01b2\7K\2\2\u01b2"+
		"\u01b3\7N\2\2\u01b3\u01b4\7@\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01c0\b)\2"+
		"\2\u01b6\u01b7\5/\30\2\u01b7\u01b8\b)\3\2\u01b8\u01c1\3\2\2\2\u01b9\u01bb"+
		"\13\2\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01bd\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c1"+
		"\b)\4\2\u01c0\u01b6\3\2\2\2\u01c0\u01bc\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\7>\2\2\u01c3\u01c4\7\61\2\2\u01c4\u01c5\7G\2\2\u01c5\u01c6\7O\2"+
		"\2\u01c6\u01c7\7C\2\2\u01c7\u01c8\7K\2\2\u01c8\u01c9\7N\2\2\u01c9\u01ca"+
		"\7@\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\b)\5\2\u01ccR\3\2\2\2\u01cd\u01ce"+
		"\7>\2\2\u01ce\u01cf\7F\2\2\u01cf\u01d0\7C\2\2\u01d0\u01d1\7V\2\2\u01d1"+
		"\u01d2\7G\2\2\u01d2\u01d3\7@\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01df\b*\6"+
		"\2\u01d5\u01d6\5\67\34\2\u01d6\u01d7\b*\7\2\u01d7\u01e0\3\2\2\2\u01d8"+
		"\u01da\13\2\2\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01dc\3"+
		"\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01de\3\2\2\2\u01dd\u01db\3\2\2\2\u01de"+
		"\u01e0\b*\b\2\u01df\u01d5\3\2\2\2\u01df\u01db\3\2\2\2\u01e0\u01e1\3\2"+
		"\2\2\u01e1\u01e2\7>\2\2\u01e2\u01e3\7\61\2\2\u01e3\u01e4\7F\2\2\u01e4"+
		"\u01e5\7C\2\2\u01e5\u01e6\7V\2\2\u01e6\u01e7\7G\2\2\u01e7\u01e8\7@\2\2"+
		"\u01e8\u01e9\3\2\2\2\u01e9\u01ea\b*\t\2\u01eaT\3\2\2\2\u01eb\u01ec\7>"+
		"\2\2\u01ec\u01ed\7R\2\2\u01ed\u01ee\7J\2\2\u01ee\u01ef\7Q\2\2\u01ef\u01f0"+
		"\7P\2\2\u01f0\u01f1\7G\2\2\u01f1\u01f2\7@\2\2\u01f2\u01f3\3\2\2\2\u01f3"+
		"\u01fe\b+\n\2\u01f4\u01f5\5A!\2\u01f5\u01f6\b+\13\2\u01f6\u01ff\3\2\2"+
		"\2\u01f7\u01f9\13\2\2\2\u01f8\u01f7\3\2\2\2\u01f9\u01fc\3\2\2\2\u01fa"+
		"\u01fb\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fd\3\2\2\2\u01fc\u01fa\3\2"+
		"\2\2\u01fd\u01ff\b+\f\2\u01fe\u01f4\3\2\2\2\u01fe\u01fa\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200\u0201\7>\2\2\u0201\u0202\7\61\2\2\u0202\u0203\7R"+
		"\2\2\u0203\u0204\7J\2\2\u0204\u0205\7Q\2\2\u0205\u0206\7P\2\2\u0206\u0207"+
		"\7G\2\2\u0207\u0208\7@\2\2\u0208\u0209\3\2\2\2\u0209\u020a\b+\r\2\u020a"+
		"V\3\2\2\2\u020b\u020c\7>\2\2\u020c\u020d\7E\2\2\u020d\u020e\7T\2\2\u020e"+
		"\u020f\7G\2\2\u020f\u0210\7F\2\2\u0210\u0211\7K\2\2\u0211\u0212\7V\2\2"+
		"\u0212\u0213\7E\2\2\u0213\u0214\7C\2\2\u0214\u0215\7T\2\2\u0215\u0216"+
		"\7F\2\2\u0216\u0217\7@\2\2\u0217\u0218\3\2\2\2\u0218\u0223\b,\16\2\u0219"+
		"\u021a\5O(\2\u021a\u021b\b,\17\2\u021b\u0224\3\2\2\2\u021c\u021e\13\2"+
		"\2\2\u021d\u021c\3\2\2\2\u021e\u0221\3\2\2\2\u021f\u0220\3\2\2\2\u021f"+
		"\u021d\3\2\2\2\u0220\u0222\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0224\b,"+
		"\20\2\u0223\u0219\3\2\2\2\u0223\u021f\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0226\7>\2\2\u0226\u0227\7\61\2\2\u0227\u0228\7E\2\2\u0228\u0229\7T\2"+
		"\2\u0229\u022a\7G\2\2\u022a\u022b\7F\2\2\u022b\u022c\7K\2\2\u022c\u022d"+
		"\7V\2\2\u022d\u022e\7E\2\2\u022e\u022f\7C\2\2\u022f\u0230\7T\2\2\u0230"+
		"\u0231\7F\2\2\u0231\u0232\7@\2\2\u0232\u0233\3\2\2\2\u0233\u0234\b,\21"+
		"\2\u0234X\3\2\2\2\u0235\u0237\7>\2\2\u0236\u0238\5)\25\2\u0237\u0236\3"+
		"\2\2\2\u0237\u0238\3\2\2\2\u0238\u0239\3\2\2\2\u0239\u023a\7@\2\2\u023a"+
		"\u0240\b-\22\2\u023b\u023f\5%\23\2\u023c\u023f\5\'\24\2\u023d\u023f\7"+
		"\"\2\2\u023e\u023b\3\2\2\2\u023e\u023c\3\2\2\2\u023e\u023d\3\2\2\2\u023f"+
		"\u0242\3\2\2\2\u0240\u0241\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0243\3\2"+
		"\2\2\u0242\u0240\3\2\2\2\u0243\u0244\b-\23\2\u0244\u0245\7>\2\2\u0245"+
		"\u0246\7\61\2\2\u0246\u0248\3\2\2\2\u0247\u0249\5)\25\2\u0248\u0247\3"+
		"\2\2\2\u0248\u0249\3\2\2\2\u0249\u024b\3\2\2\2\u024a\u024c\7@\2\2\u024b"+
		"\u024a\3\2\2\2\u024b\u024c\3\2\2\2\u024c\u024d\3\2\2\2\u024d\u024e\b-"+
		"\24\2\u024eZ\3\2\2\2\u024f\u0251\t\r\2\2\u0250\u024f\3\2\2\2\u0251\u0252"+
		"\3\2\2\2\u0252\u0250\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u0254\3\2\2\2\u0254"+
		"\u0255\b.\25\2\u0255\\\3\2\2\2\65\2`ekrz\u0083\u008d\u0098\u00a4\u00b1"+
		"\u00bf\u00ce\u00de\u00ef\u0101\u010b\u0110\u0115\u011a\u011e\u0122\u0124"+
		"\u0126\u012a\u012c\u0136\u013c\u0147\u016c\u0171\u0178\u0186\u0192\u019c"+
		"\u01a3\u01ab\u01bc\u01c0\u01db\u01df\u01fa\u01fe\u021f\u0223\u0237\u023e"+
		"\u0240\u0248\u024b\u0252\26\3)\2\3)\3\3)\4\3)\5\3*\6\3*\7\3*\b\3*\t\3"+
		"+\n\3+\13\3+\f\3+\r\3,\16\3,\17\3,\20\3,\21\3-\22\3-\23\3-\24\3.\25";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}