/** Урок 13 - Работа с потоками ввода-вывода
 * Практическое упражнение 15 - потоки ввода и вывода, работа с файлами
 * Написать класс, который содержит поля:
 * String text; // полный текст
 * List<String> bigWords; //слова, в которых кол-во букв > 6
 * Данные для создания экземпляра класса считываются из файла.
 * (Файл наполняется текстом вручную). Кол-во символов в данном
 * файле не должен превышать 128 символов. Во время обработки
 * полученного текста необходимо избавиться от всех знаков
 * препинания и перевести все символы в нижний регистр.
 * Необходимо записать в новый файл текст и все слова из списка
 * bigWords (вывести bigWords через пробел после основного текста)
 */
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("data/anekdot.txt");
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter("data/processing.txt");
             BufferedWriter bw = new BufferedWriter(fw))
        {
            /*int letter;
            while ((letter = fr.read()) != -1) {
                System.out.print((char) letter);
            }*/
            StringBuilder sb = new StringBuilder();
            int i;
            while ((i = br.read()) != -1) sb.append((char) i);
            System.out.println(">>> text length = " + sb.length());
            TextProcessing tp = new TextProcessing(sb.toString());
            bw.write(tp.toString());

            System.out.println("\n>>> Исходный текст\n");
            System.out.println(sb.toString());
            System.out.println("\n>>> Текст после обработки\n");
            System.out.println(tp.toString());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
