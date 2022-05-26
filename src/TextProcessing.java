import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextProcessing {
    String text; // полный текст
    List<String> bigWords; //слова, в которых кол-во букв > 6

    public TextProcessing() {
        this.bigWords = new ArrayList<>();
    }

    public TextProcessing(String text) {
        this.bigWords= new ArrayList<>();
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void fillBigWords(String srcText) {
        // слова длинной более 6 символов
        Pattern p = Pattern.compile("([а-яА-ЯёЁa-zA-Z]{7,})");
        //Matcher m = p.matcher(this.text);
        Matcher m = p.matcher(srcText);
        bigWords.clear();
        while(m.find()) bigWords.add(m.group());
    }

    public void setText(String text) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        // \pP - знаки пунктуации
        // (?U) все символы Юникода
        this.text = text.toLowerCase(Locale.ROOT).replaceAll("(?U)[\\pP]", "");
        fillBigWords(text); // передаем исходный текст без изменений
    }

    public List<String> getBigWords() {
        return bigWords;
    }

    public void setBigWords(List<String> bigWords) {
        this.bigWords = bigWords;
    }

    @Override
    public String toString() {
        return text + "\n(bigWords) " + bigWords.stream().collect(Collectors.joining(", "));
    }
}
