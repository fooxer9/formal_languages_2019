// Generated from Expr.g by ANTLR 4.7.2
package ru.mirea.lang.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		HEXNUM=10, ID=11, WS=12;
	public static final int
		RULE_program = 0, RULE_expr = 1, RULE_state_assign = 2, RULE_state_print = 3, 
		RULE_bit = 4, RULE_operand = 5, RULE_value = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expr", "state_assign", "state_print", "bit", "operand", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':='", "'print'", "'OR'", "'XOR'", "'AND'", "'('", "')'", 
			"'NOT'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "HEXNUM", 
			"ID", "WS"
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
	public String getGrammarFileName() { return "Expr.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExprParser.EOF, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==ID) {
				{
				{
				setState(14);
				expr();
				setState(15);
				match(T__0);
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22);
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

	public static class ExprContext extends ParserRuleContext {
		public State_assignContext state_assign() {
			return getRuleContext(State_assignContext.class,0);
		}
		public State_printContext state_print() {
			return getRuleContext(State_printContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				state_assign();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				state_print();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class State_assignContext extends ParserRuleContext {
		public Token var;
		public BitContext val;
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public BitContext bit() {
			return getRuleContext(BitContext.class,0);
		}
		public State_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_assign; }
	}

	public final State_assignContext state_assign() throws RecognitionException {
		State_assignContext _localctx = new State_assignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((State_assignContext)_localctx).var = match(ID);
			setState(29);
			match(T__1);
			setState(30);
			((State_assignContext)_localctx).val = bit();
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

	public static class State_printContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public State_printContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_print; }
	}

	public final State_printContext state_print() throws RecognitionException {
		State_printContext _localctx = new State_printContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_state_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__2);
			setState(33);
			match(ID);
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

	public static class BitContext extends ParserRuleContext {
		public OperandContext left;
		public Token s4;
		public List<Token> op = new ArrayList<Token>();
		public Token s5;
		public Token _tset57;
		public OperandContext operand;
		public List<OperandContext> right = new ArrayList<OperandContext>();
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public BitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bit; }
	}

	public final BitContext bit() throws RecognitionException {
		BitContext _localctx = new BitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((BitContext)_localctx).left = operand();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(36);
				((BitContext)_localctx)._tset57 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
					((BitContext)_localctx)._tset57 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((BitContext)_localctx).op.add(((BitContext)_localctx)._tset57);
				setState(37);
				((BitContext)_localctx).operand = operand();
				((BitContext)_localctx).right.add(((BitContext)_localctx).operand);
				}
				}
				setState(42);
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

	public static class OperandContext extends ParserRuleContext {
		public ValueContext left;
		public Token s6;
		public List<Token> op = new ArrayList<Token>();
		public ValueContext value;
		public List<ValueContext> right = new ArrayList<ValueContext>();
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((OperandContext)_localctx).left = value();
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(44);
				((OperandContext)_localctx).s6 = match(T__5);
				((OperandContext)_localctx).op.add(((OperandContext)_localctx).s6);
				setState(45);
				((OperandContext)_localctx).value = value();
				((OperandContext)_localctx).right.add(((OperandContext)_localctx).value);
				}
				}
				setState(50);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode HEXNUM() { return getToken(ExprParser.HEXNUM, 0); }
		public TerminalNode ID() { return getToken(ExprParser.ID, 0); }
		public BitContext bit() {
			return getRuleContext(BitContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HEXNUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(HEXNUM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(ID);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				match(T__6);
				setState(54);
				bit();
				setState(55);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				match(T__8);
				setState(58);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\3\2\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\7\6)\n\6\f\6\16\6,\13\6\3\7\3\7\3\7\7\7\61\n\7\f\7\16\7\64"+
		"\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b>\n\b\3\b\2\2\t\2\4\6\b\n\f\16"+
		"\2\3\3\2\6\7\2?\2\25\3\2\2\2\4\34\3\2\2\2\6\36\3\2\2\2\b\"\3\2\2\2\n%"+
		"\3\2\2\2\f-\3\2\2\2\16=\3\2\2\2\20\21\5\4\3\2\21\22\7\3\2\2\22\24\3\2"+
		"\2\2\23\20\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\30\3\2"+
		"\2\2\27\25\3\2\2\2\30\31\7\2\2\3\31\3\3\2\2\2\32\35\5\6\4\2\33\35\5\b"+
		"\5\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36\37\7\r\2\2\37 \7\4\2"+
		"\2 !\5\n\6\2!\7\3\2\2\2\"#\7\5\2\2#$\7\r\2\2$\t\3\2\2\2%*\5\f\7\2&\'\t"+
		"\2\2\2\')\5\f\7\2(&\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\13\3\2\2\2"+
		",*\3\2\2\2-\62\5\16\b\2./\7\b\2\2/\61\5\16\b\2\60.\3\2\2\2\61\64\3\2\2"+
		"\2\62\60\3\2\2\2\62\63\3\2\2\2\63\r\3\2\2\2\64\62\3\2\2\2\65>\7\f\2\2"+
		"\66>\7\r\2\2\678\7\t\2\289\5\n\6\29:\7\n\2\2:>\3\2\2\2;<\7\13\2\2<>\5"+
		"\16\b\2=\65\3\2\2\2=\66\3\2\2\2=\67\3\2\2\2=;\3\2\2\2>\17\3\2\2\2\7\25"+
		"\34*\62=";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}