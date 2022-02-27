package com.hakansoft.polishdictionary

object HtmlDefinitionParser {
    fun parse(htmlText: String) : List<HtmlDefinition> {
        var currentFontStyle: HtmlFontStyle = HtmlFontStyle.Unknown
        var charBuffer: StringBuilder = StringBuilder()
        var tagStarted: Boolean = false
        var tagEnded: Boolean = false
        var result = mutableListOf<HtmlDefinition>()

        for (char: Char in htmlText) {
            if (char == '<') {
                if (charBuffer.isEmpty()) {
                    tagStarted = true
                } else {
                    result.add(HtmlDefinition(charBuffer.toString().trim(), currentFontStyle))
                    charBuffer.clear()

                    if (currentFontStyle == HtmlFontStyle.None) {
                        tagStarted = true
                    }

                    currentFontStyle = HtmlFontStyle.Unknown
                }
            } else if (char == '\\') {
                break
            } else if (tagStarted && currentFontStyle == HtmlFontStyle.Unknown) {
                if (char == 'e') currentFontStyle = HtmlFontStyle.Italic
                else if (char == 's') currentFontStyle = HtmlFontStyle.Bold
            } else if (tagStarted && currentFontStyle != HtmlFontStyle.Unknown && char == '>') {
                tagStarted = false
                continue
            } else if (!tagStarted && char != '<') {
                if (char == '/') {
                    tagEnded = true
                } else if (tagEnded && char == '>') {
                    tagEnded = false
                } else if (tagEnded) {
                    continue
                } else {
                    charBuffer.append(char)

                    if (currentFontStyle == HtmlFontStyle.Unknown) {
                        currentFontStyle = HtmlFontStyle.None
                    }
                }
            }
        }

        if (charBuffer.isNotBlank()) {
            result.add(HtmlDefinition(charBuffer.toString().trim(), currentFontStyle))
        }

        return result.toList()
    }
}