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
Abstractive summarization is paraphrasing the source text information concisely and understandably, as a human does. This is done with the help of a linguistic method for understanding and examining the original text. Therefore, it needs extensive natural language processing to have the ability to rewrite and paraphrase important information from text documents. In this approach, an internal semantic representation is built, and then the summary is generated using natural language generation techniques

**Advantages of abstractive**

Since the abstract method necessitates a deep analysis of the text and the capability to produce new sentences, its generated results are closer to the manual summary. This has several benefits, including reducing redundancy, maintaining a good compression rate, being more concise, semantically relevant and condensed more strongly than extractive ones.

**Disadvantages of abstractive**

The first issue that faces this approach is the difficulty to generate such a type. And its difficulty is followed by the hardness of developing a program that allows it to be done. Representation is also considered the biggest problem facing abstractive summaries. The richness of representations of abstractive systems controls their
capabilities since they cannot summarize what their representations cannot capture. Another drawback, according to, current abstractive systems often suffer from the matter that they make repetitive words, and also not treating words out-of-vocabulary appropriately.

## [Bibliography : A survey on existing extractive techniques for query-based text summarization](https://ieeexplore.ieee.org/abstract/document/7377323)
## [Bibliography : Abstractive Document Summarization via Neural Model with Joint Attention](https://link.springer.com/chapter/10.1007/978-3-319-73618-1_28)
## [Bibliography : PRE-TRAINED SUMMARIZATION DISTILLATION](https://arxiv.org/pdf/2010.13002v2.pdf)
## 1.5 - Related works
### 1.5.1 - Before the emergence of BERT
### 1.5.1 - Usage of BERT after its emergence

## 1.6 - Evaluation of summaries
## 1.7 - Conclusion

---
---
# 2 - Word embedding for text summarization
## 2.1 - Introduction
When building models whose aim is to grasp and interpret natural languages such as human languages, it is not practical for these models to directly interact with text data.
They rely mainly on statistical, mathematical, and optimization techniques. They are only able to understand numbers. This necessitates preprocessing text data and transforming it into a representation of matching scalar, allowing models to make computations and decisions. Embedding algorithms efficiently find a corresponding numerical representation of text words. 

Word embedding is the collective name for a group of language modeling and feature learning techniques in NLP in which words or phrases from vocabulary are mapped to vectors of real numbers. With the increasing human need for more effective representations that express their language fluently, embedding algorithms have evolved from representing the word with a number to representing it with vectors, and from having only one representation for each word, it has become possible for one word to have multiple representations depending on the context in which it appears. Here algorithms are divided into three types, frequency-based, static and contextual. To perform the task of summarization, these types of word embedding are used. What interests us in this work is the contextual embedding algorithms based on deep learning that help in providing a suitable representation of the intended meaning of the words in the text. The most famous development is BERT and its derivatives, which we will address later in this chapter. This chapter seeks to introduce the concept and basic types of word embedding algorithms. In addition to getting a general understanding of deep learning and the attention mechanism that is the building block of transformers, we will get to know the latter as well. Our chapter comes to a close with an overview of BERT, BART and PEGASUS.

## 2.2 - Word embedding

Word embedding, also known as distributed word representation, is the representation of words with a set of real numbers in the form of a vector for example, to capture the semantic and syntactic information of words from the unlabeled text data set. This representation enables us to relate words together that appear from a similar context where words of similar meaning have a similar representation. They regard the process of word embeddings as scattered representations of text in dimensional space that attempt to capture the meanings of the words.

Traditional word embedding (like TF-IDF), Static word embedding (like Word2Vector), and Contextualized word embedding (like BERT) are the three most common word embeddings types, according to

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/wordenb.png)

## 2.3 - Word embedding based on deep learning
### 2.3.1 - Sequence-to-sequence models
Despite the flexibility and capability of DNNs, they can only be used to solve problems when the inputs and outputs can be coherently encoded using fixed-dimension vectors.

They are not suitable for situations where the sequence length is unknown in advance. For instance, consider text summarization, which takes a large string of words as input and produces a concise summary that is likewise a sequence.

The idea was to use an LSTM network to read the input sequence one timestep at a time, resulting in a large, fixed-dimensional vector representation, and then extract the output sequence from that vector using another LSTM. This is called the sequence-to-sequence model.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Sequence-to-sequence%20architecture.png)

Sequence-to-Sequence models combine two common deep learning architectures, recurrent neural networks and the encoder-decoder model which are commonly used to solve complex language problems. Both encoder and decoder are LSTM models (or sometimes GRU models).

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Encoder-decoder%20model.png)

