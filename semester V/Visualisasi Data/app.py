import streamlit as st
import pandas as pd
import numpy as np
import io
import plotly.express as px

st.set_page_config(
    page_title="Dashboard Penerbangan KKIA",
    page_icon="✈️",
    layout="wide"
)

CUSTOM_STYLE_CSS = """
<style>
.stApp {
    background-image: url("https://i.imgur.com/GvUOqTr.jpeg");
    background-size: cover;
    background-position: 30%;
    background-repeat: no-repeat;
    color: #FAFAFA;
}

.stSidebar {
    background-color: rgba(31, 42, 64, 0.2);
    /* backdrop-filter: blur(8px); */
}

header.st-emotion-cache-gquqoo.e3g0k5y1 {
    background-color: rgba(31, 42, 64, 0.2);
    backdrop-filter: blur(5px);
    border-bottom: 1px solid rgba(74, 85, 104, 0.3);
}
.stAppHeader.st-emotion-cache-gquqoo.e3g0k5y1 * {
    color: #FAFAFA !important;
}

[data-testid="stHeading"] {
    text-align: center;
    color: #FFFFFF;
}

[data-testid="stMetric"] {
    background-color: rgba(0, 0, 0, 0.5);
    border: 1px solid rgba(74, 85, 104, 0.5);
    padding: 15px 20px;
    border-radius: 10px;
    color: #FAFAFA;
    backdrop-filter: blur(3px);
    box-shadow: 0 4px 12px 5px rgba(0, 0, 0, 0.3);

}


[data-testid="stMetricLabel"] {
    color: #B0C4DE;
}

.stPlotlyChart {
    background-color: rgba(0, 0, 0, 0.5);
    border: 1px solid rgba(74, 85, 104, 0.5);
    border-radius: 10px;
    padding: 10px;
    /* margin: 5px; */
    box-sizing: border-box;
    overflow: hidden;
    backdrop-filter: blur(3px);
    box-shadow: 0 4px 12px 5px rgba(0, 0, 0, 0.3);

}
.js-plotly-plot, .plotly .plot-container {
    background-color: transparent !important;
}

div[data-testid="stAlert"] {
    background-color: rgba(0, 0, 0, 0.5) !important;    
    color: #FAFAFA !important;                        
    border: 1px solid rgba(74, 85, 104, 0.5) !important; 
    border-radius: 10px !important;                    
    padding: 25px !important;                          
    backdrop-filter: blur(3px);                       
}

div[data-testid="stAlert"] > div {
    text-align: justify;
    background-color: transparent !important; 
    border: none !important; 
    padding: 0 !important; 
    color: inherit !important;
}

div[data-testid="stAlert"] a {
    color: #9EC5FE !important; 
}

.stImage > img {
    border-radius: 10px;
    box-shadow: 0 4px 12px 0 rgba(0, 0, 0, 0.3);
}


</style>
"""
st.markdown(CUSTOM_STYLE_CSS, unsafe_allow_html=True)
px.defaults.template = "plotly_dark"

NAMA_FILE_DATA = "flights-ruh-cleaned.csv" 

@st.cache_data
def load_data(path):
    try:
        data = pd.read_csv(path, na_values=['\\N', 'Unknown']) 
        for col in ['airline.name', 'destination_airport_name', 'flight_type', 'movement.terminal']:
             if col in data.columns:
                 data[col] = data[col].fillna('Unknown')
        return data
    except Exception as e:
        st.error(f"Gagal memuat data: {e}")
        return None

st.markdown("<h1 style='text-align: center; margin-bottom: 25px;'>Dashboard Analisis Operasional <br> Bandara Internasional King Khalid (KKIA) </h1>", unsafe_allow_html=True)

col1, col2 = st.columns([1, 1])

with col1:
    st.markdown("""
    **Bandara Internasional King Khalid (KKIA)**, dibuka pada tahun 1983, dan menjadi gerbang udara utama ke Riyadh, ibu kota Arab Saudi. Sebagai salah satu bandara terbesar di dunia dan penghubung utama bagi maskapai raksasa seperti **Saudia**, **flynas**, dan **flyadeal**, KKIA memainkan peran krusial dalam Visi 2030 Arab Saudi untuk menjadi pusat logistik dan pariwisata global. Setiap hari, puluhan ribu penumpang dan ratusan penerbangan bergerak melalui terminalnya, menciptakan tantangan operasional kompleks yang akan dibedah secara visual melalui dashboard ini.
    """)

