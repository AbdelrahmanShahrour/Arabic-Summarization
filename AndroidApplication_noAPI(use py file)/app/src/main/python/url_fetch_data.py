from bs4 import BeautifulSoup
from urllib.request import urlopen,Request

import nltk
import heapq
import os
from string import punctuation
punctuation = punctuation + '\n'
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

url =''
input_text = ''
number_of_sentence = ''

nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')
nltk.download('omw-1.4')

def nltk_summarizer(input_text, number_of_sentence):

    stopWords = set(nltk.corpus.stopwords.words("arabic") + nltk.corpus.stopwords.words("english"))
    word_frequencies = {}
    for word in nltk.word_tokenize(input_text):
        if word not in stopWords:
            if word not in punctuation:
                if word not in word_frequencies.keys():
                    word_frequencies[word] = 1
                else:
                    word_frequencies[word] += 1

    maximum_frequncy = max(word_frequencies.values())

    for word in word_frequencies.keys():
        word_frequencies[word] = (word_frequencies[word]/maximum_frequncy)

    sentence_list = nltk.sent_tokenize(input_text)
    sentence_scores = {}
    for sent in sentence_list:
        for word in nltk.word_tokenize(sent.lower()):
            if word in word_frequencies.keys():
                if len(sent.split(' ')) < 30:
                    if sent not in sentence_scores.keys():
                        sentence_scores[sent] = word_frequencies[word]
                    else:
                        sentence_scores[sent] += word_frequencies[word]

    summary_sentences = heapq.nlargest(number_of_sentence, sentence_scores, key=sentence_scores.get)

    summary = ' '.join(summary_sentences)
    return summary


def fetch_data(url):
    request_site = Request(url, headers={"User-Agent": "Mozilla/5.0"})
    page = urlopen(request_site)
    soup = BeautifulSoup(page, 'html.parser')
    fetched_text = u' '.join(map(lambda p: p.text, soup.find_all(['li','p'])))
#     fetched_text = u' '.join(map(lambda p: p.text, soup.find_all(['li','p']))).encode('utf-8').strip()
    return fetched_text