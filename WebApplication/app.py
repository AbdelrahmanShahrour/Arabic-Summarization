from urllib.parse import unquote
import arabic_reshaper
import streamlit as st
from bidi.algorithm import get_display
from summarize import get_results
import time
import requests

from streamlit_lottie import st_lottie  # pip install streamlit-lottie

from streamlit_lottie import st_lottie_spinner


st.set_page_config(
    page_title="Arabic Summarization",
    page_icon="🤖",
    layout="wide",
    initial_sidebar_state="expanded",
    menu_items={
         'Get Help': 'https://www.extremelycoolapp.com/help',
         'Report a bug': "https://www.extremelycoolapp.com/bug",
         'About': "# Arabic Text Summarizeation , abdalrahman shahrour",
    }
)


def load_lottieurl(url: str):
    r = requests.get(url)
    if r.status_code != 200:
        return None
    return r.json()


st.header('تلخيص النصوص العربية : ')

rtl = lambda w: get_display(f"{arabic_reshaper.reshape(w)}")

with open('style.css') as f:
    st.markdown(f'<style>{f.read()}</style>',unsafe_allow_html=True)


c = load_lottieurl("https://assets7.lottiefiles.com/packages/lf20_ofa3xwo7.json")
# st.sidebar.st_lottie(c)
with st.sidebar:
    st_lottie(c)
st.markdown("")


model = st.sidebar.selectbox('Select one', ['arabartsummarization', 'AraBART', 'auto-arabic-summarization', 'BERT2BERT', 'xlmroberta2xlmroberta', 'nltk_summarizer'],help="Model",)


st.sidebar.write("\n")
num_beams = st.sidebar.slider(
    "Number of beams", min_value=1, max_value=10, value=3, step=1
)

st.sidebar.write("\n")
length_penalty = st.sidebar.slider(
        "Length penalty ", min_value=0.1, max_value=3.0, value=1.0, step=0.1,
)
st.sidebar.write("\n")
number_of_sentence = st.sidebar.slider(
    "Number of sentence", min_value=1, max_value=10, value=3, step=1
)

st.sidebar.write("\n")
height = st.sidebar.slider(
    "height", min_value=200, max_value=1000, value=350, step=20
)


doc = st.text_area("ضع هنا النص المراد تلخيصه : ",height=height,value="""يجري علماء في بريطانيا تجربة لاختبار فعالية عقار إيبوبروفين لمساعدة المصابين بفيروس كورونا. وذكرت هيئة الإذاعة البريطانية "بي بي سي" أن فريق مشترك من أطباء مستشفيات "جاي" و"سانت توماس" و"كينغز كوليدج" في لندن يعتقد أن إيبوبروفين، وهو مضاد للالتهابات ومسكن للألم، يمكن أن يعالج صعوبات التنفس.
ويأمل العلماء أن يساعد هذا العلاج المنخفض التكلفة المرضى في الاستغناء عن أجهزة التنفس الصناعي. وذكرت أنه خلال فترة الاختبار، سيحصل نصف المرضى على إيبوبروفين بالإضافة إلى الرعاية المعتادة، حيث سيتم استخدام تركيبة خاصة من إيبوبروفين بدلا من الأقراص العادية التي قد يشتريها الناس عادة.""")

summarize_button = st.button(label="لخص النص")

if summarize_button:
    with st.spinner("جاري التلخيص ..."):
        result = get_results(doc, model, num_beams, length_penalty,number_of_sentence)
    if len(result) > 0:
        st.write(result)
    else:
        st.write("")