In case of text summarization, during training, the source text and reference summary data are tokenized and given to the encoder and decoder networks. The encoder network reads the source text and converts it to a context vector, which is then passed on to the decoder network, whose initial states are initialised by the encoder’s final states (for more details refer to), to aid in the prediction of the summary sequence.

### 2.3.2 - Attention mechanism

The attentional mechanism is a part of the neural architecture that allows highlightingrelevant aspects of the input i.e. it helps us to evaluate the importance of these elements(by calculating the weight distribution over the input sequence, assigning higher valuesto more relevant elements) and compacts them into a representation that condenses the features of the most relevant parts, called a context vector. In case of NLP, theinput is usually a series of text items.

Various structures of attention have been proposed in recent years, such as multidimensional attention and memory-based attention, but we will only address self-attention, or as it is called intra-attention, as it has become a well-established building block of neural methods in NLP. It has been used for many tasks such as abstractive summarization. Simply self-attention is an attention mechanism that measures the relationship between elements of a single sequence in order to calculate the representation of the same sequence. The inputs interact with each other, ”self”, and decide what to give more attention, to capture contextual information deep within the sentence.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/attition.jpeg)

### 2.3.3 - Transformers
The transformer has gone beyond neural models such as convolutional and recurrent neural networks in performing natural language understanding and natural language generation tasks, becoming the dominant architecture for NLP

The Transformer is a model architecture in which every output element is connected to every input element, completely dependent on the self-attention mechanisms. Transformer blocks are composed of two components: 6 layers of encoders and 6 layers of decoders. Each layer of both has two sub-layers: a multi-head self-attention mechanism and a position-wise fully connected feed-forward network. But the decoder has a third sub-layer which helps it to focus on the output of the encoder stack. Residual connections. connect each of the sub-layers in both the encoder and decoder followed by layer normalization.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/The%20Transformer%20-%20model%20architecture.png)

## [Bibliography : Layer Normalization](https://arxiv.org/abs/1607.06450)
## [Bibliography : HuggingFace's Transformers: State-of-the-art Natural Language Processing](https://arxiv.org/abs/1910.03771)

### 2.3.4 - BERT

A new era in natural language processing began with the birth of BERT, or **B**idirectional **E**ncoder **R**epresentations from **T**ransformers, a model that excelled in how well models handled language-based tasks. A significant change in the way Google’s search engine and its translator work has been observed since adopting this model in late 2019. BERT, open-sourced and trained by Google, is a method of pre-training language rep- resentations. It is the first deeply bidirectional, unsupervised system, trained only using a large set of plain text (BooksCorpus (800M words) and English Wikipedia (2,500M words)), then used for NLP tasks (such as question-answering) where it got state-of-the-art results outperforming previous unidirectional methods.

It seems that Google’s goal was to understand the user’s intent rather than his query words, so he made the model process texts in both left-to-right and right-to-left directions simultaneously to predict the intended meaning of a word depending on the previous and next context in the sentence it is in. As an example of this, we take the word ”bank” from the sentence “I made a bank deposit”. BERT represents “bank” using both “I made a” and “deposit”. In this way, it can distinguish between representing a ”bank deposit” and a ”river bank”. Google calls BERT “deeply bidirectional” because contextual representations of words start from the bottom of a deep neural network. 

in this Figure illustrates a comparison between the visualization of the neural network architecture of BERT with previous contextual pre-training methods. Based on the arrows that show the direction of information flow from the bottom to the up, it is found that BERT is deeply bidirectional, in contrast to OpenAI Generative Pre-Training (GPT) which is unidirectional [96], while Embeddings from Language Models (ElMo) is shallowly bidirectional

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Bi-directional%20BERT%20compared.png)
## [Bi-directional BERT compared to others]

However, training bidirectional models results in the problem that the word to be predicted indirectly ”see itself” in a multi-layer model and the model can therefore trivially predict the word. To solve this problem, the Masked Language Model (MLM) task was used. 15% of the words in the input are randomly masked, and then the whole sequence is fed through a deep bidirectional Transformer encoder with the objective that the masked words are only predicted based on context. For example: 

||  Input: the man went to the [MASK1]. he bought a [MASK2] of milk.

||  Labels: [MASK1] = store; [MASK2] = gallon.

In addition to being trained on the MLM, BERT was pre-trained using an unsupervised task named Next Sentence Prediction (NSP) in order for the model to be able to understand the relationship between two sentences. This happens by generating sentences from any monolingual text corpus, then selecting two sentences A and B: 50% of the time B is the next actual sentence following A labelled as IsNextSentence, and 50% of the time it is a random corpus sentence labelled as NotNextSentence. For example:

