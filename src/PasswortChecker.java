import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswortChecker {

    public static void main(String[] args) {
        // JFrame für die Benutzeroberfläche erstellen
        JFrame frame = new JFrame("PasswortChecker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250); // Fenstergröße auf 150x150 setzen
        frame.setLocationRelativeTo(null); // Fenster zentrieren

        // Panel für das Layout erstellen
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout als BoxLayout in vertikaler Ausrichtung

        // Label mit den Anforderungen für das Passwort
        JLabel requirementsLabel = new JLabel("<html><b>Passwortanforderungen:</b><br>" +
                "- Mindestens 8 Zeichen<br>" +
                "- Mindestens ein Großbuchstabe<br>" +
                "- Mindestens ein Kleinbuchstabe<br>" +
                "- Mindestens eine Zahl<br>" +
                "- Mindestens ein Sonderzeichen (!@#$%^&*)</html>", JLabel.CENTER);
        panel.add(requirementsLabel);
        // Label für die Ergebnisse
        JLabel resultLabel = new JLabel("Geben Sie ein Passwort ein und drücken Sie 'Prüfen'.", JLabel.CENTER);
        panel.add(resultLabel);

        // Passwort-Eingabefeld (eine Zeile)
        JTextField passwordField = new JPasswordField(40);  // Nur 12 Zeichen Platz, um es kleiner zu halten
        passwordField.setMaximumSize(new Dimension(320, 20)); // Maximale Größe des Passwortfelds
        panel.add(passwordField);

        // Button zur Passwortprüfung
        JButton validateButton = new JButton("Prüfen");
        panel.add(validateButton);



        // ActionListener für den Button
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();

                if (istPasswortGueltig(password)) {
                    resultLabel.setText("Das Passwort ist gültig!");
                    resultLabel.setForeground(Color.GREEN);
                } else {
                    resultLabel.setText("Das Passwort ist ungültig!");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        // JFrame sichtbar machen
        frame.setVisible(true);
    }

    // Methode zur Passwortvalidierung
    public static boolean istPasswortGueltig(String password) {
        // Passwort muss mindestens 8 Zeichen lang sein
        if (password.length() < 8) {
            return false;
        }

        // Variablen für die Prüfungen
        boolean hatGrossbuchstabe = false;
        boolean hatKleinbuchstabe = false;
        boolean hatZahl = false;
        boolean hatSonderzeichen = false;

        // Durchlaufe jedes Zeichen des Passworts und prüfe auf bestimmte Kriterien
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hatGrossbuchstabe = true;
            } else if (Character.isLowerCase(c)) {
                hatKleinbuchstabe = true;
            } else if (Character.isDigit(c)) {
                hatZahl = true;
            } else if (isSonderzeichen(c)) {
                hatSonderzeichen = true;
            }
        }

        // Rückgabe der Gesamtprüfung
        return hatGrossbuchstabe && hatKleinbuchstabe && hatZahl && hatSonderzeichen;
    }

    // Methode, die überprüft, ob ein Zeichen ein Sonderzeichen ist
    public static boolean isSonderzeichen(char c) {
        return "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?".indexOf(c) >= 0;
    }
}
