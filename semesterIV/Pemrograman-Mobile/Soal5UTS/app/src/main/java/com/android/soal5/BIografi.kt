package com.android.soal5

data class organizationProp  (
    val Img: Int,
    val judul: String,
    val tanggal: String
)

val organizationList = listOf(
    organizationProp(Img = R.drawable.wrkcysec, judul = "Workshop Cyber Security 2024", tanggal = "19 Juni 2024"),
    organizationProp(Img = R.drawable.wrkiot, judul = "Workshop IOT 2024", tanggal = "31 Agustus 2024"),
    organizationProp(Img = R.drawable.rbti25, judul = "Ramadhan Bersama 2024", tanggal = "16 Maret 2024"),
    organizationProp(Img = R.drawable.clsitf, judul = "IT Fest 2024", tanggal = "25 Oktober 2024"),
)

data class BiografiProp (
    val Desc: String
)

val BiografiDescs = listOf(
    BiografiProp("Nama saya adalah Jovan Gilbert Natamasindah, lahir di Banjarmasin pada tanggal 17 Juni 2005. Saya merupakan anak pertama dari tiga bersaudara. Semenjak masa Pandemi Covid-19, saya memiliki minat yang besar dalam bidang teknologi dan komputer. Ketertarikan ini membawa saya untuk mengulik seputar teknologi terlebih pada bidang Pengembangan Web. setelah lulus dari SMA, saya memutuskan untuk melanjutkan pendidikan di jurusan Teknologi Informasi Fakultas Teknik di Universitas Lambung Mangkurat."),
    BiografiProp("Selama menjalani masa perkuliahan, saya aktif mengikuti berbagai kegiatan kampus seperti organisasi mahasiswa yaitu Himpunan Mahasiswa Teknologi Informasi, seminar teknologi, serta beberapa perlombaan pada bidang IT. Salah satu pencapaian yang saya banggakan adalah ketika berhasil menjalankan sebuah workshop Cyber Security pada tahun 2024 silam."),
    BiografiProp("Saya dikenal sebagai pribadi yang tekun, disiplin, dan senang belajar hal baru. Di waktu luang, saya suka membaca artikel teknologi, bermain game strategi, dan mengembangkan aplikasi kecil-kecilan untuk menambah keterampilan saya."),
    BiografiProp("Kedepannya, saya bercita-cita ingin menjadi seorang Website Developer yang mampu menciptakan sebuah website yang inovatif untuk memecahkan masalah masyarakat melalui teknologi bidang website."),
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

