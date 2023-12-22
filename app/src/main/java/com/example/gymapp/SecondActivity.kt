package com.example.gymapp

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import java.io.IOException


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Create an instance of the AsyncTask and execute it
        DescriptionWebScrape().execute()
    }

    private inner class DescriptionWebScrape : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()
            // Any pre-execution setup can go here
        }

        override fun doInBackground(vararg params: Void?): Void? {
            try {
                val document = Jsoup.connect("https://gymplus.ie/membership/").get()

                // This is specific to your code
                val elements = document.getElementsByClass("wpb_wrapper")

                // This is also specific to your code
                val theDescription = elements.text()

            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            // Anything you want to do after the task is complete
        }
    }
}
