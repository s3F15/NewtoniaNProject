package com.jeff.newtonianappproject;

public class Questionaires {

    public String questions[] = {
            "Scientists who study animals are called?",
            "Temperature Light, Air, Water, Soil and climate are ____ parts of the environment.",
            "The law of universal gravitation is credited to whom?",
            "How were the first modern humans(Homo Sapiens) different from any other hominid species?",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun",
            "4th Nearest planet to the Sun"
    };

    public String choices[][] = {
            {"Animalists", "Ecologists", "Zoologists", "Environmentalists"},
            {"Biotic", "Abiotic", "Boreal", "Living"},
            {"Einstein", "Beckett", "Rose", "Newton"},
            {"Lived outside Africa", "Used symbolic thought", "Controlled fire", "Large brain"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"},
            {"Mars", "Earth", "Venus", "Mercury"}

    };

    public String correctAnswer[] = {
            "Zoologists",
            "Abiotic",
            "Newton",
            "Controlled fire",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars",
            "Mars"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}