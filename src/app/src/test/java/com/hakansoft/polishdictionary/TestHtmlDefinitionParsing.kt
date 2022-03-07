package com.hakansoft.polishdictionary

import org.junit.Test

import org.junit.Assert.*

/**
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestHtmlDefinitionParsing {
    @Test
    fun parse_definition_of_kraj() {
        val htmlText = "<strong>wolny</strong><em> aj</em> 1 free. <strong>~ czas</strong> leisure time. <strong>~ kraj</strong> free country. not occupied. <strong>~ stół</strong> free table. unengaged, unattached, not busy. not married, eligible. <em>av </em><strong>wolno </strong><em>or </em><strong>powoli</strong> slowly\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("wolny", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("aj", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("1 free.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ czas", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("leisure time.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ kraj", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("free country. not occupied.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ stół", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("free table. unengaged, unattached, not busy. not married, eligible.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("av", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("wolno", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("or", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("powoli", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("slowly", HtmlFontStyle.None))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_brac() {
        val htmlText = "<strong>brać</strong> 1 <em>biorę bierzesz impf, pf </em><strong>wziąć </strong><em>wezmę weźmiesz weź </em>take, take on, grasp, assume <em>(power), </em>bite <em>(of fish). </em><strong>~ pod uwagę </strong>take into consideration. <strong>~ prysznic </strong>take a shower. <strong>~ się do czegoś, za coś </strong>undertake, try one's hand at. stem from. <strong>skąd to się bierze? </strong>where does that come from? <strong>~ udział </strong>take part\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("brać", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("1", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("biorę bierzesz impf, pf", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("wziąć", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("wezmę weźmiesz weź", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("take, take on, grasp, assume", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("(power),", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("bite", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("(of fish).", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("~ pod uwagę", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("take into consideration.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ prysznic", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("take a shower.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ się do czegoś, za coś", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("undertake, try one's hand at. stem from.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("skąd to się bierze?", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("where does that come from?", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ udział", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("take part", HtmlFontStyle.None))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_gora() {
        val htmlText = "<strong>góra</strong><em> f</em> mountain, hill. <strong>do ~ry</strong> upwards. <strong>~ra lodowata</strong> lceberg. <strong>do ~ry nogami</strong> upside down. <strong>~rą </strong><em>(in team cheers)</em> hooray for. <strong>na ~rze</strong> upstairs. <strong>na ~rę </strong>(to) upstairs. <strong>pod górę</strong> uphill. <strong>u ~ry </strong>up above. <strong>w ~ry</strong> into the mountains. <strong>w ~rę</strong> up, upward, uphill. <strong>z ~ry</strong> 1 from above. 2 in advance. 3 condescendingly. <em>as av</em> tops, at most. <strong>~ pięć dolarów</strong> five dollars at most. <em>dim </em><strong>górka </strong>hill\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("góra", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("f", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("mountain, hill.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("do ~ry", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("upwards.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ra lodowata", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("lceberg.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("do ~ry nogami", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("upside down.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~rą", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("(in team cheers)", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("hooray for.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("na ~rze", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("upstairs.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("na ~rę", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("(to) upstairs.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("pod górę", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("uphill.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("u ~ry", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("up above.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("w ~ry", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("into the mountains.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("w ~rę", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("up, upward, uphill.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("z ~ry", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("1 from above. 2 in advance. 3 condescendingly.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("as av", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("tops, at most.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("~ pięć dolarów", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("five dollars at most.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("dim", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("górka", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("hill", HtmlFontStyle.None))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_poden() {
        val htmlText = "<strong>podeń</strong><em> contr of pod+niego</em>\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("podeń", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("contr of pod+niego", HtmlFontStyle.Italic))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_strak() {
        val htmlText = "<strong>strąk</strong><em> mi ‑a (seed, bean) </em>pod. <em>dim </em><strong>strączek </strong>\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("strąk", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("mi ‑a (seed, bean)", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("pod.", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("dim", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("strączek", HtmlFontStyle.Bold))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_li() {
        val htmlText = "<strong>li</strong><em> old fash </em>interrog <em>postpositional particle </em><strong>znasz li ten kraj? </strong>do you know that country? <em>(Mickiewicz)</em>\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("li", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("old fash", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("interrog", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("postpositional particle", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("znasz li ten kraj?", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("do you know that country?", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("(Mickiewicz)", HtmlFontStyle.Italic))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }

    @Test
    fun parse_definition_of_nac() {
        val htmlText = "<strong>nać</strong><em> f </em>top <em>(of carrot, etc)</em>\\r"

        val parsedHtml = mutableListOf<HtmlDefinition>()
        parsedHtml.add(HtmlDefinition("nać", HtmlFontStyle.Bold))
        parsedHtml.add(HtmlDefinition("f", HtmlFontStyle.Italic))
        parsedHtml.add(HtmlDefinition("top", HtmlFontStyle.None))
        parsedHtml.add(HtmlDefinition("(of carrot, etc)", HtmlFontStyle.Italic))

        assertEquals(parsedHtml.toList(), HtmlDefinitionParser.parse(htmlText))
    }
}