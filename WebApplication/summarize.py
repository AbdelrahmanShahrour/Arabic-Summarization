import logging
import os
import re
from functools import lru_cache
from urllib.parse import unquote

import streamlit as st
from codetiming import Timer
from transformers import pipeline
from arabert.preprocess import ArabertPreprocessor
from transformers import AutoTokenizer, AutoModelForSeq2SeqLM, AutoModelForCausalLM
import tokenizers
import re
import heapq  
from string import punctuation
import nltk
from nltk.corpus import stopwords

punctuation = punctuation + '\n'
logger = logging.getLogger(__name__)
os.environ["TOKENIZERS_PARALLELISM"] = "false"

logger.info("Loading models...")
reader_time = Timer("loading", text="Time: {:.2f}", logger=logging.info)
reader_time.start()


reader_time.stop()


logger.info("Finished loading the models...")
logger.info(f"Time spent loading: {reader_time.last}")

@lru_cache(maxsize=200)
def get_results(text, model_selected, num_beams, length_penalty,number_of_sentence):
    logger.info("\n=================================================================")
    logger.info(f"Text: {text}")
    logger.info(f"model_selected: {model_selected}")
    logger.info(f"length_penalty: {length_penalty}")
    reader_time = Timer("summarize", text="Time: {:.2f}", logger=logging.info)
    reader_time.start()
    if model_selected == 'GPT-2':
        number_of_tokens_limit = 80
    else:
        number_of_tokens_limit = 150
    logger.info(f"input length: {len(text.split())}")

    if model_selected == 'arabartsummarization':
        model_name="abdalrahmanshahrour/arabartsummarization"
        preprocessor = ArabertPreprocessor(model_name="")

        tokenizer = AutoTokenizer.from_pretrained(model_name)
        model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        pipeline1 = pipeline("text2text-generation",model=model,tokenizer=tokenizer)
        result = pipeline1(text,
            pad_token_id= tokenizer.eos_token_id,
            num_beams=num_beams,
            repetition_penalty=3.0,
            max_length=200,
            length_penalty=length_penalty,
            no_repeat_ngram_size = 3)[0]['generated_text']
        logger.info('arabartsummarization')
    elif model_selected == 'AraBART':

        model_name= "abdalrahmanshahrour/AraBART-summ"
        preprocessor = ArabertPreprocessor(model_name="")

        tokenizer = AutoTokenizer.from_pretrained(model_name)
        model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        pipeline1 = pipeline("text2text-generation",model=model,tokenizer=tokenizer)
        result = pipeline1(text,
            pad_token_id= tokenizer.eos_token_id,
            num_beams=num_beams,
            repetition_penalty=3.0,
            max_length=200,
            length_penalty=length_penalty,
            no_repeat_ngram_size = 3)[0]['generated_text']
        logger.info('AraBART')
    
    elif model_selected == "auto-arabic-summarization":

        model_name="abdalrahmanshahrour/auto-arabic-summarization"
        preprocessor = ArabertPreprocessor(model_name="")

        tokenizer = AutoTokenizer.from_pretrained(model_name)
        model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        pipeline1 = pipeline("text2text-generation",model=model,tokenizer=tokenizer)
        result = pipeline1(text,
            pad_token_id= tokenizer.eos_token_id,
            num_beams=num_beams,
            repetition_penalty=3.0,
            max_length=200,
            length_penalty=length_penalty,
            no_repeat_ngram_size = 3)[0]['generated_text']
        logger.info('auto-arabic-summarization')
    
    elif model_selected == 'BERT2BERT':

        model_name="malmarjeh/bert2bert"
        preprocessor = ArabertPreprocessor(model_name="")

        tokenizer = AutoTokenizer.from_pretrained(model_name)
        model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        pipeline1 = pipeline("text2text-generation",model=model,tokenizer=tokenizer)
        result = pipeline1(text,
            pad_token_id= tokenizer.eos_token_id,
            num_beams=num_beams,
            repetition_penalty=3.0,
            max_length=200,
            length_penalty=length_penalty,
            no_repeat_ngram_size = 3)[0]['generated_text']
        logger.info('BERT2BERT')
    
    elif model_selected == "xlmroberta2xlmroberta":
        model_name="ahmeddbahaa/xlmroberta2xlmroberta-finetune-summarization-ar"
        preprocessor = ArabertPreprocessor(model_name="")

        tokenizer = AutoTokenizer.from_pretrained(model_name)
        model = AutoModelForSeq2SeqLM.from_pretrained(model_name)
        pipeline1 = pipeline("text2text-generation",model=model,tokenizer=tokenizer)
        result = pipeline1(text,
            pad_token_id= tokenizer.eos_token_id,
            num_beams=num_beams,
            repetition_penalty=3.0,
            max_length=200,
            length_penalty=length_penalty,
            no_repeat_ngram_size = 3)[0]['generated_text']
        logger.info('xlmroberta2xlmroberta')
    
    elif model_selected == "nltk_summarizer":
        # number_of_sentence = 3
        stopWords = set(nltk.corpus.stopwords.words("arabic") + nltk.corpus.stopwords.words("english"))
        word_frequencies = {}  
        for word in nltk.word_tokenize(text):  
            if word not in stopWords:
                if word not in punctuation:
                    if word not in word_frequencies.keys():
                        word_frequencies[word] = 1
                    else:
                        word_frequencies[word] += 1

        maximum_frequncy = max(list(word_frequencies.values()),default=3)

        for word in word_frequencies.keys():  
            word_frequencies[word] = (word_frequencies[word]/maximum_frequncy)

        sentence_list = nltk.sent_tokenize(text)
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

        result = ' '.join(summary_sentences)  
    else:
        result = "الرجاء اختيار نموذج"

    reader_time.stop()
    logger.info(f"Time spent summarizing: {reader_time.last}")

    return result


if __name__ == "__main__":
    results_dict = ""