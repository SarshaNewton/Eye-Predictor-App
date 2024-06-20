package com.example.possiblegenes;

public class Probability {
    double[] eyePercentage = {0,0,0};

    public double[] calculateProb(String parent1, String parent2){
        int[] temp = {0,0};
        if (parent1.equals("Brown") && parent2.equals("Brown")) {
            this.eyePercentage[0] = 75;
            this.eyePercentage[1] = 18.75;
            this.eyePercentage[2] = 6.25;
        }else if(parent1.equals("Green") && parent2.equals("Green")){
            this.eyePercentage[0] = 1;
            this.eyePercentage[1] = 75;
            this.eyePercentage[2] = 25;
        }else if(parent1.equals("Blue") && parent2.equals("Blue")){
            this.eyePercentage[0] = 0;
            this.eyePercentage[1] = 1;
            this.eyePercentage[2] = 99;
        }else if(parent1.equals("Blue") && parent2.equals("Green") || parent1.equals("Green") && parent2.equals("Blue")){
            eyePercentage[0] = 0;
            eyePercentage[1] = 50;
            eyePercentage[2] = 50;
        }else if(parent1.equals("Blue")  && parent2.equals("Brown") || parent1.equals("Brown") && parent2.equals("Blue")){
            eyePercentage[0] = 50;
            eyePercentage[1] = 0;
            eyePercentage[2] = 50;
        }else{
            eyePercentage[0] = 50;
            eyePercentage[1] = 37.5;
            eyePercentage[2] = 12.5;
        }
        return eyePercentage;
    }

}

