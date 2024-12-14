package com.convertisseurchiffreenlettre

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.convertisseurchiffreenlettre.logics.EnglishConversion
import com.convertisseurchiffreenlettre.logics.FrenchConversion
import com.convertisseurchiffreenlettre.logics.GermanConversion
import com.convertisseurchiffreenlettre.logics.SpanishConversion


class MainActivity : AppCompatActivity() {
    /*private var conversionHistory: ConversionHistory? = null*/

    private lateinit var inputNumber: EditText
    private lateinit var selectLanguage: Button
    private lateinit var resultText: TextView
    private var selectedLanguage: String = "fr" // Langue par défaut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*// Initialize conversion history
        conversionHistory = ConversionHistory(this)
        val history = conversionHistory!!.history


        // Set up ListView for conversion history
        val historyListView = findViewById<ListView>(R.id.conversionHistoryRecyclerView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, history)
        historyListView.adapter = adapter*/

        inputNumber = findViewById(R.id.inputNumber)
        selectLanguage = findViewById(R.id.selectLanguage)
        resultText = findViewById(R.id.resultText)

        val exitButton: Button = findViewById(R.id.exitButton)

        exitButton.setOnClickListener {
            showExitConfirmationDialog()
        }


        // Gestion de la sélection de langue
        selectLanguage.setOnClickListener {
            showLanguageSelectionDialog()
        }

        // Ajouter un TextWatcher pour convertir dès que l'utilisateur entre un chiffre
        inputNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Appeler la conversion à chaque changement de texte
                if (s != null && s.isNotEmpty()) {
                    convertAndDisplayResult()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Rien à faire ici
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Rien à faire ici
            }
        })
    }


    private fun showLanguageSelectionDialog() {
        // Liste des langues et leurs codes correspondants
        val languages = arrayOf("Français", "Anglais", "Espagnol", "Allemand")
        val languageCodes = arrayOf("fr", "en", "es", "de")

        // Inflate le layout personnalisé pour le dialogue
        val dialogView = layoutInflater.inflate(R.layout.dialog_select_language, null)

        // Création du constructeur de la boîte de dialogue
        val builder = AlertDialog.Builder(this).apply {
            setView(dialogView)
        }

        // Initialisation des vues dans le layout de dialogue
        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val languageListView = dialogView.findViewById<ListView>(R.id.languageListView)

        // Adaptateur pour afficher la liste des langues
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)
        languageListView.adapter = adapter

        // Création de la boîte de dialogue
        val dialog = builder.create()

        // Gestion des clics sur les éléments de la liste
        languageListView.setOnItemClickListener { _, _, which, _ ->
            // Mise à jour de la langue sélectionnée
            selectedLanguage = languageCodes[which]
            selectLanguage.text = languages[which] // Mise à jour du texte du bouton

            // Message de confirmation
            Toast.makeText(this, "Langue sélectionnée : ${languages[which]}", Toast.LENGTH_SHORT).show()

            // Appel de la méthode pour convertir et afficher le résultat
            convertAndDisplayResult()

            // Fermeture de la boîte de dialogue
            dialog.dismiss()
        }

        // Affichage de la boîte de dialogue
        dialog.show()
    }


    // Fonction qui effectue la conversion et affiche le résultat
    private fun convertAndDisplayResult() {
        val number = inputNumber.text.toString()
        if (number.isEmpty()) {
            resultText.text = "Veuillez entrer un chiffre"
        } else {
            val result = convertNumberToWords(number.toDouble(), selectedLanguage)
            val displayLanguage = when (selectedLanguage) {
                "fr" -> "FRANÇAIS"
                "en" -> "ENGLISH"
                "es" -> "ESPAÑOL"
                "de" -> "DEUTSCH"
                else -> "RESULTAT"
            }
            resultText.text = "$displayLanguage : $result"
        }
    }

    // Fonction pour convertir un chiffre en lettres
    private fun convertNumberToWords(number: Double, language: String): String {
        return when (language) {
            "fr" -> FrenchConversion(number).conversion()
            "en" -> EnglishConversion(number).converter()
            "es" -> SpanishConversion(number).conversion()
            "de" -> GermanConversion(number).conversion()
            else -> "Langue non supportée"
        }
    }

    //Fonction pour interroger lorsqu'on clic sur le bouton Quitter
    private fun showExitConfirmationDialog() {
       /* AlertDialog.Builder(this, R.style.CustomAlertDialog)*/
        AlertDialog.Builder(this)
            .setMessage("Voulez-vous vraiment quitter?")
            .setPositiveButton("Oui") { dialog, _ ->
                finish() // Close the activity
                dialog.dismiss()
            }
            .setNegativeButton("Non") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }


}