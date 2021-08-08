package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> list = readPhrases();
        List<String> log = new ArrayList<>();
        String userQuestion = "";
        boolean startStopBotAnswers = true;
        try (BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            do {
                userQuestion = br.readLine();
                log.add(String.format("-User: %s%s",
                        userQuestion, System.lineSeparator() + System.lineSeparator()));
                if (userQuestion.equals(STOP)) {
                    startStopBotAnswers = false;
                }
                if (userQuestion.equals(CONTINUE)) {
                    startStopBotAnswers = true;
                }
                if (startStopBotAnswers) {
                    int i = new Random().nextInt(list.size());
                    String botAnswer = list.get(i);
                    log.add(String.format("-Bot: %s%s",
                            botAnswer, System.lineSeparator() + System.lineSeparator()));
                    System.out.println(botAnswer);
                }
            } while (!(userQuestion.equals(OUT)));
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
          }
        }

    private List<String> readPhrases() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                    list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(path, StandardCharsets.UTF_8)
                )) {
            for (String s : log) {
                if (s != null) {
                    out.write(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("ConsoleChatText", "ConsoleChatBotAnswers");
        cc.run();
    }
}