with col2:
    INTRO_IMAGE_URL = "https://www.lot.com/content/dam/lot/lot-com/other-images/airports/ruh/riyadh-airport-2.coreimg.jpg/1750148880789/riyadh-airport-2.jpg"
    st.image(INTRO_IMAGE_URL, width=500, caption="Ilustrasi Terminal Bandara KKIA (Foto: lot.com)")

data_bersih = load_data(NAMA_FILE_DATA)

if data_bersih is not None:

    st.sidebar.header("Filter Dashboard")
    opsi_tipe = ['Semua'] + data_bersih['flight_type'].unique().tolist()
    tipe_terpilih = st.sidebar.selectbox("Pilih Tipe Penerbangan:", opsi_tipe)

    opsi_maskapai = sorted(data_bersih['airline.name'].unique())
    maskapai_terpilih = st.sidebar.multiselect("Pilih Maskapai:", opsi_maskapai)

    opsi_rute = sorted(data_bersih['destination_airport_name'].unique())
    rute_terpilih = st.sidebar.multiselect("Pilih Rute", opsi_rute)

    urutan_hari_benar = ['Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu', 'Minggu']
    opsi_hari = data_bersih['hari'].unique()
    opsi_hari_terurut = pd.Categorical(opsi_hari, categories=urutan_hari_benar, ordered=True).sort_values().tolist()
    hari_terpilih = st.sidebar.multiselect("Pilih Hari", opsi_hari_terurut)

    data_filtered = data_bersih.copy()
    if tipe_terpilih != "Semua":
        data_filtered = data_filtered[data_filtered['flight_type'] == tipe_terpilih]
    if maskapai_terpilih:
        data_filtered = data_filtered[data_filtered['airline.name'].isin(maskapai_terpilih)]
    if rute_terpilih:
        data_filtered = data_filtered[data_filtered['destination_airport_name'].isin(rute_terpilih)]
    if hari_terpilih:
        data_filtered = data_filtered[data_filtered['hari'].isin(hari_terpilih)]

    with st.expander("Lihat Data Mentah Hasil Filter"):
        st.dataframe(data_filtered)
        st.caption(f"Menampilkan {len(data_filtered)} baris data setelah difilter.")


    if 'waktu' in data_filtered.columns and 'jam' not in data_filtered.columns:
         data_filtered['jam'] = data_filtered['waktu'].dt.hour
    if 'waktu' in data_filtered.columns and 'hari' not in data_filtered.columns:
         data_filtered['hari'] = data_filtered['waktu'].dt.day_name()
         hari_map = {
             'Monday': 'Senin', 'Tuesday': 'Selasa', 'Wednesday': 'Rabu',
             'Thursday': 'Kamis', 'Friday': 'Jumat', 'Saturday': 'Sabtu',
             'Sunday': 'Minggu'
         }
         data_filtered['hari'] = data_filtered['hari'].map(hari_map)

    total_penerbangan = len(data_filtered)
    jumlah_maskapai_unik = data_filtered['airline.name'].nunique()
    jumlah_destinasi_unik = data_filtered['destination_airport_name'].nunique()

    st.markdown("---")
    st.subheader("Ringkasan Data (Hasil Filter)")

    col_m1, col_m2, col_m3 = st.columns(3)

    with col_m1:
        st.metric(label="Total Penerbangan", value=f"{total_penerbangan:,}")
    with col_m2:
        st.metric(label="Maskapai Unik", value=f"{jumlah_maskapai_unik:,}")
    with col_m3:
        st.metric(label="Jumlah Destinasi Unik", value=f"{jumlah_destinasi_unik:,}")

    st.markdown("---")

    st.header("Analisis Operasional Bandara")

    if data_filtered.empty or 'jam' not in data_filtered.columns or 'hari' not in data_filtered.columns:
        st.warning("Tidak ada data yang sesuai dengan kriteria filter Anda atau data waktu tidak valid.")
        st.caption("Sumber Data: King Khalid International Airport (KKIA) Flights Dataset | Diunduh dari Kaggle | Oleh: Mohammed Alsubaie")
    else:
        dominasi_maskapai = data_filtered['airline.name'].value_counts().head(10).reset_index()
        dominasi_maskapai.columns = ['Maskapai', 'Jumlah Penerbangan']
        fig_maskapai = px.bar(
            dominasi_maskapai,
            x='Maskapai', y='Jumlah Penerbangan',
            title='Maskapai Paling Dominan',
            color='Maskapai', text_auto=True
        )
        fig_maskapai.update_layout(
            showlegend=False, title_font_size = 20, paper_bgcolor='rgba(0,0,0,0)',
            plot_bgcolor='rgba(0,0,0,0)', margin=dict(l=40,r=40, t=60, b=20)
        )
        fig_maskapai.update_traces(
            texttemplate='%{y:,}', 
            textposition = 'outside', 
            textfont_color='white'
        )
        st.plotly_chart(fig_maskapai)

        st.markdown("---")

        col_q2, col_q3 = st.columns(2)
        with col_q2:
            rute_sibuk = data_filtered['destination_airport_name'].value_counts().head(10).reset_index()
            rute_sibuk.columns = ['Destinasi', 'Jumlah Penerbangan']
            fig_rute = px.bar(
                rute_sibuk.sort_values(by='Jumlah Penerbangan', ascending=True),
                x='Jumlah Penerbangan', y='Destinasi', orientation='h',
                title='Destinasi Paling Banyak Dikunjungi ',
                color='Destinasi', text_auto=True
            )
            fig_rute.update_traces(
                texttemplate='%{x:,}', 
                textfont_color='white',
                textposition = 'outside', 
            ) 
            fig_rute.update_layout(
                showlegend=False, title_font_size = 20, paper_bgcolor='rgba(0,0,0,0)',
                plot_bgcolor='rgba(0,0,0,0)', margin=dict(l=40,r=40, t=60, b=20),
                xaxis_range=[0, 31000]
            )
            
            st.plotly_chart(fig_rute, use_container_width=True)
        with col_q3:
            waktu_lokal = pd.to_datetime(data_filtered['movement.scheduledTime.local'], errors='coerce')
            jam_sibuk = waktu_lokal.dt.hour.value_counts().reset_index()
            jam_sibuk.columns = ['Jam', 'Jumlah Penerbangan']
            jam_sibuk = jam_sibuk.sort_values(by='Jam')
            fig_jam = px.line(
                jam_sibuk, x='Jam', y='Jumlah Penerbangan',
                title='Jumlah Penerbangan per Jam dalam Sehari',
                markers=True
            )
            fig_jam.update_xaxes(
                tickmode = 'array', tickvals = [0, 5, 10, 15, 20],
                ticktext = ['00:00', '05:00', '10:00', '15:00', '20:00']
            )
            fig_jam.update_traces(
                hovertemplate="Jam: %{x:02d}:00<br>Jumlah Penerbangan: %{y:,}<extra></extra>"
            )
            fig_jam.update_layout(
                title_font_size = 20, paper_bgcolor='rgba(0,0,0,0)',
                plot_bgcolor='rgba(0,0,0,0)', margin=dict(l=40,r=40, t=60, b=20)
            )
            st.plotly_chart(fig_jam, use_container_width=True)

        st.markdown("---")

        col_q4, col_q5 = st.columns(2)
        with col_q4:
            proporsi_tipe = data_filtered['flight_type'].value_counts().reset_index()
            proporsi_tipe.columns = ['Tipe Penerbangan', 'Jumlah']
            label_map = {'arrival': 'Kedatangan', 'departure': 'Keberangkatan'}
            proporsi_tipe['Tipe Penerbangan'] = proporsi_tipe['Tipe Penerbangan'].map(label_map).fillna(proporsi_tipe['Tipe Penerbangan'])
            fig_pie = px.pie(
                proporsi_tipe, 
                names='Tipe Penerbangan', 
                values='Jumlah',
                title='Proporsi Kedatangan vs Keberangkatan', 
                hole=0.3,
                color= 'Tipe Penerbangan',
                color_discrete_map={'Keberangkatan':'#EF553B', 'Kedatangan':'#636EFA'} 
            )
            fig_pie.update_traces(textposition='outside', textinfo='percent+label', textfont_color='white') 
            fig_pie.update_layout(
                showlegend=False, title_font_size = 20, paper_bgcolor='rgba(0,0,0,0)',
                plot_bgcolor='rgba(0,0,0,0)', margin=dict(l=40,r=40, t=60, b=60)
            )
            st.plotly_chart(fig_pie, use_container_width=True)
        with col_q5:
            beban_terminal = data_filtered.groupby(['movement.terminal', 'flight_type']).size().reset_index(name='Jumlah Penerbangan')
            label_map_legenda = {'arrival': 'Kedatangan', 'departure': 'Keberangkatan'}
            beban_terminal['flight_type_indo'] = beban_terminal['flight_type'].map(label_map_legenda).fillna(beban_terminal['flight_type'])
            fig_terminal = px.bar(
                beban_terminal, 
                x='movement.terminal', 
                y='Jumlah Penerbangan',
                color='flight_type_indo', 
                title='Distribusi Lalu Lintas per Terminal',
                barmode='stack', 
                text_auto=True,
            )
            fig_terminal.update_xaxes(type='category')
            fig_terminal.update_layout(
                title_font_size = 20, paper_bgcolor='rgba(0,0,0,0)',
                plot_bgcolor='rgba(0,0,0,0)', margin=dict(l=40,r=40, t=60, b=20),
                xaxis_title="Terminal", legend_title_text='Tipe Penerbangan'
            )
            fig_terminal.update_traces(
                texttemplate='%{y:,}', 
                textfont_color='white',
                hovertemplate="Tipe: %{fullData.name}<br>" +
                              "Terminal: %{x}<br>" +
                              "Jumlah Penerbangan: %{y:,}<extra></extra>"
            ) 
            st.plotly_chart(fig_terminal, use_container_width=True)

        st.markdown("---") 
        st.header("Rekomendasi yang Dapat Diterapkan")

        st.info("""
        **Kesimpulan Utama:**
        * **Operasional Terpusat:** Maskapai **Saudia**, **flynas**, dan **flyadeal** mendominasi lalu lintas bandara, dengan mayoritas operasi mereka terkonsentrasi di **Terminal 5**.
        * **Rute Tersibuk:** Kota **Jeddah** **Dubai** , dan **Cairo** menjadi kota tujuan terpopuler di bandara ini dengan jumlah penerbangan masing-masing mencapai lebh dari 10k penerbangan
        * **Jam Sibuk :** Puncak kepadatan lalu lintas secara konsisten terjadi pada sore hari, antara pukul **16:00 hingga 20:00** UTC+3.
        * **Keseimbangan Lalu intas:** Bandara KKIA menunjukkan fungsi sebagai *hub* yang seimbang, dengan proporsi **kedatangan 49%** dan **keberangkatan 51%** yang hampir sama.

        **Rekomendasi Actionable:**
        1.  **Melakukan Pengoptimalan Sumber Daya di Terminal 5:** Mengingat Terminal 5 adalah terminal terpadat di bandara ini, prioritaskan alokasi staf keamanan, check-in, porter, ground handler, dan fasilitas seperti troli, kursi roda, elevtor, dan menambahkan gerbang check-in untuk penerbangan guna mencegah adanya penumpukan antrian Panjang yang akan berdampak kepada kenyamanan penumpang.
        2.  **Menerapkan Penjadwalan Shift Staf yang Dinamis:** Implementasikan sistem *shift* kerja yang fleksibel, dengan menambahkan jumlah petugas secara signifikan selama periode puncak jam sibuk dari jam 16:00 hingga 20:00 di seluruh terminal terlebih di terminal 5 sebagai titikpadat bandara ini, guna mempermudah akses bag penumpang jika memerlukan bantuan dari staf bandara.
        """)

        st.markdown("---") 
        st.caption("Sumber Data: King Khalid International Airport (KKIA) Flights Dataset | Diunduh dari Kaggle | Oleh: Mohammed Alsubaie")

else: 
    st.warning("Data gagal dimuat. Harap periksa nama file dan lokasinya.")
    st.caption("Sumber Data: King Khalid International Airport (KKIA) Flights Dataset | Diunduh dari Kaggle | Oleh: Mohammed Alsubaie")