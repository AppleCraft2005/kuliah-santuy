SEPATUA = 400000
SEPATUB = 350000

DISKONA = 400000 * 13/100
DISKONB = 350000 * 21/100

HASILA = round(SEPATUA - DISKONA) 
HASILB = round(SEPATUB - DISKONB)
    
print("Harga Sepatu A adalah ", SEPATUA)
print("Harga Sepatu B adalah ", SEPATUB)
print("Sepatu A mendapat diskon 13% sehingga harganya menjadi ", HASILA)
print("Sepatu B mendapat diskon 21% sehingga harganya menjadi ", HASILB)