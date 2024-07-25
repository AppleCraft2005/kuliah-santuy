# ARRAY

# menggunakan array pada python harus mengimport library yang disediakan diluar fungsi python, yaitu : import array as arr atau import array np


# import numpy as np

# array = np.array([3,6,9,12])
# division = array/3

# print("division")
# print(type(division))


# LIST pada python

# Selain array, struktur data lain yang kerap digunakan oleh praktisi data adalah list. Jika dilihat secara sekilas, array dan list terlihat sangat mirip dan sulit dibedakan.


# list = [3,6,9,12]
# division = list/3

# print (division)
# print(type(division))


#contoh list pada python


# buah = ["anggur","apel","duku","jeruk","manggis"]

# print("isi buah indeks ke-4 adalah : {}".format(buah[4]))
# print("semua buah : ada {} item".format(len(buah)))     #len untuk mengetahui anjang list
# for tampil_semua_buah in buah :
#     print(tampil_semua_buah)


# mengganti nilai list


#contoh

# buah = ["Anggur", "Apel", "Duku", "Jeruk", "Manggis"]
# buah[2] = "Pisang"      # berarti mengganti duku dengan pisang

# print(buah)


# menambah nilai list

# terdapat 3 metode, yaitu : 
    # prepend(item)         menambhakn item dari depan
    # append(item)          menambah item dari belakang
    # insert(index, item)   menambahkan item dari index tertentu


#contoh prepend


buah = ["Anggur", "Apel", "Duku", "Jeruk", "Manggis"]
buah.prepend("Pisang")

print(buah)


#contoh append


buah = ["Anggur", "Apel", "Duku", "Jeruk", "Manggis"]
buah.append("Pisang")

print(buah)


#contoh insert


buah = ["Anggur", "Apel", "Duku", "Jeruk", "Manggis"]
buah.insert(3, "Pisang")

print(buah)