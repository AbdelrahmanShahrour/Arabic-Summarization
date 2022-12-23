from huggingface_hub.inference_api import InferenceApi

text = "شهدت مدينة طرابلس، مساء أمس الأربعاء، احتجاجات شعبية وأعمال شغب لليوم الثالث على التوالي، وذلك بسبب تردي الوضع المعيشي والاقتصادي. واندلعت مواجهات عنيفة وعمليات كر وفر ما بين الجيش اللبناني والمحتجين استمرت لساعات، إثر محاولة فتح الطرقات المقطوعة، ما أدى إلى إصابة العشرات من الطرفين."

def _model(model_num : int = 1|2 , text : str = text ) -> str:
    if model_num == 1:
        model = "abdalrahmanshahrour/arabartsummarization"
    elif model_num == 2:
        model = "abdalrahmanshahrour/AraBART-summ"
    inference = InferenceApi(repo_id= model , token="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")
    summarize = inference(inputs= text)
    print(list(summarize[0].values())[0])

_model(1)
