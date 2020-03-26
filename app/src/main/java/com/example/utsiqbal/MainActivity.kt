package com.example.utsiqbal

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugasuts.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createFakultasData()
        fakultasParts.layoutManager = LinearLayoutManager(this)
        fakultasParts.setHasFixedSize(true)
        fakultasParts.adapter = FakultasAdapter(testData, { fakultasItem: FakultasData -> fakultasItemClicked(fakultasItem)})
    }

    private fun fakultasItemClicked(fakultasItem: FakultasData) {
        val showDetailActivityIntent = Intent(this, FakultasDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, fakultasItem.namaFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, fakultasItem.deskripsiFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, fakultasItem.listProdi.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_REFERRER, fakultasItem.fotoFakultas.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL,fakultasItem.email)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI,fakultasItem.web)
        startActivity(showDetailActivityIntent)
    }

    private fun createFakultasData() : List<FakultasData> {
        val partList = ArrayList<FakultasData>()
        partList.add(FakultasData("Fakultas Ilmu Komputer", "1. Sistem Informasi\n2. Teknik Informatika", "Fakultas Ilmu Komputer merupakan fakultas yang ada di upn dibidang komputer \"Veteran\" Jawa Timur. Yang teridiri dari program studi:\n ", R.drawable.fik, "upnjatim@upnjatim.ac.id",  "https://fik.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Teknik\n", "1. Teknik Kimia\n2. Teknik Industri\n3. Teknik Pangan\n4. Teknik Lingkungan\n5. Teknik Sipil", "Fakultas Teknik merupakan fakultas yang ada di upn dibidang teknik", R.drawable.ft, "upnjatim@upnjatim.ac.id", "http://ft.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Ekonomi dan Bisnis\n", "1. Ekonomi Pembangunan\n2. Manajemen\n3. Akuntansi", "Fakultas Ekonomi dan Bisnis merupakan fakultas yang ada di upn dibidang ekonomi dan bisnis", R.drawable.feb, "upnjatim@upnjatim.ac.id", "http://febis.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Pertanian\n", "1. Agroteknologi\n2. Agribisnis", "Fakultas Pertanian merupakan fakultas yang ada di upn dibidang pertanian", R.drawable.fp,"upnjatim@upnjatim.ac.id","http://faperta.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Hukum \n", "1. Ilmu Hukum\n", "Fakultas Hukum merupakan fakultas yang ada di upn dibidang hukum", R.drawable.hkm,"upnjatim@upnjatim.ac.id", "http://fhukum.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Arsitektur dan Desain \n", "1. Arsitektur\n2.Desain Komnikasi Visual", "Fakultas Arsitek dan Desain merupakan fakultas yang ada di upn dibidang arsitektur dan desain", R.drawable.fad, "upnjatim@upnjatim.ac.id", "http://fad.upnjatim.ac.id/"))
        partList.add(FakultasData("Fakultas Ilmu Sosial dan Politik\n", "1. Administrasi Negara\n2. Administrasi Niaga\n3.Hubungan Internasional\n4.Ilmu Komunikasi", "Fakultas Ilmu Sosial dan Politik merupakan fakultas yang ada di upn dibidang sosial dan politik", R.drawable.fsp, "upnjatim@upnjatim.ac.id", "http://fisip.upnjatim.ac.id/"))
        partList.add(FakultasData("Mohamad Iqbal \n", "1. Tempat, Tanggal Lahir: Malang, 7 September 1999\n2. Alamat: Semolowaru Elok Ai/9A \n3. No.HP: 081238189441\n4. Email: semolowaru.mohamadiqbal@gmail.com\n5. Url Github: \n6. Riwayat Pendidikan: \n\t SD: sd muhammadiyah 16\n\t SMP: smp al-falah deltasari \n\t SMA: sma muhammadiyah 2 \n7. Penghargaan: belum ada ", "", R.drawable.selet,"semolowaru.mohamadiqbal@gmail.com",""))
        return partList

    }
}

