package wangk6.travelling.helpers

class Language {
    fun code(lang: String): String {
        return when(lang) {
            "French" -> "fr"
            "Italian" -> "it"
            "Spanish" -> "es"
            "Portuguese" -> "pt"
            "Chinese" -> "zh"
            "Japanese" -> "ja"
            "Xhosa" -> "xh"
            "Malagasy" -> "mg"
            "Maori" -> "mi"
            "Hindi" -> "hi"
            "German" -> "de"
            "Dutch" -> "nl"
            else -> "en"
        }
    }
}