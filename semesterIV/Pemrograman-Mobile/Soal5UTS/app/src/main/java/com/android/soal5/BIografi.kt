package com.android.soal5

data class organizationProp  (
    val Img: Int,
    val judul: String,
    val tanggal: String
)

val organizationList = listOf(
    organizationProp(Img = R.drawable.wrkcysec, judul = "Workshop Cyber Security 2024", tanggal = "19 Juni 2024"),
    organizationProp(Img = R.drawable.wrkiot, judul = "Workshop IOT 2024", tanggal = "31 Agustus 2024"),
    organizationProp(Img = R.drawable.mubes24, judul = "Musyawarah Besar HMTI 2024", tanggal = "21 - 22 Desember 2024"),
    organizationProp(Img = R.drawable.clsitf, judul = "IT Fest 2024", tanggal = "25 Oktober 2024"),
)

data class BiodataItem(
    val label: String,
    val value: String
)

val biodataList = listOf(
    BiodataItem("Nama", ": Jovan Gilbert Natamasindah"),
    BiodataItem("Nim", ": 2310817310002"),
    BiodataItem("Jurusan", ": Teknologi Informasi"),
    BiodataItem("Tempat/Tgl Lahir", ": Banjarmasin, 17 Juni 2005"),
    BiodataItem("Alamat", ": Jl. Anang Adenansi"),
    BiodataItem("Organisasi", ": Himpunan Mahasiswa Teknologi Informasi 2023-2024")
)

