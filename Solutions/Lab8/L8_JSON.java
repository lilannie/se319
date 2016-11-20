// Generated from L8_JSON.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class L8_JSON extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMAILELEMENT=1, DATEELEMENT=2, PHONEELEMENT=3, CREDITCARDELEMENT=4, OTHERELEMENT=5, 
		OBJECT=6, ATTRIBUTE=7, WS=8;
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
		"OBJECT", "ATTRIBUTE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMAILELEMENT", "DATEELEMENT", "PHONEELEMENT", "CREDITCARDELEMENT", 
		"OTHERELEMENT", "OBJECT", "ATTRIBUTE", "WS"
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


	public L8_JSON(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "L8_JSON.g4"; }

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
			OBJECT_action((RuleContext)_localctx, actionIndex);
			break;
		case 45:
			ATTRIBUTE_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void EMAILELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.print("Email: "+getText().substring(9));
			break;
		case 1:
			System.out.print("Invalid Email ("+getText().substring(9)+") On Line " + getLine());
			break;
		case 2:
			System.out.print("\n");
			break;
		}
	}
	private void DATEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			System.out.print("Date: "+getText().substring(8));
			break;
		case 4:
			System.out.print("Invalid Date ("+getText().substring(8)+") On Line " + getLine());
			break;
		case 5:
			System.out.print("\n");
			break;
		}
	}
	private void PHONEELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			System.out.print("Phone: "+getText().substring(9));
			break;
		case 7:
			System.out.print("Invalid Phone ("+getText().substring(9)+") On Line " + getLine());
			break;
		case 8:
			System.out.print("\n");
			break;
		}
	}
	private void CREDITCARDELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			System.out.print("Credit Card: "+getText().substring(14));
			break;
		case 10:
			System.out.print("Invalid Credit Card ("+getText().substring(14)+") On Line " + getLine());
			break;
		case 11:
			System.out.print("\n");
			break;
		}
	}
	private void OTHERELEMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			currentElement = getText(); System.out.print(getText().substring(1,getText().length()-3)+": ");
			break;
		case 13:
			System.out.print(getText().substring(currentElement.length()));
			break;
		case 14:
			System.out.print("\n");
			break;
		}
	}
	private void OBJECT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:
			System.out.println("OBJECT START");
			break;
		case 16:
			System.out.println("OBJECT END");
			break;
		}
	}
	private void ATTRIBUTE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:
			System.out.println("Next Attribute");
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\u023c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\5\3e\n\3\3\4\3\4\3\4\5\4"+
		"j\n\4\3\5\3\5\3\5\3\5\5\5p\n\5\3\6\3\6\3\6\3\6\3\6\5\6w\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7\177\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0088\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0092\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n\u009d\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00a9\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f"+
		"\u00b6\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c4\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00d3\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00e3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f4\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0106"+
		"\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u0110\n\25\3\25\7\25"+
		"\u0113\n\25\f\25\16\25\u0116\13\25\3\26\3\26\5\26\u011a\n\26\3\26\3\26"+
		"\3\26\5\26\u011f\n\26\6\26\u0121\n\26\r\26\16\26\u0122\3\26\3\26\6\26"+
		"\u0127\n\26\r\26\16\26\u0128\5\26\u012b\n\26\3\27\3\27\6\27\u012f\n\27"+
		"\r\27\16\27\u0130\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u013b\n"+
		"\31\3\32\3\32\3\32\3\32\5\32\u0141\n\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\5\33\u014c\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\5!\u0171\n!\3\"\3\"\3\"\5"+
		"\"\u0176\n\"\3#\3#\3#\3#\3#\5#\u017d\n#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\5%\u018b\n%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0197\n&\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\5\'\u01a1\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u01a8\n\'"+
		"\3(\3(\3(\3(\3(\3(\5(\u01b0\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\7)\u01c0\n)\f)\16)\u01c3\13)\3)\5)\u01c6\n)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u01d8\n*\f*\16*\u01db\13*\3*\5*\u01de\n*"+
		"\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\7+\u01f1\n+\f+\16"+
		"+\u01f4\13+\3+\5+\u01f7\n+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\7,\u020f\n,\f,\16,\u0212\13,\3,\5,\u0215\n,\3,"+
		"\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0224\n-\f-\16-\u0227\13-\3-\3"+
		"-\3-\3-\3.\3.\3.\3.\5.\u0231\n.\3/\3/\3/\3\60\6\60\u0237\n\60\r\60\16"+
		"\60\u0238\3\60\3\60\7\u01c1\u01d9\u01f2\u0210\u0225\2\61\3\2\5\2\7\2\t"+
		"\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2"+
		")\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q"+
		"\3S\4U\5W\6Y\7[\b]\t_\n\3\2\16\3\2\62;\3\2C|\5\2\62;C\\c|\t\2##&&(/<="+
		"??aa\u0080\u0080\3\2\62\64\3\2\62\63\3\2\63;\3\2\63\67\4\2\66\6699\3\2"+
		"\62\67\4\288::\5\2\13\f\17\17\"\"\u024b\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5"+
		"d\3\2\2\2\7i\3\2\2\2\to\3\2\2\2\13v\3\2\2\2\r~\3\2\2\2\17\u0087\3\2\2"+
		"\2\21\u0091\3\2\2\2\23\u009c\3\2\2\2\25\u00a8\3\2\2\2\27\u00b5\3\2\2\2"+
		"\31\u00c3\3\2\2\2\33\u00d2\3\2\2\2\35\u00e2\3\2\2\2\37\u00f3\3\2\2\2!"+
		"\u0105\3\2\2\2#\u0107\3\2\2\2%\u0109\3\2\2\2\'\u010b\3\2\2\2)\u010f\3"+
		"\2\2\2+\u012a\3\2\2\2-\u012e\3\2\2\2/\u0132\3\2\2\2\61\u013a\3\2\2\2\63"+
		"\u0140\3\2\2\2\65\u014b\3\2\2\2\67\u014d\3\2\2\29\u0153\3\2\2\2;\u0159"+
		"\3\2\2\2=\u015f\3\2\2\2?\u0165\3\2\2\2A\u0170\3\2\2\2C\u0172\3\2\2\2E"+
		"\u017c\3\2\2\2G\u017e\3\2\2\2I\u018a\3\2\2\2K\u0196\3\2\2\2M\u01a7\3\2"+
		"\2\2O\u01af\3\2\2\2Q\u01b1\3\2\2\2S\u01ca\3\2\2\2U\u01e2\3\2\2\2W\u01fb"+
		"\3\2\2\2Y\u0219\3\2\2\2[\u0230\3\2\2\2]\u0232\3\2\2\2_\u0236\3\2\2\2a"+
		"b\t\2\2\2b\4\3\2\2\2ce\5\3\2\2dc\3\2\2\2de\3\2\2\2e\6\3\2\2\2fg\5\3\2"+
		"\2gh\5\3\2\2hj\3\2\2\2if\3\2\2\2ij\3\2\2\2j\b\3\2\2\2kl\5\3\2\2lm\5\3"+
		"\2\2mn\5\3\2\2np\3\2\2\2ok\3\2\2\2op\3\2\2\2p\n\3\2\2\2qr\5\3\2\2rs\5"+
		"\3\2\2st\5\3\2\2tu\5\3\2\2uw\3\2\2\2vq\3\2\2\2vw\3\2\2\2w\f\3\2\2\2xy"+
		"\5\3\2\2yz\5\3\2\2z{\5\3\2\2{|\5\3\2\2|}\5\3\2\2}\177\3\2\2\2~x\3\2\2"+
		"\2~\177\3\2\2\2\177\16\3\2\2\2\u0080\u0081\5\3\2\2\u0081\u0082\5\3\2\2"+
		"\u0082\u0083\5\3\2\2\u0083\u0084\5\3\2\2\u0084\u0085\5\3\2\2\u0085\u0086"+
		"\5\3\2\2\u0086\u0088\3\2\2\2\u0087\u0080\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\20\3\2\2\2\u0089\u008a\5\3\2\2\u008a\u008b\5\3\2\2\u008b\u008c\5\3\2"+
		"\2\u008c\u008d\5\3\2\2\u008d\u008e\5\3\2\2\u008e\u008f\5\3\2\2\u008f\u0090"+
		"\5\3\2\2\u0090\u0092\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\22\3\2\2\2\u0093\u0094\5\3\2\2\u0094\u0095\5\3\2\2\u0095\u0096\5\3\2"+
		"\2\u0096\u0097\5\3\2\2\u0097\u0098\5\3\2\2\u0098\u0099\5\3\2\2\u0099\u009a"+
		"\5\3\2\2\u009a\u009b\5\3\2\2\u009b\u009d\3\2\2\2\u009c\u0093\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\24\3\2\2\2\u009e\u009f\5\3\2\2\u009f\u00a0\5\3\2"+
		"\2\u00a0\u00a1\5\3\2\2\u00a1\u00a2\5\3\2\2\u00a2\u00a3\5\3\2\2\u00a3\u00a4"+
		"\5\3\2\2\u00a4\u00a5\5\3\2\2\u00a5\u00a6\5\3\2\2\u00a6\u00a7\5\3\2\2\u00a7"+
		"\u00a9\3\2\2\2\u00a8\u009e\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\26\3\2\2"+
		"\2\u00aa\u00ab\5\3\2\2\u00ab\u00ac\5\3\2\2\u00ac\u00ad\5\3\2\2\u00ad\u00ae"+
		"\5\3\2\2\u00ae\u00af\5\3\2\2\u00af\u00b0\5\3\2\2\u00b0\u00b1\5\3\2\2\u00b1"+
		"\u00b2\5\3\2\2\u00b2\u00b3\5\3\2\2\u00b3\u00b4\5\3\2\2\u00b4\u00b6\3\2"+
		"\2\2\u00b5\u00aa\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\30\3\2\2\2\u00b7\u00b8"+
		"\5\3\2\2\u00b8\u00b9\5\3\2\2\u00b9\u00ba\5\3\2\2\u00ba\u00bb\5\3\2\2\u00bb"+
		"\u00bc\5\3\2\2\u00bc\u00bd\5\3\2\2\u00bd\u00be\5\3\2\2\u00be\u00bf\5\3"+
		"\2\2\u00bf\u00c0\5\3\2\2\u00c0\u00c1\5\3\2\2\u00c1\u00c2\5\3\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00b7\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\32\3\2\2"+
		"\2\u00c5\u00c6\5\3\2\2\u00c6\u00c7\5\3\2\2\u00c7\u00c8\5\3\2\2\u00c8\u00c9"+
		"\5\3\2\2\u00c9\u00ca\5\3\2\2\u00ca\u00cb\5\3\2\2\u00cb\u00cc\5\3\2\2\u00cc"+
		"\u00cd\5\3\2\2\u00cd\u00ce\5\3\2\2\u00ce\u00cf\5\3\2\2\u00cf\u00d0\5\3"+
		"\2\2\u00d0\u00d1\5\3\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00c5\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\34\3\2\2\2\u00d4\u00d5\5\3\2\2\u00d5\u00d6\5\3\2"+
		"\2\u00d6\u00d7\5\3\2\2\u00d7\u00d8\5\3\2\2\u00d8\u00d9\5\3\2\2\u00d9\u00da"+
		"\5\3\2\2\u00da\u00db\5\3\2\2\u00db\u00dc\5\3\2\2\u00dc\u00dd\5\3\2\2\u00dd"+
		"\u00de\5\3\2\2\u00de\u00df\5\3\2\2\u00df\u00e0\5\3\2\2\u00e0\u00e1\5\3"+
		"\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00d4\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\36\3\2\2\2\u00e4\u00e5\5\3\2\2\u00e5\u00e6\5\3\2\2\u00e6\u00e7\5\3\2"+
		"\2\u00e7\u00e8\5\3\2\2\u00e8\u00e9\5\3\2\2\u00e9\u00ea\5\3\2\2\u00ea\u00eb"+
		"\5\3\2\2\u00eb\u00ec\5\3\2\2\u00ec\u00ed\5\3\2\2\u00ed\u00ee\5\3\2\2\u00ee"+
		"\u00ef\5\3\2\2\u00ef\u00f0\5\3\2\2\u00f0\u00f1\5\3\2\2\u00f1\u00f2\5\3"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00e4\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		" \3\2\2\2\u00f5\u00f6\5\3\2\2\u00f6\u00f7\5\3\2\2\u00f7\u00f8\5\3\2\2"+
		"\u00f8\u00f9\5\3\2\2\u00f9\u00fa\5\3\2\2\u00fa\u00fb\5\3\2\2\u00fb\u00fc"+
		"\5\3\2\2\u00fc\u00fd\5\3\2\2\u00fd\u00fe\5\3\2\2\u00fe\u00ff\5\3\2\2\u00ff"+
		"\u0100\5\3\2\2\u0100\u0101\5\3\2\2\u0101\u0102\5\3\2\2\u0102\u0103\5\3"+
		"\2\2\u0103\u0104\5\3\2\2\u0104\u0106\3\2\2\2\u0105\u00f5\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\"\3\2\2\2\u0107\u0108\t\3\2\2\u0108$\3\2\2\2\u0109"+
		"\u010a\t\4\2\2\u010a&\3\2\2\2\u010b\u010c\t\5\2\2\u010c(\3\2\2\2\u010d"+
		"\u0110\5#\22\2\u010e\u0110\7a\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2"+
		"\2\2\u0110\u0114\3\2\2\2\u0111\u0113\5%\23\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115*\3\2\2\2"+
		"\u0116\u0114\3\2\2\2\u0117\u011a\5%\23\2\u0118\u011a\5\'\24\2\u0119\u0117"+
		"\3\2\2\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\7\60\2\2"+
		"\u011c\u011f\5%\23\2\u011d\u011f\5\'\24\2\u011e\u011c\3\2\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u0119\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u012b\3\2\2\2\u0124\u0127\5%"+
		"\23\2\u0125\u0127\5\'\24\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2"+
		"\2\2\u012a\u0120\3\2\2\2\u012a\u0126\3\2\2\2\u012b,\3\2\2\2\u012c\u012f"+
		"\5%\23\2\u012d\u012f\4/\60\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131.\3\2\2\2"+
		"\u0132\u0133\5+\26\2\u0133\u0134\7B\2\2\u0134\u0135\5-\27\2\u0135\60\3"+
		"\2\2\2\u0136\u0137\t\6\2\2\u0137\u013b\t\2\2\2\u0138\u0139\7\65\2\2\u0139"+
		"\u013b\t\7\2\2\u013a\u0136\3\2\2\2\u013a\u0138\3\2\2\2\u013b\62\3\2\2"+
		"\2\u013c\u013d\7\62\2\2\u013d\u0141\t\b\2\2\u013e\u013f\7\63\2\2\u013f"+
		"\u0141\t\6\2\2\u0140\u013c\3\2\2\2\u0140\u013e\3\2\2\2\u0141\64\3\2\2"+
		"\2\u0142\u0143\7\64\2\2\u0143\u0144\7\62\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0146\t\2\2\2\u0146\u014c\t\2\2\2\u0147\u0148\7\64\2\2\u0148\u0149\7"+
		"\63\2\2\u0149\u014a\7\62\2\2\u014a\u014c\7\62\2\2\u014b\u0142\3\2\2\2"+
		"\u014b\u0147\3\2\2\2\u014c\66\3\2\2\2\u014d\u014e\5\61\31\2\u014e\u014f"+
		"\7\61\2\2\u014f\u0150\5\63\32\2\u0150\u0151\7\61\2\2\u0151\u0152\5\65"+
		"\33\2\u01528\3\2\2\2\u0153\u0154\5\t\5\2\u0154\u0155\7/\2\2\u0155\u0156"+
		"\5\t\5\2\u0156\u0157\7/\2\2\u0157\u0158\5\13\6\2\u0158:\3\2\2\2\u0159"+
		"\u015a\5\t\5\2\u015a\u015b\7\60\2\2\u015b\u015c\5\t\5\2\u015c\u015d\7"+
		"\60\2\2\u015d\u015e\5\13\6\2\u015e<\3\2\2\2\u015f\u0160\5\t\5\2\u0160"+
		"\u0161\7\"\2\2\u0161\u0162\5\t\5\2\u0162\u0163\7\"\2\2\u0163\u0164\5\13"+
		"\6\2\u0164>\3\2\2\2\u0165\u0166\7*\2\2\u0166\u0167\5\t\5\2\u0167\u0168"+
		"\7+\2\2\u0168\u0169\5\t\5\2\u0169\u016a\7/\2\2\u016a\u016b\5\13\6\2\u016b"+
		"@\3\2\2\2\u016c\u0171\59\35\2\u016d\u0171\5;\36\2\u016e\u0171\5=\37\2"+
		"\u016f\u0171\5? \2\u0170\u016c\3\2\2\2\u0170\u016d\3\2\2\2\u0170\u016e"+
		"\3\2\2\2\u0170\u016f\3\2\2\2\u0171B\3\2\2\2\u0172\u0175\7\66\2\2\u0173"+
		"\u0176\5\33\16\2\u0174\u0176\5!\21\2\u0175\u0173\3\2\2\2\u0175\u0174\3"+
		"\2\2\2\u0176D\3\2\2\2\u0177\u0178\7\67\2\2\u0178\u0179\t\t\2\2\u0179\u017d"+
		"\5\37\20\2\u017a\u017b\7\67\2\2\u017b\u017d\5!\21\2\u017c\u0177\3\2\2"+
		"\2\u017c\u017a\3\2\2\2\u017dF\3\2\2\2\u017e\u017f\7\65\2\2\u017f\u0180"+
		"\t\n\2\2\u0180\u0181\5\35\17\2\u0181H\3\2\2\2\u0182\u0183\7\65\2\2\u0183"+
		"\u0184\7\62\2\2\u0184\u0185\3\2\2\2\u0185\u0186\t\13\2\2\u0186\u018b\5"+
		"\31\r\2\u0187\u0188\7\65\2\2\u0188\u0189\t\f\2\2\u0189\u018b\5\33\16\2"+
		"\u018a\u0182\3\2\2\2\u018a\u0187\3\2\2\2\u018bJ\3\2\2\2\u018c\u018d\7"+
		"8\2\2\u018d\u018e\7\62\2\2\u018e\u018f\7\63\2\2\u018f\u0190\7\63\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0197\5\33\16\2\u0192\u0193\78\2\2\u0193\u0194\7"+
		"\67\2\2\u0194\u0195\3\2\2\2\u0195\u0197\5\37\20\2\u0196\u018c\3\2\2\2"+
		"\u0196\u0192\3\2\2\2\u0197L\3\2\2\2\u0198\u0199\7\64\2\2\u0199\u019a\7"+
		"\63\2\2\u019a\u019b\7\65\2\2\u019b\u01a1\7\63\2\2\u019c\u019d\7\63\2\2"+
		"\u019d\u019e\7:\2\2\u019e\u019f\7\62\2\2\u019f\u01a1\7\62\2\2\u01a0\u0198"+
		"\3\2\2\2\u01a0\u019c\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a8\5\31\r\2"+
		"\u01a3\u01a4\7\65\2\2\u01a4\u01a5\7\67\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8"+
		"\5\37\20\2\u01a7\u01a0\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a8N\3\2\2\2\u01a9"+
		"\u01b0\5C\"\2\u01aa\u01b0\5E#\2\u01ab\u01b0\5G$\2\u01ac\u01b0\5I%\2\u01ad"+
		"\u01b0\5K&\2\u01ae\u01b0\5M\'\2\u01af\u01a9\3\2\2\2\u01af\u01aa\3\2\2"+
		"\2\u01af\u01ab\3\2\2\2\u01af\u01ac\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01ae"+
		"\3\2\2\2\u01b0P\3\2\2\2\u01b1\u01b2\7$\2\2\u01b2\u01b3\7G\2\2\u01b3\u01b4"+
		"\7O\2\2\u01b4\u01b5\7C\2\2\u01b5\u01b6\7K\2\2\u01b6\u01b7\7N\2\2\u01b7"+
		"\u01b8\7$\2\2\u01b8\u01b9\7<\2\2\u01b9\u01ba\7$\2\2\u01ba\u01c5\3\2\2"+
		"\2\u01bb\u01bc\5/\30\2\u01bc\u01bd\b)\2\2\u01bd\u01c6\3\2\2\2\u01be\u01c0"+
		"\13\2\2\2\u01bf\u01be\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01c2\3\2\2\2"+
		"\u01c1\u01bf\3\2\2\2\u01c2\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c6"+
		"\b)\3\2\u01c5\u01bb\3\2\2\2\u01c5\u01c1\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"\u01c8\7$\2\2\u01c8\u01c9\b)\4\2\u01c9R\3\2\2\2\u01ca\u01cb\7$\2\2\u01cb"+
		"\u01cc\7F\2\2\u01cc\u01cd\7C\2\2\u01cd\u01ce\7V\2\2\u01ce\u01cf\7G\2\2"+
		"\u01cf\u01d0\7$\2\2\u01d0\u01d1\7<\2\2\u01d1\u01d2\7$\2\2\u01d2\u01dd"+
		"\3\2\2\2\u01d3\u01d4\5\67\34\2\u01d4\u01d5\b*\5\2\u01d5\u01de\3\2\2\2"+
		"\u01d6\u01d8\13\2\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01da"+
		"\3\2\2\2\u01d9\u01d7\3\2\2\2\u01da\u01dc\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u01de\b*\6\2\u01dd\u01d3\3\2\2\2\u01dd\u01d9\3\2\2\2\u01de\u01df\3\2"+
		"\2\2\u01df\u01e0\7$\2\2\u01e0\u01e1\b*\7\2\u01e1T\3\2\2\2\u01e2\u01e3"+
		"\7$\2\2\u01e3\u01e4\7R\2\2\u01e4\u01e5\7J\2\2\u01e5\u01e6\7Q\2\2\u01e6"+
		"\u01e7\7P\2\2\u01e7\u01e8\7G\2\2\u01e8\u01e9\7$\2\2\u01e9\u01ea\7<\2\2"+
		"\u01ea\u01eb\7$\2\2\u01eb\u01f6\3\2\2\2\u01ec\u01ed\5A!\2\u01ed\u01ee"+
		"\b+\b\2\u01ee\u01f7\3\2\2\2\u01ef\u01f1\13\2\2\2\u01f0\u01ef\3\2\2\2\u01f1"+
		"\u01f4\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f3\u01f5\3\2"+
		"\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f7\b+\t\2\u01f6\u01ec\3\2\2\2\u01f6"+
		"\u01f2\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01f9\7$\2\2\u01f9\u01fa\b+\n"+
		"\2\u01faV\3\2\2\2\u01fb\u01fc\7$\2\2\u01fc\u01fd\7E\2\2\u01fd\u01fe\7"+
		"T\2\2\u01fe\u01ff\7G\2\2\u01ff\u0200\7F\2\2\u0200\u0201\7K\2\2\u0201\u0202"+
		"\7V\2\2\u0202\u0203\7E\2\2\u0203\u0204\7C\2\2\u0204\u0205\7T\2\2\u0205"+
		"\u0206\7F\2\2\u0206\u0207\7$\2\2\u0207\u0208\7<\2\2\u0208\u0209\7$\2\2"+
		"\u0209\u0214\3\2\2\2\u020a\u020b\5O(\2\u020b\u020c\b,\13\2\u020c\u0215"+
		"\3\2\2\2\u020d\u020f\13\2\2\2\u020e\u020d\3\2\2\2\u020f\u0212\3\2\2\2"+
		"\u0210\u0211\3\2\2\2\u0210\u020e\3\2\2\2\u0211\u0213\3\2\2\2\u0212\u0210"+
		"\3\2\2\2\u0213\u0215\b,\f\2\u0214\u020a\3\2\2\2\u0214\u0210\3\2\2\2\u0215"+
		"\u0216\3\2\2\2\u0216\u0217\7$\2\2\u0217\u0218\b,\r\2\u0218X\3\2\2\2\u0219"+
		"\u021a\7$\2\2\u021a\u021b\5)\25\2\u021b\u021c\7$\2\2\u021c\u021d\7<\2"+
		"\2\u021d\u021e\7$\2\2\u021e\u021f\3\2\2\2\u021f\u0225\b-\16\2\u0220\u0224"+
		"\5%\23\2\u0221\u0224\5\'\24\2\u0222\u0224\7\"\2\2\u0223\u0220\3\2\2\2"+
		"\u0223\u0221\3\2\2\2\u0223\u0222\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0226"+
		"\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u0228\3\2\2\2\u0227\u0225\3\2\2\2\u0228"+
		"\u0229\b-\17\2\u0229\u022a\7$\2\2\u022a\u022b\b-\20\2\u022bZ\3\2\2\2\u022c"+
		"\u022d\7}\2\2\u022d\u0231\b.\21\2\u022e\u022f\7\177\2\2\u022f\u0231\b"+
		".\22\2\u0230\u022c\3\2\2\2\u0230\u022e\3\2\2\2\u0231\\\3\2\2\2\u0232\u0233"+
		"\7.\2\2\u0233\u0234\b/\23\2\u0234^\3\2\2\2\u0235\u0237\t\r\2\2\u0236\u0235"+
		"\3\2\2\2\u0237\u0238\3\2\2\2\u0238\u0236\3\2\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u023a\3\2\2\2\u023a\u023b\b\60\24\2\u023b`\3\2\2\2\63\2diov~\u0087\u0091"+
		"\u009c\u00a8\u00b5\u00c3\u00d2\u00e2\u00f3\u0105\u010f\u0114\u0119\u011e"+
		"\u0122\u0126\u0128\u012a\u012e\u0130\u013a\u0140\u014b\u0170\u0175\u017c"+
		"\u018a\u0196\u01a0\u01a7\u01af\u01c1\u01c5\u01d9\u01dd\u01f2\u01f6\u0210"+
		"\u0214\u0223\u0225\u0230\u0238\25\3)\2\3)\3\3)\4\3*\5\3*\6\3*\7\3+\b\3"+
		"+\t\3+\n\3,\13\3,\f\3,\r\3-\16\3-\17\3-\20\3.\21\3.\22\3/\23\3\60\24";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}