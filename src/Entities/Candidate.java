package Entities;

public class Candidate {
    private int id;
    private String name;
    private final int age;
    private Gender gender;
    private Party party;

    public Candidate(
            int id,
            String name,
            int age,
            Gender gender,
            Party party) {
        validateName(name);
        validateAge(age);
        validateGender(gender);
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        validateGender(gender);
        this.gender = gender;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    private void validateName(String name) throws  IllegalArgumentException{
        if (name == null || name.length() == 0){
            throw new IllegalArgumentException ("Não é permitido criar um candidato sem nome.");
        }
    }

    private void validateAge(int age){
        if(age < 18){
            throw new IllegalArgumentException ("Não é permitido criar um candidato menor de 18 anos.");
        }
    }

    private void validateGender(Gender gender){
        if(gender == null){
            throw new IllegalArgumentException ("Não é permitido criar um candidato sem gênero. Se nenhum dos " +
                    "disponíveis se encaixar, utilize \"OUTROS\".");
        }
    }
}
