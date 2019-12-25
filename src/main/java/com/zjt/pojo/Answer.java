package com.zjt.pojo;

public class Answer {

    private String answer0;

    private String answer1;

    private String answer2;

    private String answer3;

    private String answer4;

    private String answer5;

    private String answer6;

    private String answer7;

    private String answer8;

    private String answer9;


    public String getAnswer0() {
        return answer0;
    }

    public void setAnswer0(String answer0) {
        this.answer0 = answer0;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }
    public String getAnswerByNumber(int number){
        String result = null;
       if(number == 0){
           result = this.getAnswer0();
       }
        if(number == 1){
            result = this.getAnswer1();
        }
        if(number == 2){
            result = this.getAnswer2();
        }
        if(number == 3){
            result = this.getAnswer3();
        }
        if(number == 4){
            result = this.getAnswer4();
        }
        if(number == 5){
            result = this.getAnswer5();
        }
        if(number == 6){
            result = this.getAnswer6();
        }
        if(number == 7){
            result = this.getAnswer7();
        }
        if(number == 8){
            result = this.getAnswer8();
        }
        if(number == 9){
            result = this.getAnswer9();
        }

       return result;
    }
    @Override
    public String toString() {
        return "Answer{" +
                "answer0='" + answer0 + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", answer5='" + answer5 + '\'' +
                ", answer6='" + answer6 + '\'' +
                ", answer7='" + answer7 + '\'' +
                ", answer8='" + answer8 + '\'' +
                ", answer9='" + answer9 + '\'' +
                '}';
    }
}
