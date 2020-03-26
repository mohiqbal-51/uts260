package com.example.utsiqbal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasuts.R
import kotlinx.android.synthetic.main.detail_fakultas_layout.*

class FakultasDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_fakultas_layout)

        var intentThatStartedThisActivity= getIntent()


        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var partNama = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            var partDeskripsi = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            var partListprodi = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_COMPONENT_NAME)
            var partFoto = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_REFERRER).toInt()
            var partEmail: String = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_EMAIL)
            var partWeb: String = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_ORIGINATING_URI)
            namaFakultas2.text = partNama
            deskripsiFakultas2.text = partDeskripsi
            listFakultas.text = partListprodi
            fotoFakultas2.setImageResource(partFoto)
            email.text = partEmail
            link.text = partWeb


            email.setOnClickListener {
                //Jalankan function klikWeb dengan parameter partWeb
                pencetEmail(partEmail)
            }

            link.setOnClickListener {
                //Jalankan function klikWeb dengan parameter partWeb
                clickLink(partWeb)
            }


        }
    }

    private fun pencetEmail(email: String) {
        val mailIntent = Intent(Intent.ACTION_SEND)
        mailIntent.data = Uri.parse("mailto:")
        mailIntent.type = "text/plain"
        mailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Who's Email")
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Nyobak Email")
        startActivity(Intent.createChooser(mailIntent, "Pilih Dewe Email"))

    }

    private fun clickLink(url: String) {
        val showWebActivity = Intent(this, FakulWeb::class.java)
        showWebActivity.putExtra(Intent.ACTION_VIEW,url)
        startActivity(showWebActivity)
    }
}