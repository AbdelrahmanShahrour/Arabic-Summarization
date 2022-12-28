import openai

# استخدم مفتاح التطبيق الخاص بك للتعرف على GPT-3
openai.api_key = "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"

# حدد النص المراد تلخيصه
text = ""

def api_openai_gpt3(text) :
    # حدد الحجم المطلوب للنتيجة النهائية
    summary_length = 50

    # قم بتلخيص النص
    prompt = (f"تلخيص النص التالي: {text} في حجم {summary_length} حرف"
            f"، بلغة العربية:")

    response = openai.Completion.create(
    model="text-davinci-003",
    prompt=prompt,
    temperature=0.7,
    max_tokens=600,
    top_p=1.0,
    frequency_penalty=0.0,
    presence_penalty=1
    )

    summary = response.choices[0].text

    return (summary)