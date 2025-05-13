# 🔐 PasswortChecker (Java GUI)

Ein kleines Java-Desktop-Tool zur **Überprüfung von Passwörtern** anhand definierter Sicherheitskriterien – mit einfacher grafischer Oberfläche (Swing).

## 🧩 Funktionen

- GUI (JFrame) mit Eingabefeld und Prüfen-Button
- Validierung folgender Kriterien:
  - ✅ Mindestens 8 Zeichen
  - ✅ Mindestens ein **Großbuchstabe**
  - ✅ Mindestens ein **Kleinbuchstabe**
  - ✅ Mindestens eine **Zahl**
  - ✅ Mindestens ein **Sonderzeichen** (`!@#$%^&*` etc.)
- Ausgabe des Prüfergebnisses direkt in der Oberfläche (grün/rot)

## 🛠️ Technologie

- Programmiert in **Java**
- GUI mit **Swing** (`JFrame`, `JPanel`, `JLabel`, `JTextField`, `JButton`)
- Einfache Passwortprüfung über String-Analyse

## 🚀 Starten (lokal)

1. Kompiliere mit:
   ```bash
   javac PasswortChecker.java
