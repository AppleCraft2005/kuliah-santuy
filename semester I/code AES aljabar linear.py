from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes
from Crypto.Util.Padding import pad, unpad

# Key yang harus memiliki 16, 24, atau 32 byte tergantung pada mode AES yang digunakan
key = get_random_bytes(16)

# Inisialisasi objek AES dengan mode ECB
cipher = AES.new(key, AES.MODE_ECB)

# Pesan yang akan dienkripsi (panjang pesan harus kelipatan 16 byte)
plaintext = input("Silahkan Masukkan Pesan yang Akan dienkripsi : ")

# Enkripsi pesan
cipher_text = cipher.encrypt(pad(plaintext.encode('utf-8'), AES.block_size))

# Dekripsi pesan
decipher = AES.new(key, AES.MODE_ECB)
decrypted_text = unpad(decipher.decrypt(cipher_text), AES.block_size)

print("Pesan Asli : ", plaintext)
print("Pesan Terenkripsi: ", cipher_text)
print("Pesan Terdekripsi: ", decrypted_text.decode('utf-8'))