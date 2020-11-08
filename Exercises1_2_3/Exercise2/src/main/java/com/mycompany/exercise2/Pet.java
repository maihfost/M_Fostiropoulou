package com.mycompany.exercise2;

public class Pet {
    
    private String nickname;
    private String petType;
    static String [] petTypes={"dog","cat","turtle","rabbit","hamster","mouse","snake"
            ,"spider","elephant","tiger","liger","bird","fish","monkey","chameleon"};
    
    Pet(String nickname, String petType){
        this.nickname=nickname;
        this.petType=petType;
    }

    public String getPetType() {
        return petType;
    }
    
    public String getNickname(){
        return nickname;
    }

    public void setNickame(String nickame) {
        this.nickname = nickame;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return " A(n) " + petType + " who's Nickname is " + nickname;
    }
    
    

    static boolean petTypeExists(String searchForPetType){
        boolean x=false;
        for (String type:petTypes){
            x = searchForPetType.equals(type) ? true : false;
            if (x==true){
            break;
            }
        }
        if (x == false){
            System.out.println("Rare pet..Not Found!Do you want to add other pets?");
        }
        return x;
    } 
}
