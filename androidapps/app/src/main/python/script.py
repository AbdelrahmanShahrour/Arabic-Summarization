from huggingface_hub.inference_api import InferenceApi

text = ""

def _model(text : str = text , model_num: int=1|2|3|4|5):
    t = text
    n = int(model_num)
    if n == 1:
        model = "malmarjeh/bert2bert"
    elif n == 2:
        model = "abdalrahmanshahrour/arabartsummarization"
    elif n == 3:
        model = "ahmeddbahaa/xlmroberta2xlmroberta-finetune-summarization-ar"
    elif n == 4:
        model = "abdalrahmanshahrour/AraBART-summ"
    elif n == 5:
        model = "abdalrahmanshahrour/auto-arabic-summarization"

    inference = InferenceApi(repo_id= model , token="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")
    summarize = inference(inputs= t)
    return str(list(summarize[0].values())[0])