|| Sentence A: the man went to the store.

|| Sentence B: he bought a gallon of milk.

|| Label: IsNextSentence

|| Sentence A: the man went to the store.

|| Sentence B: penguins are flightless.

|| Label: NotNextSentence

To summarize the above, BERT has been pre-trained on massive amounts of text on two unsupervised tasks which are: MLM and NSP, using a large model consisting of a 12 layers transformers for BERTbase (and 24 layers for BERTlarge). Creating state-of-the-art models with BERT requires fine-tuning it with only one additional output layer after it has been initialized with pre-trained parameters and then fine-tuning those parameters using labelled data from the final tasks

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Overall%20pre-training%20and%20fine-tuning%20procedures%20for%20BERT.png)

from the BERT paper shows that the same structures are used in both pre-training and fine-tuning except for the output layers. Each downstream task ultimately has its own fine-tuned models, even though they are initialised using the same pre-trained parameters.

As for the BERT inputs and outputs, they used the WordPiece embeddings with a 30,000 token vocabulary. Pairs of sentences are grouped in a single sequence. The sequence begins with a special classification token ([CLS]) and each sentence is separated by a special token ([SEP]) e.g. separating questions/answers as shown in Figure 2.16. Each token has a learned embedding demonstrating which sentence A or B belongs to, as shown in the figure. This method allows a single sentence or a pair of sentences to be represented clearly and unambiguously in a single sequence with the intent that BERT can handle a variety of downstream tasks. For each token, its input representation is the sum of the corresponding token embeddings, the segmentation embeddings and the position embeddings, as displayed in down Figure


#### BERT models

As previously stated, BERT was trained on BooksCorpus and the English Wikipedia, and two models were provided (BERTbase with 12 layers transformers and BERTlarge with 24 layers), following which numerous well-known and frequently used models for the English language, as well as other languages, including Arabic, appeared. Some of them are listed below.

#### RoBERTa

For **R**obustly **o**ptimized BERT approach [99], improves on BERT’s pretraining approach by training the model for longer periods of time with larger batches of data, removing the next sentence prediction target, training on longer sequences, and dynamically altering the masking pattern applied to the training data.

#### DistilBERT
A general-purpose pre-trained version of BERT, was introduced by Victor Sanh et al. It contains 40% fewer parameters and runs 60% quicker than BERTbase while maintaining 97% of its language understanding capabilities. Knowledge distillation was used to train DistilBERT, which is a technique for compressing a huge model termed the teacher into a smaller model named the student. They got a smaller transformer model by distilling Bert, which retains many similarities to the original BERT model while being lighter, smaller, and faster to run.

#### AraBERT

AraBERT, built by Wissam Antoun, Fady Baly, and Hazem Hajj, is an Arabic pre-trained language model based on the BERTbase architecture. It comes in 6 variants, in- cluding, AraBERTv0.2 base and large, AraBERTv2 base and large, AraBERTv0.1 base and large, and other new models for Arabic dialects and tweets called AraBERTv0.2-Twitter base and large too. All those models are under this repository.


## [Bibliography : RoBERTa: A Robustly Optimized BERT Pretraining Approach](https://arxiv.org/abs/1907.11692)
## [Bibliography : AraBERT: Transformer-based Model for Arabic Language Understanding](https://arxiv.org/abs/2003.00104)
## [Bibliography : arabert](https://github.com/aub-mind/arabert)
## [Bibliography : DistilBERT, a distilled version of BERT: smaller, faster, cheaper and lighter](https://arxiv.org/abs/1910.01108)

### 2.3.5 - BART

BART is a model that combines **B**idirectional and **A**uto-**R**egressive **T**ransformers and pre-trains it. It is a denoising autoencoder based on a sequence-to-sequence model that can be used to perform a vast range of tasks. BART learns to recreate the original text after corrupting it with an arbitrary noising function. The noising function for generation tasks was text infilling, which used single mask tokens to mask randomly sampled text spans. It employs a basic Transformer-based neural machine translation architecture. It is almost a combination of generalised BERT (due to the bidirectional encoder) and GPT (due to the left-to-right decoder).

In Figure ---, the document is bidirectionally encoded, with random tokens replaced by masks. BERT can’t easily be utilised for generation since missing tokens are predicted independently

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/BERT.png)

Figure ---: BERT

As for GPT (Figure --e), tokens are auto-regressively anticipated, which means GPT can be employed for the generation. Words, on the other hand, can only condition in a leftward context, so bidirectional interactions are impossible to learn.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/GPT.png)

Figure --e : GPT

