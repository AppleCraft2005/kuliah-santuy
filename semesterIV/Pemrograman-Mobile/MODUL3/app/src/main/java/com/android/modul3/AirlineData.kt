package com.android.modul3

data class cardProperty(
    val title: String,
    val desc: String,
    val ImageURL: String,
    val Wiki: String
)

val cardProperties = listOf(
    cardProperty(
        title = "Garuda Indonesia",
        desc = "Garuda Indonesia adalah maskapai penerbangan nasional Indonesia yang didirikan pada tahun 1949. Berbasis di Jakarta, Garuda dikenal dengan layanan penerbangannya yang berkualitas tinggi dan keramahannya, mencerminkan budaya Indonesia. Maskapai ini mengoperasikan penerbangan domestik dan internasional ke berbagai tujuan di Asia, Australia, Eropa, dan Timur Tengah. Garuda Indonesia juga merupakan anggota dari aliansi penerbangan global SkyTeam dan telah beberapa kali meraih penghargaan dunia atas pelayanan kabinnya.",
        ImageURL = "https://cdn.plnspttrs.net/11964/pk-gib-garuda-indonesia-mcdonnell-douglas-dc-10-30_PlanespottersNet_714188_a594861cb0_o.jpg",
        Wiki = "https://id.wikipedia.org/wiki/Garuda_Indonesia"
    ),
    cardProperty(
        title = "Lion Air",
        desc = "Lion Air adalah maskapai penerbangan swasta terbesar di Indonesia yang berdiri pada tahun 1999. Fokus utamanya adalah layanan penerbangan berbiaya rendah (low-cost carrier) dengan rute domestik dan internasional. Lion Air terkenal dengan jaringan penerbangan yang luas dan harga tiket yang kompetitif.",
        ImageURL = "https://cdn.plnspttrs.net/20446/pk-lhg-lion-air-boeing-747-412_PlanespottersNet_612707_2702071c86_o.jpg",
        Wiki = "https://id.wikipedia.org/wiki/Lion_Air"
    ),
    cardProperty(
        title = "Citilink",
        desc = "Citilink adalah anak perusahaan dari Garuda Indonesia yang beroperasi sebagai maskapai berbiaya rendah. Didirikan pada tahun 2001, Citilink menawarkan penerbangan domestik dan regional dengan konsep layanan yang modern, dinamis, dan lebih santai untuk menarik kalangan muda dan pelancong bisnis.",
        ImageURL = "https://cdn.plnspttrs.net/42179/pk-gaf-citilink-atr-72-600-72-212a_PlanespottersNet_1657140_83de625cfa_o.jpg",
        Wiki = "https://id.wikipedia.org/wiki/Citilink"
    ),
    cardProperty(
        title = "Super Air Jet",
        desc = "Super Air Jet adalah maskapai baru di Indonesia yang mulai beroperasi pada tahun 2021. Mengusung konsep \"new lifestyle airline\", Super Air Jet fokus melayani segmen anak muda dengan harga terjangkau, desain modern, dan rute-rute domestik populer.",
        ImageURL = "https://cdn.plnspttrs.net/14570/pk-std-super-air-jet-airbus-a320-232-wl_PlanespottersNet_1755960_137445c980_o.jpg",
        Wiki = "https://www.superairjet.com/en/about.php"
    ),
    cardProperty(
        title = "Batik Air",
        desc = "Batik Air adalah maskapai layanan penuh (full-service) dari Lion Air Group yang didirikan pada tahun 2013. Batik Air menawarkan fasilitas premium seperti makanan dalam penerbangan dan hiburan di kursi, serta menghubungkan berbagai kota besar di Indonesia dan Asia.",
        ImageURL = "https://cdn.plnspttrs.net/35032/pk-lug-batik-air-airbus-a320-214-wl_PlanespottersNet_1693958_5bbffba586_o.jpg",
        Wiki = "https://id.wikipedia.org/wiki/Batik_Air"
    ),
    cardProperty(
        title = "Pelita Air",
        desc = "Pelita Air adalah maskapai yang awalnya fokus pada penerbangan carter dan layanan energi (minyak dan gas), namun sejak 2022 mulai mengembangkan penerbangan reguler domestik. Sebagai anak usaha Pertamina, Pelita Air membawa konsep layanan penerbangan yang nyaman dan profesional.",
        ImageURL = "https://cdn.plnspttrs.net/22490/pk-pwd-pelita-air-service-airbus-a320-214-wl_PlanespottersNet_1698319_901e5c6a31_o.jpg",
        Wiki = "https://id.wikipedia.org/wiki/Pelita_Air"
    )
)

data class detailProperty(
    val title: String,
    val tglBerdiri: String,
    val armada: String,
    val rute: String,
    val website:String
)

val detailProperties = listOf(
    detailProperty(
        title = "Garuda Indonesia",
        tglBerdiri = "1 Agustus 1947",
        armada = "77",
        rute = "Belanda, Thailand, China, Hong Kong, Arab Saudi, Malaysia, Arab Saudi, Australia, Korea Selatan, Singapura, Jepang, United Arab Emirates",
        website = "https://www.garuda-indonesia.com/id/id//",
    ),
    detailProperty(
        title = "Lion Air",
        tglBerdiri = "15 November 1999",
        armada = "100",
        rute = "Arab Saudi, China, Malaysia",
        website = "https://www.lionair.co.id/",
    ),
    detailProperty(
        title = "Citilink",
        tglBerdiri = "16 Juli 2001",
        armada = "57",
        rute = "Australia, Malaysia, Papua Nugini, Singapura, Timor Leste, China",
        website = "https://www.citilink.co.id/",
    ),
    detailProperty(
        title = "Super Air Jet",
        tglBerdiri = "1 March 2021",
        armada = "61",
        rute = "Malaysia",
        website = "https://checkin.superairjet.com/dx/IUCI/",
    ),
    detailProperty(
        title = "Batik Air",
        tglBerdiri = "10 Juni 2012",
        armada = "65",
        rute = "Australia, Arab Saudi, China, India, Malaysia, Singapura, Thailand",
        website = "https://www.batikair.com.my/",
    ),
    detailProperty(
        title = "Pelita Air",
        tglBerdiri = "24 Januari 1970",
        armada = "33",
        rute = "Indonesia",
        website = "https://www.pelita-air.com/",
    )
)