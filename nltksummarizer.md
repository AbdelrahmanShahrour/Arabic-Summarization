# Getting Text Summary 
In this step will apply text tokenization which is the process of breaking down a stream of text into words, phrases, symbols, or any other meaningful elements called tokens. The main goal of this step is to extract individual words in a sentence. Along with text classifcation, in text mining, it is necessay to incorporate a parser in the pipeline which performs the tokenization of the documents. And after text tokenization will check each token that not in the english or arabic stopwords (like the words: and, or, then, etc) and not in the punctuation (like: %, #, $, etc) then calculate the frequencies for each token. 

After this step we normalize all tokens by diving that frequencies on the maximum one using:
```python
maximum_frequncy = max(word_frequencies.values())

for word in word_frequencies.keys():
    word_frequencies[word] = (word_frequencies[word] / maximum_frequncy)
```
The next step is to calculate the sentences scores for each sentence so we split the input text again into sentences using ``` nltk.sent_tokenize() ``` function and will calculate that scores in the same way in the frequencies calculation. Finnaly will use ``` heapq.nlargest() ``` function and this function will arrange the sentences in descending order and take the required number of sentences and join it to create the summary.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/summarization.png)