For BART in Figure --x , encoder inputs do not have to match decoder outputs, allowing for arbitrary noise modifications. A document has been corrupted by mask symbols being used to replace text spans. The probability of the original document (right) is computed using an autoregressive decoder after the corrupted document (left) is encoded with a bidirectional model. An uncorrupted document is used as an input to the encoder and decoder for fine-tuning, and representations from the decoder’s final hidden state are employed.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/BART.png)

Figure --x BART

The base model has 6 layers in the encoder and decoder and the large model has 2 layers in each. The architecture is similar to that used in BERT; however, BART has around 10% more parameters than the BERT model of the same size.

BART was trained by corrupting the text with a random obfuscation function. It allows applying any type of document corruption. The modifications that were used in the experiments are summarized below (Figure --m), which are token masking, token deletion, text infilling, sentence permutation, and document rotation.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Transformations%20for%20noising%20the%20input%20that%20were%20experimented%20with.png)

Figure --m Transformations for noising the input that were experimented with

BART’s representations can be utilised for a variety of downstream applications, such as abstractive question answering and summarization. BART can be easily fine-tuned for sequence generation applications because it features an autoregressive decoder. The information is copied from the input but altered in both of these tasks, which is strongly related to the pre-training goal of denoising. The input sequence is encoded by the encoder, and the outputs are generated by the decoder.

### 2.3.6 - PEGASUS
**P**re-training with **E**xtracted **G**ap-sentences for **A**bstractive **SU**mmarization **S**equence-to-sequence models, or PEGASUS , trains a transformer encoder-decoder model to increase fine-tuning performance on abstractive summarization under the idea that the closer the pre-training self-supervised objective is to the final task, the more useful the fine-tuning performance.

A self-supervised objective **G**ap **S**entence **G**eneration (GSG) in **PEGASUS** pre-training was used. Similar to extractive summarization, some full sentences are removed or masked from the input documents and the model is charged with generating them as one output sequence from the remaining phrases.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Abstractive%20Summarization%20Using%20Pegasus.png)

Figure Example of pre-taining PEGASUS on GSG

Various scenarios for selecting the gap sentence have been studied and the ideal strategy is to select ”important” sentences to mask it (the ones most similar to the rest of the document according to the ROUGE scale), which increases the resemblance of selfsupervised examples’ output to a summary.

After the model had been pre-trained on a huge number of web-crawled texts, it was put to fine-tuning on different abstractive summarization datasets including scien- tific papers, patents, short stories, emails, and legal documents. According to ROUGE and human review, Pegasus performs state-of-the-art summarization performance in 12 different summarization datasets.

## [Bibliography : PEGASUS: Pre-training with Extracted Gap-sentences for Abstractive Summarization](https://arxiv.org/abs/1912.08777)
## [Bibliography : PEGASUS: A State-of-the-Art Model for Abstractive Text Summarization](https://ai.googleblog.com/2020/06/pegasus-state-of-art-model-for.html)

---
---

# 3 - System design
## 3.1 - Introduction
In fact, the complexity of the Arabic language in terms of morphology and other aspects makes it difficult to build models that support it. From the recent past to the present, deep contextualized word embedding, especially BERT and its derivatives, have been demonstrated to function effectively in the NLP domain. We tried to take advantage of this feature to summarize the Arabic document.

We used two different methods in this work. One is based on BART, which covers fine-tuning one of the Arabic models to accomplish the summarization task. As for the second, it is the use of one of the most successful ready-made fine-tuned models for summarizing which is PEGASUS.

In the current chapter, we will provide an overview of the design architecture used to construct the abstractive Arabic text summarizer.

## 3.2 - Arabic text preprocessing

The process of preparing and cleaning raw data from impurities such as unwanted characters and symbols in order to make it suitable for building and training machine learning models is known as data preprocessing. To prepare the raw text data, segmentation and normalization processes are applied. Text segmentation is where the text is divided into sentences or sentences are divided into words as needed. Normalization refers to reducing the orthographic variation. The several aspects of cleaning raw data that can be done include the following:

* **Removing diacritics and kashidas from the Arabic text**: The diacritic is
computationally expensive, but removing it increases the ambiguity of the text, especially for words with the same letters and different meanings such as ( جبن ) means cheese, and ( جبن ) means cowardice. However, this ambiguity does not constitute an obstacle in the case of using BERT, because it recognizes the intended meaning from the context of the sentence. As for deleting the kashidas, it is with the aim of returning the word to its natural form.

