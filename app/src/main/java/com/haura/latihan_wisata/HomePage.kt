package com.haura.latihan_wisata

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haura.latihan_wisata.Adapter.AdapterGambar

class HomePage : AppCompatActivity() {


    private val imageList = arrayOf(
        R.drawable.bambu,
        R.drawable.gunungfuji,
        R.drawable.kyotojepang,
        R.drawable.terjunjepang
    )

    private val title = arrayOf("bambu", "gunungfuji", "kyotojepang", "terjunjepang")
    private val location = arrayOf("Lokasi : bambu,Jepang", "Lokasi : gunung fuji", "Lokasi : kyoto jepang", "Lokasi : air terjun")
    private val tgl = arrayOf(
        "Tgl : 20 - September - 2024",
        "Tgl : 1 - Agustus - 2024",
        "Tgl : 12 - Maret - 2024",
        "Tgl : 17 - Juni - 2024"
    )

    private val des = arrayOf(
        "bambu adalah salah satu kota terbesar dan paling penting di Jepang, terletak di wilayah Kansai, di pulau utama Honshu. Dikenal sebagai pusat ekonomi dan budaya, Osaka memiliki sejarah panjang dan memainkan peran penting dalam perkembangan Jepang, baik sebagai kota pelabuhan maupun pusat perdagangan.",
        "Gunung Fuji adalah salah satu dari \"Tiga Gunung Suci\" (三霊山, Sanreizan) bersama dengan Gunung Tate dan Gunung Haku. Gunung ini merupakan salah satu Situs Bersejarah Jepang",
        "kyoto adalah ibu kota Jepang dan salah satu kota metropolitan terbesar di dunia. Terkenal dengan gedung pencakar langit, distrik bisnis yang ramai, serta teknologi mutakhir, Tokyo adalah pusat dari kemajuan modern di Jepang. Kota ini memiliki suasana yang dinamis dengan inovasi di setiap sudut.",
        "terjun adalah kota bersejarah yang dikenal sebagai pusat budaya tradisional Jepang. Dulunya adalah ibu kota Jepang selama lebih dari seribu tahun, Kyoto kaya akan kuil, taman, dan istana yang menggambarkan masa lalu feodal Jepang."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = AdapterGambar(this, imageList, title, location)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("Gambar", imageList[position])
            intent.putExtra("Judul", title[position])
            intent.putExtra("Lokasi", location[position])
            intent.putExtra("tanggal", tgl[position])
            intent.putExtra("Deskripsi", des[position])
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}