# Arabic Text Summarization

# 1 - Automatic text summarization
### 1.1 - Introduction
Over the beyond decades, the want to summarize files has routinely been regarded to boom because of the big mass of online texts consisting of news, scholarly articles, and so on. Assigning the summarization mission to a gadget has come to be a pressing want to extract and generate key statistics from the massive quantity of textual content available. Text summarization has been a place of excessive study for the beyond 50 years, specifically for generally used languages and comparatively easy grammar consisting of English. However, the Arabic language did now no longer get hold of an awful lot of interest because of its complexity grammatically and morphologically, etc. Arabic gives researchers and builders of the Natural Language Process (NLP) program enormous demanding situations because of its difficulties.

It is important to assess the effectiveness of the summaries generated via way of means of the gadget to decide the quantity of its reliability. There are methods, both human evaluation, that is, guide evaluation, which isn't a sensible approach withinside the case of big facts sets, or routinely the usage of the ROUGE metric, which is the only one that we undertake in this study.

## 1.2 - NLP
### 1.2.1 - Problem definition
We all know that machines cannot understand human languages such as speeches, texts, or even letters, so converting these texts into machine-understandable format has become a crucial goal to enable them to perform useful tasks. The domain of study that concentrates on enabling computers to intelligently process human languages is termed Natural Language Processing or NLP for short. It is a multi-speciality field that com- bines artificial intelligence, computing science, cognitive science, information processing, and linguistics. Natural language processing appeared to facilitate the work of the user and satisfy the desire to communicate with the computer in a natural language. 

NLP is divided into two parts: 

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/38891nlg.png)

Natural Language Understanding (NLU) and Natural Language Generation (NLG). 

1.2.1.1 - Natural Language Understanding (NLU) is the part of natural language processing that helps computers understand and interpret natural language as human beings do. It is used for machine translation, question answering, and many others. 

1.2.1.2 - Natural Language Generation (NLG) is a component of natural language processing, which is the process of creating meaningful text in the form of a natural language from an internal representation. It can be considered the opposite of natural language understanding. NLG systems offer an important role in text summarization, machine translation, and dialogue systems.
## [Bibliography : Natural language processing: state of the art, current trends and challenges](https://link.springer.com/article/10.1007/s11042-022-13428-4)
### 1.2.2 - Application of NLP
1.2.2.1 - Machine translation (MT): Natural language processing is at the heart of MT because it uses machines to automatically translate the natural language (from one language to another). The challenge of machine translation is not to translate word for word, but to use grammar and tense to preserve the true meaning of the sentence

1.2.2.2 - Question answering (QA): Question answering is one of the most important tasks in natural language processing (NLP), where a system takes a natural language question as input and returns a textual answer or answer paragraph.

1.2.2.3 - Sentiment Analysis (SA): The field of sentiment analysis also called opinion mining hasreceived a lot of focus from NLP. It is the field of analyzing people’s opinions, sentiments, evaluations, and reviews to determine the positive or negative orientation of user-generated texts about entities such as products, services, and others.
## [Bibliography : Sentiment Analysis and Opinion Mining ](https://www.cs.uic.edu/~liub/FBS/SentimentAnalysis-and-OpinionMining.pdf)

1.2.2.4 - Summarization: It is the process of conveying the most important information from a source (or sources) to produce a condensed version. This task took advantage of the NLP to reformulate the generated summary into a more coherent text.

## 1.3 - Arabic language and its challenges
The Arabic language is an important language as it is the language of the Holy "Al Qur’an Al Karem" and one of the official languages in the United Nations and 24 countries and as it is the mother tongue of more than 460 million people.
### 1.3.1 - Arabic language
Before getting into the depth of the Arabic language, we will first introduce the language.

Arabic is the most widely spoken Semitic language, and it is the natively spoken medium of communication for everyday life. However, the term “Arabic language” is frequently used to refer to Modern Standard Arabic (MSA) and its dialects as a whole. The media and education use MSA as their primary written language [34]. Arabic is written from right to left using the 28-character Arabic alphabet. It is written in a cursive way, And the shape of each letter changes according to its position at the beginning of the word. middle, or end, but it does not contain capital letters. As for vowels, it can be said that They are two types: long letters and diacritics.

Before getting into the depth of the Arabic language, we will first introduce the language.
Arabic is the most widely spoken Semitic language, and it is the natively spoken medium of communication for everyday life. However, the term “Arabic language” is frequently used to refer to Modern Standard Arabic (MSA) and its dialects as a whole. The media and education use MSA as their primary written language. Arabic is written from right to left using the 28-character Arabic alphabet. It is written in a cursive way, And the shape of each letter changes according to its position at the beginning of the word. middle, or end, but it does not contain capital letters. As for vowels, it can be said that They are two types: long letters and diacritics.
### [Bibliography : Modern Standard Arabic](https://en.wikipedia.org/wiki/Modern_Standard_Arabic)
Although the Arabic language is considered to be in a situation similar to other languages, such as the English language, and there are many dialects in it, but the Arabic language has a different status because it has introduced other languages such as Persian, Berber, African, and Samaritan, and this is what made the Arabic language significantly different from its dialects
In Arabic texts there are two types of symbols:
Letters, diacritics, and additional symbols such as numbers and punctuation marks

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/THE-ARABIC-ALPHABET-IN-DIFFERENT-POSITIONS_Q640.jpg)

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Various-diacritics-for-Arabic-characters.png)