* **Elimination of common misspellings** : These errors are made when replacing, for example, ( ى ) with ( ي ) or ( ة ) with ( ه ). To solve this problem, some people map all ( ي) to ( ى), ( ة) to ( ه) and change the different forms of the Arabic hamza (إ , آ , أ , ا) to one ( ا ).


* **Stemming** : recover the main units of meaning. From a morphological point of view, some people prefer to return words to their original form, as they were before their conjugation, and remove the prefixes and suffixes from them. The word becomes a stem (or root).

* **Other aspects of data preprocessing** : can be done as needed, such as removing HTML tags, punctuation, Latin letters, and URLs.

* **Tokenization** : In the case of deep contextualized word representation, the raw text is incomprehensible to the model. It requires another process that converts the data into a format that it can understand. This process is called tokenization. It is the transformation of text data into numerical values by breaking text into tokens and converting tokens to their matching IDs in the pre-trained vocabulary.

![image](https://miro.medium.com/max/640/1*fPneDs1pLKHB36VABL981Q.webp)

## [Bibliography : Arabic text preprocessing](https://medium.com/@abdalrahman_shahrour/arabic-text-preprocessing-50367c32b21f)

## 3.3 - Text summarizer based on BART

The schematic below presents the general architecture of the text summarizer, showing the set of phases that will follow, the system inputs and the outputs, as we represent in this figure

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Diagram%20of%20the%20text%20summarizer%20based%20on%20BART.png)
### fig title Diagram of the text summarizer based on BART

### 3.3.1 - Model construction

The pre-trained model BART feeds on the data intended for training, occurs so-called fine-tuning, and is ready for summarization at this point. Then it sends test data into the summarizer to summarise its texts. The process is depicted in this Figure

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Model%20construction%20process.png)
### fig name :  Model construction process

* **Fine-tuning**

Creating models for NLP tasks based on pre-trained ones requires fine-tuning. It’s a very effective training method that involves taking a model that has already been trained for a particular task and tuning or tweaking it to accomplish a second task. Fine-tuning is done by training the pre-trained model on a specific task labelled dataset using the same structures and parameters that were used in the pre-training. Even though they are all initialised using the same pre-trained parameters, each downstream task eventually has its own fine-tuned models.

In some cases, it may require the removal of only one or more final layers and the addition of one or more layers on the top layers, each depending on how similar the task to be obtained and the task on which the model was trained.

Pre-trained models can be fine-tuned for a variety of advantages, the most important of which are:

- Faster development, less computation: The training time is significantly reduced because the fine-tuned model takes less time to train. This is due to the use of pre-trained weights for the model’s first layers. Thus our network is fully trained and only needs to train the final layers, as a result of which the computation cost is reduced.

- Less data, less effort: Pre-trained models are trained on massive, large-scale datasets. Since the model’s performance improves with more training data, it is sure that getting an effective model requires an exorbitantly large data set, Which requires a lot of time and effort to collect data. The pre-trained models cames with a good solution, which is to be used without having to train one from scratch, just fine-tuning them using pre-trained weights on a much smaller dataset.

* **Pre-trained BART**

Transformers gives access to thousands of pre-trained models for a variety of tasks. AraBART is the first Arabic model based on BART in which both the encoder and decoder are pre-trained end-to-end. It is based on the BART-Base architecture, which comprises 6 encoder and 6 decoder layers, as well as 768 hidden dimensions. There are 139M parameters in AraBART in total. This model outperforms strong baselines, such as pre-trained Arabic BERT-based models and multilingual mBART and mT5 models, on multiple abstractive summarization datasets. We feed this model with preprocessed training and validation data to train it on the summarization task.

### 3.3.1 - Prediction phase

There is a test phase that follows the training. After the model has been trained on the dataset multiple times, it is ready to summarize texts. We bring an Arabic text to which we apply preprocessing and give it to the model as input. It generates a prediction in the form of tokens, i.e. numbers. These given numbers are IDs. We decode them to retrieve the summary generated by the fine-tuned model by recovering the words matching these IDs from the pre-trained vocabulary, which is the opposite of the tokenization process that took place in the data preprocessing stage.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/Process%20of%20the%20prediction%20phase.png)
### fig name Process of the prediction phase.

## 3.4 - Text summarizer based on PEGASUS

The second text summarizer that was suggested is based on google PEGASUS, and its architecture is shown in Figure [nomber].

This figure embodies the steps that the system follows to be able to perform the summarization of the Arabic document. Starting with the data, it is preprocessed and sent to the summarization process. Some sequential operations are applied to it to end it in the form of a summary.

![image](https://github.com/AbdelrahmanShahrour/Arabic-Summarization/blob/main/images/image.png)
### Diagram of text summarizer based on PEGASUS

