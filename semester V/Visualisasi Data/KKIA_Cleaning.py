import pandas as pd
import numpy as np

NAMA_FILE_INPUT = "flights-ruh.csv"
NAMA_FILE_OUTPUT = "flights-ruh-cleaned.csv" 

KOLOM_YANG_DIHAPUS = [
    'aircraft.reg', 
    'aircraft.modeS', 
    'airline.iata', 
    'codeshareStatus', 
    'status',
    'airline.icao',
    'callSign', 
    'origin_airport_icao', 
    'origin_airport_iata',
    'movement.quality',
    'destination_airport_icao',
    'destination_airport_iata',
    'movement.airport.timeZone',
]

def clean_and_transform_data(file_input):
    """
    Memuat, membersihkan, membuat fitur baru, dan menghapus kolom/baris
    yang tidak diperlukan dari dataset penerbangan.
    """
    try:
        df = pd.read_csv(file_input, na_values='\\N')
        print(f"Data awal dimuat: {df.shape[0]} baris, {df.shape[1]} kolom")

        df = df.replace('\\N', np.nan)

    except FileNotFoundError:
        print(f"Error: File '{file_input}' tidak ditemukan.")
        return None
    except Exception as e:
        print(f"Error saat memuat data: {e}")
        return None

    df['waktu'] = pd.to_datetime(
        df['movement.scheduledTime.utc'], 
        errors='coerce'
    )
  
    df['jam'] = df['waktu'].dt.hour
    df['hari'] = df['waktu'].dt.day_name()
    hari_map = {
        'Monday': 'Senin', 'Tuesday': 'Selasa', 'Wednesday': 'Rabu',
        'Thursday': 'Kamis', 'Friday': 'Jumat', 'Saturday': 'Sabtu',
        'Sunday': 'Minggu'
    }
    df['hari'] = df['hari'].map(hari_map)
    print("Kolom 'jam' dan 'hari' berhasil dibuat.")

    initial_rows = len(df)
    df['movement.terminal'] = df['movement.terminal'].fillna('Unknown') 
    df = df[df['movement.terminal'] != 'Unknown']
    rows_dropped_terminal = initial_rows - len(df)
    if rows_dropped_terminal > 0:
        print(f"Menghapus {rows_dropped_terminal} baris karena terminal 'Unknown'.")
        
    kolom_ditemukan_untuk_dihapus = [col for col in KOLOM_YANG_DIHAPUS if col in df.columns]
    if kolom_ditemukan_untuk_dihapus:
        df = df.drop(columns=kolom_ditemukan_untuk_dihapus)
        print(f"Menghapus {len(kolom_ditemukan_untuk_dihapus)} kolom: {', '.join(kolom_ditemukan_untuk_dihapus)}")
    else:
        print("Tidak ada kolom yang perlu dihapus (sesuai daftar).")
        
    print(f"Data akhir: {df.shape[0]} baris, {df.shape[1]} kolom")
    return df

if __name__ == "__main__":
    print("Memulai proses cleaning...")
    df_cleaned = clean_and_transform_data(NAMA_FILE_INPUT)

    if df_cleaned is not None:
        try:
            df_cleaned.to_csv(NAMA_FILE_OUTPUT, index=False)
            print(f"Data bersih berhasil disimpan ke '{NAMA_FILE_OUTPUT}'")
        except Exception as e:
            print(f"Error saat menyimpan file CSV: {e}")

    print("Proses cleaning selesai.")