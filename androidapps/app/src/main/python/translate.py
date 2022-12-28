from googletrans import Translator

text_ = ""
language_ = ""

def translate_M_S(text_ , language_):
    text = text_
    language = language_
    translator = Translator()
    if language == 'en':
        translated_text = translator.translate(text, dest='en')
    elif language == 'ar':
        translated_text = translator.translate(text, dest='ar')
    return str(translated_text.text)