A problem arises in writing the Arabic language with numbers, because most of them write it with English numbers

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/png.png)

There are several problems in Arabic language texts that are not present other than in Arabic texts such as Twill and Folders and we will offer to solve them after **Arabic encoding** .
### 1.3.2 - Arabic encoding

An encoding is a method of representing the symbols in a script in a consistent manner for storage and access by machines. When it comes to encoding design and how it interacts with data storage and access, the Arabic alphabet has some unique issues. This is mostly due to the differences between Arabic and European scripts.

# ISO-8859-6
# CP-1256


**Unicode**
In order to accommodate the non-english characters, people started going a little crazy on how to use the numbers from 128 to 255 still available on a single byte. Different people would use different characters for the same numbers. Obviously, not only was it the wild wild west, but it quickly dawned that the extra available numbers could not even come close to represent the complete set of characters for some languages.

The Unicode was a brave attempt to create a single character set that could represent every characters in every imaginable language systems. This required a paradigm shift in how to interpret characters. And in this new paradigm, each character was an idealized abstract entity. Also in this system, rather than use a number, each character was represented as a code-point. The code-points were written as: U+00639, where U stands for ‘Unicode’, and the numbers are hexadecimal.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Comparing%20the%20correct%20and%20incorrect%20decoding%20of%20various%20Arabic%20encodings.png)

