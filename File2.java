import java.io.*;
import java.util.Scanner;

class File2 {
    public static void main(String[] args) throws IOException {
        int count=0;
        while(true) {
            readUserInputAndWrite2File("File"+count+".txt");
            count++;
            System.out.println("Nochmal? (j/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if("n".equals(answer)){
                break;
            }
        }

    }

    private static void readUserInputAndWrite2File( String targetFilename) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Gib deinen Text ein (Leerzeile zum Beenden): ");

            write2File(reader, targetFilename);

            System.out.println("Text wurde erfolgreich in die Datei '"+targetFilename+"' geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Eingabe oder Schreiben in die Datei: " + e.getMessage());
        }
    }

    private static void write2File(BufferedReader input, String targetFilename) throws IOException {
        // Datei zum Schreiben öffnen
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFilename));) {
            String line;
            while (!(line = input.readLine()).isEmpty()) {
                // Schreibe die eingelesene Zeile in die Datei
                writeLine(bufferedWriter, line);
                illegalLinesHandling(line);
            }
        }
    }

    private static void illegalLinesHandling(String line) throws IOException {
        if (line.equals("Ups")) {
            throw new RuntimeException("Ups getippt!!");
        }
        if (line.equals("IOUps")) {
            throw new IOException("IOUps getippt!");
        }
    }

    private static void writeLine(BufferedWriter bufferedWriter, String line) throws IOException {
        bufferedWriter.write(line);
        bufferedWriter.newLine(); // Füge eine neue Zeile hinzu
        bufferedWriter.flush();
    }
}
