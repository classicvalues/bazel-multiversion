package multideps.outputs

import org.typelevel.paiges.Doc

object Docs {
  def attr(name: String, value: Doc): Doc =
    Doc.text(name) + Doc.text(" = ") + value
  def literal(value: String): Doc = quote + Doc.text(value) + quote
  def array(values: String*): Doc =
    apply(openBracket, closeBracket, values.map(literal))
  def apply(open: Doc, close: Doc, values: Iterable[Doc]): Doc =
    Doc
      .intercalate(Doc.comma + Doc.lineOrSpace, values)
      .tightBracketBy(open, close)
  val blankLine = Doc.line + Doc.line
  val quote = Doc.char('"')
  val open = Doc.char('(')
  val close = Doc.char(')')
  val openBracket = Doc.char('[')
  val closeBracket = Doc.char(']')
}