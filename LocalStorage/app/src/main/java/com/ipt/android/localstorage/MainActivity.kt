package com.ipt.android.localstorage

import android.Manifest
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.PrintStream
import java.util.Scanner


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            requestPermissions(permission, 112)
        }

        val btnSave1: Button = findViewById(R.id.btnSave1)
        val btnLoad1: Button = findViewById(R.id.btnLoad1)
        val btnSave2: Button = findViewById(R.id.btnSave2)
        val btnLoad2: Button = findViewById(R.id.btnLoad2)
        val btnSave3: Button = findViewById(R.id.btnSave3)
        val btnLoad3: Button = findViewById(R.id.btnLoad3)
        val btnSave4: Button = findViewById(R.id.btnSave4)
        val btnLoad4: Button = findViewById(R.id.btnLoad4)
        val btnSave5: Button = findViewById(R.id.btnSave5)
        val btnLoad5: Button = findViewById(R.id.btnLoad5)


        btnSave1.setOnClickListener {
            val sharedPreferences = getPreferences(MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NOME", "Paulo")
            editor.putInt("IDADE", 44)
            editor.commit()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
        }

        btnLoad1.setOnClickListener {
            val sharedPreferences = getPreferences(MODE_PRIVATE)
            val nome = sharedPreferences.getString("NOME","Sem Nome")
            val idade = sharedPreferences.getInt("IDADE", 0)
            Toast.makeText(this,"Olá " + nome + " de " + idade + " anos.",Toast.LENGTH_LONG).show()
        }

        btnSave2.setOnClickListener {
            val sharedPreferencesNomes = getSharedPreferences("nomes.dat", MODE_PRIVATE)
            val sharedPreferencesIdades = getSharedPreferences("idades.dat", MODE_PRIVATE)
            val editorNomes: SharedPreferences.Editor = sharedPreferencesNomes.edit()
            val editorIdades: SharedPreferences.Editor = sharedPreferencesIdades.edit()
            editorNomes.putString("NOME", "Paulo")
            editorIdades.putInt("IDADE", 44)
            editorNomes.commit()
            editorIdades.commit()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
        }

        btnLoad2.setOnClickListener {
            val sharedPreferencesNomes = getSharedPreferences("nomes.dat", MODE_PRIVATE)
            val sharedPreferencesIdades = getSharedPreferences("idades.dat", MODE_PRIVATE)
            val nome = sharedPreferencesNomes.getString("NOME","Sem Nome")
            val idade = sharedPreferencesIdades.getInt("IDADE", 0)
            Toast.makeText(this,"Olá " + nome + " de " + idade + " anos.",Toast.LENGTH_LONG).show()
        }

        btnSave3.setOnClickListener {
            val directory: File  = getFilesDir()
            val file: File  = File(directory, "dados.txt")
            val fo:FileOutputStream = FileOutputStream(file)
            val ps:PrintStream = PrintStream(fo)
            ps.println("Paulo")
            ps.println("44")
            ps.close()
            fo.close()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
        }

        btnLoad3.setOnClickListener {
            val directory: File  = getFilesDir()
            val file: File  = File(directory, "dados.txt")
            try {
                val fi: FileInputStream = FileInputStream(file)
                val sc: Scanner = Scanner(fi)
                val nome = sc.nextLine()
                val idade = sc.nextLine()
                sc.close()
                fi.close()
                Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
            } catch (e:FileNotFoundException) {
                Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
            }
        }

        btnSave4.setOnClickListener {
            val directory: File  = Environment.getExternalStorageDirectory()
            val file: File  = File(directory, "dados.txt")
            val fo:FileOutputStream = FileOutputStream(file)
            val ps:PrintStream = PrintStream(fo)
            ps.println("Paulo")
            ps.println("44")
            ps.close()
            fo.close()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
        }

        btnLoad4.setOnClickListener {
            val directory: File  = Environment.getExternalStorageDirectory()
            val file: File  = File(directory, "dados.txt")
            try {
                val fi: FileInputStream = FileInputStream(file)
                val sc: Scanner = Scanner(fi)
                val nome = sc.nextLine()
                val idade = sc.nextLine()
                sc.close()
                fi.close()
                Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
            } catch (e:FileNotFoundException) {
                Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
            }
        }

        btnSave5.setOnClickListener {
            val directory: File  = getCacheDir()
            val file: File  = File(directory, "dados.txt")
            val fo:FileOutputStream = FileOutputStream(file)
            val ps:PrintStream = PrintStream(fo)
            ps.println("Paulo")
            ps.println("44")
            ps.close()
            fo.close()
            Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show()
        }

        btnLoad5.setOnClickListener {
            val directory: File  = getCacheDir()
            val file: File  = File(directory, "dados.txt")
            try {
                val fi: FileInputStream = FileInputStream(file)
                val sc: Scanner = Scanner(fi)
                val nome = sc.nextLine()
                val idade = sc.nextLine()
                sc.close()
                fi.close()
                Toast.makeText(this, "Olá " + nome + " de " + idade + " anos.", Toast.LENGTH_LONG).show()
            } catch (e:FileNotFoundException) {
                Toast.makeText(this, "File not found", Toast.LENGTH_LONG).show()
            }
        }


    }
}