[Bibliography : Introduction to Arabic Natural Language Processing](https://feng.stafpu.bu.edu.eg/Electrical%20Engineering/3064/crs-12176/Files/Introduction%20to%20Arabic%20Natural%20Language%20Processing.pdf)
### 1.3.3 - PyShbak

## ar.py
```python
### =================>| arabic |<================= ###
ARABIC_CHARS = "دجحإﻹﻷأآﻵخهعغفقثصضذطكمنتالبيسشظزوةىﻻرؤءئ "
ARABIC_PUNCTUATION = ':"؟!؛،,.؍, '
ARABIC_NUM = "٠١٢٣٤٥٦٧٨٩ "
HARAKAT_MAIN = [
    "\u064b",  #  ً
    "\u064c",  #  ٌ
    "\u064d",  #  ٍ
    "\u064e",  #  َ
    "\u064f",  #  ُ
    "\u0650",  #  ِ
    "\u0651",  #  ّ
    "\u0652",  #  ْ
]
TANWEEN = HARAKAT_MAIN[0]
ALEF_CHARS = "إأٱآا" + "\u0670"
NORMAL_ALEF = "ا"
TAH_MARBOTA = "ة"
HA = "ه"
ALEF_MAKSORA = "ى"
YA = "ي"
HAMZA_CHARS = "ءؤئ" + "\u0655\u0656"  # Arabic Hamza Above and Below
NORMAL_HAMZA = "ء"
LAM_ALEF_COMBINED = [
    "\ufefb",  # ﻻ
    "\ufef7",  # ﻷ
    "\ufef9",  # ﻹ
    "\ufef5",  # ﻵ
]
LAM_ALEF_NORMAL = "\u0644\u0627"  # ﻻ

HARAKAT_OTHERS = [
    "\u0653",  #  ٓ
    "\u0654",  #  ٔ
    "\u0655",  #  ٕ
    "\u0656",  # ٖ
    "\u0657",  # ٗٗ 
    "\u0658",  # ٘
    "\u0659",  # ٙ 
    "\u065A",  #  ٚ
    "\u065B",  # ٛ 
    "\u065C",  # ٜ 
    "\u065D",  # ٝ 
    "\u065E",  # ٞ 
    "\u065F",  # ٟ 
    "\u0670",  #  ٰ   
]

HARAKAT = HARAKAT_MAIN + HARAKAT_OTHERS
TATWEEL = "\u0640"  # ـ
HONORIFIC_SIGN = [
    "\u0610",  # ؐ  
    "\u0611",  # ؑ 
    "\u0612",  # ؒ  
    "\u0613",  # ؓ  
    "\u0614",  # ؔ  
]
TATWEEL = "\u0640"  # ـ
```
## en.py
```python
ENGLISH_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz "
ENGLISH_PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\]^_`{|}~"
ENGLISH_NUM = "0123456789"
```
## general.py
```python
import nltk

### =================>| General |<================= ###

OTHER_PUNCTUATION = [
    "\xa1",
    "\xa7",
    "\xab",
    "\xb6",
    "\xb7",
    "\xbb",
    "\xbf",
    "\u037e",
    "\u0387",
    "\u055a",
    "\u055b",
    "\u055c",
    "\u055d",
    "\u055e",
    "\u055f",
    "\u0589",
    "\u058a",
    "\u05be",
    "\u05c0",
    "\u05c3",
    "\u05c6",
    "\u05f3",
    "\u05f4",
    "\u0609",
    "\u060a",
    "\u061e",
    "\u066a",
    "\u066b",
    "\u066c",
    "\u066d",
    "\u06d4",
    "\u0700",
    "\u0701",
    "\u0702",
    "\u0703",
    "\u0704",
    "\u0705",
    "\u0706",
    "\u0707",
    "\u0708",
    "\u0709",
    "\u070a",
    "\u070b",
    "\u070c",
    "\u070d",
    "\u07f7",
    "\u07f8",
    "\u07f9",
    "\u0830",
    "\u0831",
    "\u0832",
    "\u0833",
    "\u0834",
    "\u0835",
    "\u0836",
    "\u0837",
    "\u0838",
    "\u0839",
    "\u083a",
    "\u083b",
    "\u083c",
    "\u083d",
    "\u083e",
    "\u085e",
    "\u0964",
    "\u0965",
    "\u0970",
    "\u09fd",
    "\u0a76",
    "\u0af0",
    "\u0c77",
    "\u0c84",
    "\u0df4",
    "\u0e4f",
    "\u0e5a",
    "\u0e5b",
    "\u0f04",
    "\u0f05",
    "\u0f06",
    "\u0f07",
    "\u0f08",
    "\u0f09",
    "\u0f0a",
    "\u0f0b",
    "\u0f0c",
    "\u0f0d",
    "\u0f0e",
    "\u0f0f",
    "\u0f10",
    "\u0f11",
    "\u0f12",
    "\u0f14",
    "\u0f3a",
    "\u0f3b",
    "\u0f3c",
    "\u0f3d",
    "\u0f85",
    "\u0fd0",
    "\u0fd1",
    "\u0fd2",
    "\u0fd3",
    "\u0fd4",
    "\u0fd9",
    "\u0fda",
    "\u104a",
    "\u104b",
    "\u104c",
    "\u104d",
    "\u104e",
    "\u104f",
    "\u10fb",
    "\u1360",
    "\u1361",
    "\u1362",
    "\u1363",
    "\u1364",
    "\u1365",
    "\u1366",
    "\u1367",
    "\u1368",
    "\u1400",
    "\u166e",
    "\u169b",
    "\u169c",
    "\u16eb",
    "\u16ec",
    "\u16ed",
    "\u1735",
    "\u1736",
    "\u17d4",
    "\u17d5",
    "\u17d6",
    "\u17d8",
    "\u17d9",
    "\u17da",
    "\u1800",
    "\u1801",
    "\u1802",
    "\u1803",
    "\u1804",
    "\u1805",
    "\u1806",
    "\u1807",
    "\u1808",
    "\u1809",
    "\u180a",
    "\u1944",
    "\u1945",
    "\u1a1e",
    "\u1a1f",
    "\u1aa0",
    "\u1aa1",
    "\u1aa2",
    "\u1aa3",
    "\u1aa4",
    "\u1aa5",
    "\u1aa6",
    "\u1aa8",
    "\u1aa9",
    "\u1aaa",
    "\u1aab",
    "\u1aac",
    "\u1aad",
    "\u1b5a",
    "\u1b5b",
    "\u1b5c",
    "\u1b5d",
    "\u1b5e",
    "\u1b5f",
    "\u1b60",
    "\u1bfc",
    "\u1bfd",
    "\u1bfe",
    "\u1bff",
    "\u1c3b",
    "\u1c3c",
    "\u1c3d",
    "\u1c3e",
    "\u1c3f",
    "\u1c7e",
    "\u1c7f",
    "\u1cc0",
    "\u1cc1",
    "\u1cc2",
    "\u1cc3",
    "\u1cc4",
    "\u1cc5",
    "\u1cc6",
    "\u1cc7",
    "\u1cd3",
    "\u2010",
    "\u2011",
    "\u2012",
    "\u2013",
    "\u2014",
    "\u2015",
    "\u2016",
    "\u2017",
    "\u2018",
    "\u2019",
    "\u201a",
    "\u201b",
    "\u201c",
    "\u201d",
    "\u201e",
    "\u201f",
    "\u2020",
    "\u2021",
    "\u2022",
    "\u2023",
    "\u2024",
    "\u2025",
    "\u2026",
    "\u2027",
    "\u2030",
    "\u2031",
    "\u2032",
    "\u2033",
    "\u2034",
    "\u2035",
    "\u2036",
    "\u2037",
    "\u2038",
    "\u2039",
    "\u203a",
    "\u203b",
    "\u203c",
    "\u203d",
    "\u203e",
    "\u203f",
    "\u2040",
    "\u2041",
    "\u2042",
    "\u2043",
    "\u2045",
    "\u2046",
    "\u2047",
    "\u2048",
    "\u2049",
    "\u204a",
    "\u204b",
    "\u204c",
    "\u204d",
    "\u204e",
    "\u204f",
    "\u2050",
    "\u2051",
    "\u2053",
    "\u2054",
    "\u2055",
    "\u2056",
    "\u2057",
    "\u2058",
    "\u2059",
    "\u205a",
    "\u205b",
    "\u205c",
    "\u205d",
    "\u205e",
    "\u207d",
    "\u207e",
    "\u208d",
    "\u208e",
    "\u2308",
    "\u2309",
    "\u230a",
    "\u230b",
    "\u2329",
    "\u232a",
    "\u2768",
    "\u2769",
    "\u276a",
    "\u276b",
    "\u276c",
    "\u276d",
    "\u276e",
    "\u276f",
    "\u2770",
    "\u2771",
    "\u2772",
    "\u2773",
    "\u2774",
    "\u2775",
    "\u27c5",
    "\u27c6",
    "\u27e6",
    "\u27e7",
    "\u27e8",
    "\u27e9",
    "\u27ea",
    "\u27eb",
    "\u27ec",
    "\u27ed",
    "\u27ee",
    "\u27ef",
    "\u2983",
    "\u2984",
    "\u2985",
    "\u2986",
    "\u2987",
    "\u2988",
    "\u2989",
    "\u298a",
    "\u298b",
    "\u298c",
    "\u298d",
    "\u298e",
    "\u298f",
    "\u2990",
    "\u2991",
    "\u2992",
    "\u2993",
    "\u2994",
    "\u2995",
    "\u2996",
    "\u2997",
    "\u2998",
    "\u29d8",
    "\u29d9",
    "\u29da",
    "\u29db",
    "\u29fc",
    "\u29fd",
    "\u2cf9",
    "\u2cfa",
    "\u2cfb",
    "\u2cfc",
    "\u2cfe",
    "\u2cff",
    "\u2d70",
    "\u2e00",
    "\u2e01",
    "\u2e02",
    "\u2e03",
    "\u2e04",
    "\u2e05",
    "\u2e06",
    "\u2e07",
    "\u2e08",
    "\u2e09",
    "\u2e0a",
    "\u2e0b",
    "\u2e0c",
    "\u2e0d",
    "\u2e0e",
    "\u2e0f",
    "\u2e10",
    "\u2e11",
    "\u2e12",
    "\u2e13",
    "\u2e14",
    "\u2e15",
    "\u2e16",
    "\u2e17",
    "\u2e18",
    "\u2e19",
    "\u2e1a",
    "\u2e1b",
    "\u2e1c",
    "\u2e1d",
    "\u2e1e",
    "\u2e1f",
    "\u2e20",
    "\u2e21",
    "\u2e22",
    "\u2e23",
    "\u2e24",
    "\u2e25",
    "\u2e26",
    "\u2e27",
    "\u2e28",
    "\u2e29",
    "\u2e2a",
    "\u2e2b",
    "\u2e2c",
    "\u2e2d",
    "\u2e2e",
    "\u2e30",
    "\u2e31",
    "\u2e32",
    "\u2e33",
    "\u2e34",
    "\u2e35",
    "\u2e36",
    "\u2e37",
    "\u2e38",
    "\u2e39",
    "\u2e3a",
    "\u2e3b",
    "\u2e3c",
    "\u2e3d",
    "\u2e3e",
    "\u2e3f",
    "\u2e40",
    "\u2e41",
    "\u2e42",
    "\u2e43",
    "\u2e44",
    "\u2e45",
    "\u2e46",
    "\u2e47",
    "\u2e48",
    "\u2e49",
    "\u2e4a",
    "\u2e4b",
    "\u2e4c",
    "\u2e4d",
    "\u2e4e",
    "\u2e4f",
    "\u3001",
    "\u3002",
    "\u3003",
    "\u3008",
    "\u3009",
    "\u300a",
    "\u300b",
    "\u300c",
    "\u300d",
    "\u300e",
    "\u300f",
    "\u3010",
    "\u3011",
    "\u3014",
    "\u3015",
    "\u3016",
    "\u3017",
    "\u3018",
    "\u3019",
    "\u301a",
    "\u301b",
    "\u301c",
    "\u301d",
    "\u301e",
    "\u301f",
    "\u3030",
    "\u303d",
    "\u30a0",
    "\u30fb",
    "\ua4fe",
    "\ua4ff",
    "\ua60d",
    "\ua60e",
    "\ua60f",
    "\ua673",
    "\ua67e",
    "\ua6f2",
    "\ua6f3",
    "\ua6f4",
    "\ua6f5",
    "\ua6f6",
    "\ua6f7",
    "\ua874",
    "\ua875",
    "\ua876",
    "\ua877",
    "\ua8ce",
    "\ua8cf",
    "\ua8f8",
    "\ua8f9",
    "\ua8fa",
    "\ua8fc",
    "\ua92e",
    "\ua92f",
    "\ua95f",
    "\ua9c1",
    "\ua9c2",
    "\ua9c3",
    "\ua9c4",
    "\ua9c5",
    "\ua9c6",
    "\ua9c7",
    "\ua9c8",
    "\ua9c9",
    "\ua9ca",
    "\ua9cb",
    "\ua9cc",
    "\ua9cd",
    "\ua9de",
    "\ua9df",
    "\uaa5c",
    "\uaa5d",
    "\uaa5e",
    "\uaa5f",
    "\uaade",
    "\uaadf",
    "\uaaf0",
    "\uaaf1",
    "\uabeb",
    "\ufd3e",
    "\ufd3f",
    "\ufe10",
    "\ufe11",
    "\ufe12",
    "\ufe13",
    "\ufe14",
    "\ufe15",
    "\ufe16",
    "\ufe17",
    "\ufe18",
    "\ufe19",
    "\ufe30",
    "\ufe31",
    "\ufe32",
    "\ufe33",
    "\ufe34",
    "\ufe35",
    "\ufe36",
    "\ufe37",
    "\ufe38",
    "\ufe39",
    "\ufe3a",
    "\ufe3b",
    "\ufe3c",
    "\ufe3d",
    "\ufe3e",
    "\ufe3f",
    "\ufe40",
    "\ufe41",
    "\ufe42",
    "\ufe43",
    "\ufe44",
    "\ufe45",
    "\ufe46",
    "\ufe47",
    "\ufe48",
    "\ufe49",
    "\ufe4a",
    "\ufe4b",
    "\ufe4c",
    "\ufe4d",
    "\ufe4e",
    "\ufe4f",
    "\ufe50",
    "\ufe51",
    "\ufe52",
    "\ufe54",
    "\ufe55",
    "\ufe56",
    "\ufe57",
    "\ufe58",
    "\ufe59",
    "\ufe5a",
    "\ufe5b",
    "\ufe5c",
    "\ufe5d",
    "\ufe5e",
    "\ufe5f",
    "\ufe60",
    "\ufe61",
    "\ufe63",
    "\ufe68",
    "\ufe6a",
    "\ufe6b",
    "\uff01",
    "\uff02",
    "\uff03",
    "\uff05",
    "\uff06",
    "\uff07",
    "\uff08",
    "\uff09",
    "\uff0a",
    "\uff0c",
    "\uff0d",
    "\uff0e",
    "\uff0f",
    "\uff1a",
    "\uff1b",
    "\uff1f",
    "\uff20",
    "\uff3b",
    "\uff3c",
    "\uff3d",
    "\uff3f",
    "\uff5b",
    "\uff5d",
    "\uff5f",
    "\uff60",
    "\uff61",
    "\uff62",
    "\uff63",
    "\uff64",
    "\uff65",
]

ARABIC_PUNCTUATION = ':"؟!؛،,.؍,'
ENGLISH_PUNCTUATION = "!\"#$%&'()*+,-./:;<=>?@[\]^_`{|}~"


PUNCTUATION = list(ENGLISH_PUNCTUATION) + \
    list(ARABIC_PUNCTUATION) + OTHER_PUNCTUATION

EXPRESSION_EMOJIS = [
    "["
    "\U0001F600-\U0001F64F"  # emoticons
    "\U0001F300-\U0001F5FF"  # symbols & pictographs
    "\U0001F680-\U0001F6FF"  # transport & map symbols
    "\U0001F1E0-\U0001F1FF"  # flags (iOS)
    "\U00002500-\U00002BEF"  # chinese char
    "\U00002702-\U000027B0"
    "\U00002702-\U000027B0"
    "\U000024C2-\U0000FDEF"
    "\U0000FDFE-\U0001F251"
    "\U0001f926-\U0001f937"
    "\U00010000-\U0010ffff"
    "\u2640-\u2642"
    "\u2600-\u2B55"
    "\u200d"
    "\u23cf"
    "\u23e9"
    "\u231a"
    "\ufe0f"  # dingbats
    "\u3030"
    "]+"
    ]
```

## Processor.py
```python
import re

from nltk import word_tokenize

from PyShbak.ar import *
from PyShbak.en import *
from PyShbak.general import *


class Arabic_Processor:
    def remove_other_lang(text : str) -> str:
        '''
            = Keep ARABIC PUNCTUATION
            text : "أَهْلًا وسَهْلًا Hello 212"
            output : 
                ---> "أهلا وسهلا"
        '''
        chars = [char for char in text if ((char in ARABIC_CHARS) or (char in ARABIC_NUM) or (char in ARABIC_PUNCTUATION))]
        output = ''.join(chars)
        return output

    def remove_diacritics(text : str) -> str:
        '''
            text : "أَهْلًا وسَهْلًا Hello 212"
            output : 
                ---> "أهلا وسهلا Hello 212"
        '''
        chars = [char for char in text if (char not in HARAKAT)]
        output = ''.join(chars)
        return output

    def remove_arabic_punctuations(text : str) -> str:
        '''
            text : ", أَهْلًا وسَهْلًا Hello 212"
            output : 
                ---> "  أَهْلًا وسَهْلًا Hello 212"
        '''
        chars = [char for char in text if (char not in ARABIC_PUNCTUATION)]
        output = ''.join(chars)
        return output
    

    def arabic_only(text:str, numbers='No') -> str:
        '''
            text : "أهلا وسهلا 122 hello ٣٤".
            numbers : 
                -> No is a deafult value.
                    output : 
                    --->> "أهلا وسهلا"
                -> Yes : keep arabic lang with arabic num.
                    output : 
                    --->> "أهلا وسهلا ٣٤"
                -> All : keep arabic lang with all num.
                    output : 
                    --->> "أهلا وسهلا 122 ٣٤"
        '''
        if numbers not in ["No", "Yes", "All"]:
            numbers = "No"
        
        if numbers == "No":
            chars = [char for char in text if char in ARABIC_CHARS]
            output = ''.join(chars)
        elif numbers == "Yes":
            chars = [char for char in text if (char in ARABIC_CHARS) or (char in ARABIC_NUM)]
            output = ''.join(chars)
        elif numbers == "All":
            chars = [char for char in text if (char in ARABIC_CHARS) or (char in ARABIC_NUM) or (char in ENGLISH_NUM)]
            output = ''.join(chars)
        return output

    
    def with_out_num(text:str) -> str:
        '''
            text : "أهلا وسهلا 122 hello ٣٤".
                output : 
                --->  "أهلا وسهلا 122 hello ".
        '''
        chars = [char for char in text if (char not in ARABIC_NUM)]
        output = ''.join(chars)
        return output
    


class English_Processor:
    def remove_stopword(text:str) -> str:
        pass

    def english_only(text:str, numbers = "No") -> str:
        '''
            text : "أهلا وسهلا 122 hello ٣٤".
            numbers : 
                -> No is a deafult value.
                    output : 
                    --->> "hello
                -> Yes : keep english lang with english num.
                    output : 
                    --->> "122 hello "
                -> All : keep english lang with all num.
                    output : 
                    --->> "122 hello ٣٤"
        '''
        if numbers not in ["No", "Yes", "All"]:
            numbers = "No"
        
        if numbers == "No":
            chars = [char for char in text if char in ENGLISH_CHARS]
            output = ''.join(chars)
        elif numbers == "Yes":
            chars = [char for char in text if (char in ENGLISH_CHARS) or (char in ENGLISH_NUM)]
            output = ''.join(chars)
        elif numbers == "All":
            chars = [char for char in text if (char in ENGLISH_CHARS) or (char in ARABIC_NUM) or (char in ENGLISH_NUM)]
            output = ''.join(chars)
        return output


    
    def remove_english_punctuations(text:str) -> str:
        '''
            text : "أَهْلًا وسَهْلًا Hello 212 , ?"
            output : 
                ---> "أَهْلًا وسَهْلًا Hello 212"
        '''
        chars = [char for char in text if (char not in ENGLISH_PUNCTUATION)]
        output = ''.join(chars)
        return output

    
    def with_out_num(text:str) -> str:
        '''
            text : "أهلا وسهلا 122 hello ٣٤".
                output : 
                --->  "أهلا وسهلا  hello ٣٤".
        '''

        chars = [char for char in text if (char not in ENGLISH_NUM)]
        output = ''.join(chars)
        return output


class General_Processor:
    def remove_mentions(text: str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
                output : 
                ---> 'هدف لا نراه كل يوم . #LEITOT . شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
        
        '''
        output = re.sub(r" @[\w_]+ | @[\w_]+|^@[\w_]+ ", " ", string = text)
        return output
    
    def remove_hasgtag(text:str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
                output : 
                ---> 'هدف لا نراه كل يوم . . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
        
        '''
        output = re.sub(r"#.*?(?=\s)", "", string=text)
        return output
    
    def remove_links(text: str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
                output : 
                ---> 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 '
        
        '''
        output = re.sub("http[s]?://\S+|[wW]{3,}[\S/\?=\.&]+", "", string=text)
        return output
    
    def remove_punctation(self, text: str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'
                output : 
                ---> 'هدف لا نراه كل يوم  LEITOT  okiq8e شوف ابن اختي شوف 🤗 httpstcoZmVMl4sOqA'
        
        '''

        chars = [char for char in text if (char not in PUNCTUATION)]
        output = ''.join(chars)
        return output
    
    def keep_text(self, text:str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'

                output : 
                ---> 'هدف لا نراه كل يوم  LEITOT  okiq8e شوف ابن اختي شوف httpstcoZmVMl4sOqA'
        
        '''
        chars = [char for char in text if (char in ARABIC_CHARS) or (char in ENGLISH_CHARS)]
        output = ''.join(chars)
        return output
    
    def remove_emojis(text:str) -> str:
        '''
            text : 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف 🤗 https://t.co/ZmVMl4sOqA'

                output : 
                ---> 'هدف لا نراه كل يوم . #LEITOT . @oki_q8e شوف ابن اختي شوف  https://t.co/ZmVMl4sOqA'
        
        '''
        emoj = re.compile("["
        u"\U0001F600-\U0001F64F"  # emoticons
        u"\U0001F300-\U0001F5FF"  # symbols & pictographs
        u"\U0001F680-\U0001F6FF"  # transport & map symbols
        u"\U0001F1E0-\U0001F1FF"  # flags (iOS)
        u"\U00002500-\U00002BEF"  # chinese char
        u"\U00002702-\U000027B0"
        u"\U00002702-\U000027B0"
        u"\U000024C2-\U0001F251"
        u"\U0001f926-\U0001f937"
        u"\U00010000-\U0010ffff"
        u"\u2640-\u2642" 
        u"\u2600-\u2B55"
        u"\u200d"
        u"\u23cf"
        u"\u23e9"
        u"\u231a"
        u"\ufe0f"  # dingbats
        u"\u3030"
                      "]+", re.UNICODE)
        output = re.sub(emoj, '', text)
        return output

    def remove_whitespace(text: str, keep_spaces=1) -> str:
        '''
            text: "ff       ff  ff"
                output : 
                ---> 'ff ff ff'

        '''
        return re.sub(" +", " " * keep_spaces, "".join(text))

```
## Normalization.py

```python
import re

from PyShbak.ar import *
from PyShbak.en import *
from PyShbak.general import *

class Normalization_ar:
    def alef(text:str) -> str:
        for tam in ALEF_CHARS:
            text = text.replace(tam, NORMAL_ALEF)
        return text

    def lamalef(text:str) -> str:
        for tam in LAM_ALEF_COMBINED:
            text = text.replace(tam, LAM_ALEF_NORMAL)
        return text

    def hamza(text:str) -> str:
        for tam in HAMZA_CHARS:
            print(tam)
            text = text.replace(tam, NORMAL_HAMZA)
            print(text)
        return text

    
    def tah(text:str) -> str:
        text = text.replace(TAH_MARBOTA, HA)
        return text


    def madah(text:str) -> str:
        text = text.replace(TATWEEL, "")
        return text
    
    def normalization_all(text:str) -> str:
        text = Normalization_ar.alef(text)
        text = Normalization_ar.lamalef(text)
        text = Normalization_ar.hamza(text)
        text = Normalization_ar.tah(text)
        return text
```

## cleaningtext.py
```python
import re
import nltk

class Cleaner:
    def delete_repeated_characters(input_text:str) -> str:
        '''
            input_text : your text
                input : 'ههههههههههههه'
                output: 'هه'
        '''
        pattern  = r'(.)\1{2,}'
        out_text = re.sub(pattern, r"\1\1", input_text)
        return out_text

    def replace_letters(input_text:str) -> str:
        '''
        input_text : your text
            input: 'أهلا وسهلا أجمعين'
            output: 'اهلا وسهلا اجمعين'
        '''
        replace = {"أ": "ا","ة": "ه","إ": "ا","آ": "ا","": ""}
        replace = dict((re.escape(k), v) for k, v in replace.items()) 
        pattern = re.compile("|".join(replace.keys()))
        out_text = pattern.sub(lambda m: replace[re.escape(m.group(0))], input_text)
        return out_text

    def clean_text(input_text:str) -> str:
        replace = r'[/(){}\[\]|@âÂ,;\?\'\"\*…؟–’،!&\+-:؛-]'
        out_text = re.sub(replace, " ", input_text)
        words = nltk.word_tokenize(out_text)
        words = [word for word in words if word.isalpha()]
        out_text = ' '.join(words)
        return out_text

    def remove_vowelization(input_text:str) -> str:
        vowelization = re.compile(""" ّ|َ|ً|ُ|ٌ|ِ|ٍ|ْ|ـ""", re.VERBOSE)
        out_text = re.sub(vowelization, '', input_text)
        return out_text

    def remove_stopword(input_text:str, lang:str= "All") -> str:
        '''
            input_text : your text
            lang : [All:deafult, 'ar', 'en']
        '''
        if lang == "All":
            stop_words = set(nltk.corpus.stopwords.words("arabic") + nltk.corpus.stopwords.words("english"))
            tokenizer = nltk.tokenize.WhitespaceTokenizer()
            tokens = tokenizer.tokenize(input_text)
            wnl = nltk.WordNetLemmatizer()
            lemmatizedTokens =[wnl.lemmatize(t) for t in tokens]
            out_text = [w for w in lemmatizedTokens if not w in stop_words]
            out_text = ' '.join(out_text)
        
        if lang == "ar":
            stop_words = set(nltk.corpus.stopwords.words("arabic"))
            tokenizer = nltk.tokenize.WhitespaceTokenizer()
            tokens = tokenizer.tokenize(input_text)
            wnl = nltk.WordNetLemmatizer()
            lemmatizedTokens =[wnl.lemmatize(t) for t in tokens]
            out_text = [w for w in lemmatizedTokens if not w in stop_words]
            out_text = ' '.join(out_text)
        
        if lang == "en":
            stop_words = set(nltk.corpus.stopwords.words("english"))
            tokenizer = nltk.tokenize.WhitespaceTokenizer()
            tokens = tokenizer.tokenize(input_text)
            wnl = nltk.WordNetLemmatizer()
            lemmatizedTokens =[wnl.lemmatize(t) for t in tokens]
            out_text = [w for w in lemmatizedTokens if not w in stop_words]
            out_text = ' '.join(out_text)
        
        return out_text

    def stem_text(input_text:str) -> str:
        st = nltk.ISRIStemmer()
        tokenizer = nltk.tokenize.WhitespaceTokenizer()
        tokens = tokenizer.tokenize(input_text)
        out_text = [st.stem(w) for w in tokens]
        out_text = ' '.join(out_text)
        return out_text

    def text_prepare(input_text, ar_text:str, lang='All') -> str:
        out_text = Cleaner.delete_links(input_text)
        out_text = Cleaner.delete_repeated_characters(out_text)
        out_text = Cleaner.clean_text(out_text)
        out_text = Cleaner.remove_stopwords(out_text)
        if ar_text:
            out_text = Cleaner.replace_letters(out_text)
            out_text = Cleaner.remove_vowelization(out_text)
            out_text = Cleaner.stem_text(out_text)
        else:
            out_text = out_text.lower()
        return out_text
```

## [Bibliography : Arabic text summarization approaches: A comparison study](https://www.researchgate.net/profile/Hani-Alghanem/publication/348163080_Arabic_text_summarization_approaches_A_comparison_study/links/5ff187a6a6fdccdcb826718e/Arabic-text-summarization-approaches-A-comparison-study.pdf)

## 1.4 - Text Summarization
### 1.4.1 - Manual summarization
![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/man-summ.png)
### 1.4.2 - Automatic summarization
Automatic text summarization is a type of natural language processing in which a machine is given a task to analyze, comprehend, and use human language to generate a summary. The type of summary results is determined by a number of aspects, the most well-known of which are extractive and abstractive, both of which have advantages and drawbacks.

Automatic Text Summarization can be done in a variety of ways, but we will focus on two of them: extraction-based and abstraction-based summarization.

#### 1.4.2.1 - Extractive summarization
An extractive summary consists of relevant sentences selected from documents that cover the main contents without any modification on them. These sentences are selected based on statistical and linguistical features. According to these features, a score of importance is given to each sentence. Only those with higher scores will be chosen to represent the final summary and will be organized in the same order they were in the original text. The facility of implementing such a process is that it does not need deep text understanding.

**Advantages of extractive summarization**

The extractive approach may give an effective and efficient summary. This type of summarization is easy to compute because it does not handle semantics. 
This technique extracts sentences directly, thus, scores a higher accuracy. 
Besides, the gist is conveyed to the summary with the same terms used in the source text.
 So, the reader does not have to worry about the misinterpretation of the text.

**Disadvantages of extractive summarization**

The extracted sentences are often long, which makes it more likely that irrelevant information will also be included in the summary, which consumes space. 
Extractive summaries cannot capture all important information because it is often disseminated via sentences. 
Therefore, not much accurate information was provided. 
This extraction often leads to higher incoherence in the summary sentences, endures from inconsistencies and lack of balance. 
Since this technique extracts the sentences as they are, there is a high possibility that the pronouns lose their references. In addition, these types of summaries are less readablees.

#### 1.4.2.2 - Abstractive summarization


## [Bibliography : A survey on existing extractive techniques for query-based text summarization](https://ieeexplore.ieee.org/abstract/document/7377323)
## [Bibliography : Abstractive Document Summarization via Neural Model with Joint Attention](https://link.springer.com/chapter/10.1007/978-3-319-73618-1_28)
## 1.5 - Related works
### 1.5.1 - Before the emergence of BERT
### 1.5.1 - Usage of BERT after its emergence

## 1.6 - Evaluation of summaries
## 1.7 - Conclusion

---
---
# 2 - Word embedding for text summarization
## 2.1 - Introduction
## 2.2 - Word embedding
### 2.2.1 - Traditional Word Embedding
### 2.2.2 - Static Word Embedding
### 2.2.3 - Contextualized Word Embedding
## 2.3 - Word embedding based on deep learning
### 2.3.1 - Artificial Neural Network (ANN)
### 2.3.2 - Deep Networks
### 2.3.3 - Sequence-to-sequence models
### 2.3.4 - Attention mechanism
### 2.3.5 - Transformers
### 2.3.6 - BERT
### 2.3.7 - BART
### 2.3.8 - PEGASUS
## 2.4 - Conclusion
---
---
# 3 - System design
## 3.1 - Introduction
## 3.2 - Arabic text preprocessing
## 3.3 - Text summarizer based on BART
### 3.3.1 - Model construction
### 3.3.1 - Prediction phase
## 3.4 - Text summarizer based on PEGASUS
## 3.5 - Conclusion
---
---
# 4 - Implementation and results
